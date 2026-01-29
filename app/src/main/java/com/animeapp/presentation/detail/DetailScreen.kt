package com.animeapp.presentation.detail

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.animeapp.presentation.components.AnimeAppBar
import com.animeapp.presentation.components.YouTubePlayerComposable

// Helper function to detect if URL is a YouTube URL
private fun isYouTubeUrl(url: String?): Boolean {
    if (url == null) return false
    return url.contains("youtube.com") || url.contains("youtu.be") || url.contains("youtube-nocookie.com")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var playerError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AnimeAppBar(
                title = "Anime Details",
                backgroundColor = MaterialTheme.colorScheme.primary,
                titleColor = MaterialTheme.colorScheme.onPrimary,
                navigationIcon = Icons.Default.ArrowBack,
                onNavigationClick = { navController.popBackStack() },
                actions = listOf(
                    {
                        if (state.anime != null) {
                            IconButton(onClick = { viewModel.toggleFavorite() }) {
                                Icon(
                                    imageVector = if (state.anime.isFavorite) {
                                        Icons.Default.Favorite
                                    } else {
                                        Icons.Default.FavoriteBorder
                                    },
                                    contentDescription = "Favorite",
                                    tint = if (state.anime.isFavorite) {
                                        Color.Red
                                    } else {
                                        MaterialTheme.colorScheme.onPrimary
                                    }
                                )
                            }
                        }
                    }
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (state.error.isNotBlank() && state.anime == null) {
                // Error state
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = state.error,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center
                    )
                }
            } else if (state.anime != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Video/Image section
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .background(Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
                        if (state.anime.trailerUrl != null && isYouTubeUrl(state.anime.trailerUrl)) {
                            if (playerError) {
                                // Fallback to WebView if YouTubePlayer fails
                                AndroidView(
                                    factory = { context ->
                                        WebView(context).apply {
                                            layoutParams = FrameLayout.LayoutParams(
                                                ViewGroup.LayoutParams.MATCH_PARENT,
                                                ViewGroup.LayoutParams.MATCH_PARENT
                                            )
                                            webViewClient = WebViewClient()
                                            settings.apply {
                                                javaScriptEnabled = true
                                                domStorageEnabled = true
                                                mediaPlaybackRequiresUserGesture = false
                                            }
                                            loadUrl(state.anime.trailerUrl)
                                        }
                                    },
                                    modifier = Modifier.fillMaxSize()
                                )
                            } else {
                                // Use YouTube player for YouTube videos
                                YouTubePlayerComposable(
                                    videoUrl = state.anime.trailerUrl,
                                    modifier = Modifier.fillMaxSize(),
                                    onError = { errorMsg ->
                                        playerError = true
                                    }
                                )
                            }
                        } else {
                            // Display poster image when no trailer is available
                            AsyncImage(
                                model = state.anime.imageUrl,
                                contentDescription = state.anime.title,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }

                    // Content section
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        // Title
                        Text(
                            text = state.anime.getDisplayTitle(),
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Rating and episodes row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            if (state.anime.score != null) {
                                InfoChip(
                                    icon = Icons.Default.Star,
                                    text = state.anime.getFormattedScore(),
                                    backgroundColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            }
                            
                            InfoChip(
                                text = state.anime.getFormattedEpisodes(),
                                backgroundColor = MaterialTheme.colorScheme.secondaryContainer
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Genres
                        if (state.anime.genres.isNotEmpty()) {
                            Text(
                                text = "Genres",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                state.anime.genres.take(3).forEach { genre ->
                                    Surface(
                                        color = MaterialTheme.colorScheme.tertiaryContainer,
                                        shape = RoundedCornerShape(16.dp)
                                    ) {
                                        Text(
                                            text = genre,
                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onTertiaryContainer
                                        )
                                    }
                                }
                            }
                            
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        // Synopsis
                        if (!state.anime.synopsis.isNullOrBlank()) {
                            Text(
                                text = "Synopsis",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = state.anime.synopsis,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
                            )
                            
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        // Studios
                        if (state.anime.studios.isNotEmpty()) {
                            DetailRow("Studio", state.anime.studios.joinToString(", "))
                        }

                        // Status
                        if (state.anime.status != null) {
                            DetailRow("Status", state.anime.status)
                        }

                        // Aired
                        if (state.anime.aired != null) {
                            DetailRow("Aired", state.anime.aired)
                        }

                        // Rating
                        if (state.anime.rating != null) {
                            DetailRow("Rating", state.anime.rating)
                        }
                    }
                }
            }

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun InfoChip(
    icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
    text: String,
    backgroundColor: Color
) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = Color(0xFFFFD700)
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
    }
}
