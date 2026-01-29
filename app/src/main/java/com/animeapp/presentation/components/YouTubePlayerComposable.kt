package com.animeapp.presentation.components

import android.util.Log
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

/**
 * Composable wrapper for YouTube video player with error handling
 * @param videoUrl YouTube video URL or embed URL
 * @param modifier Modifier for the composable
 * @param onPlayerReady Callback when player is ready
 * @param onError Callback when player encounters an error
 */
@Composable
fun YouTubePlayerComposable(
    videoUrl: String,
    modifier: Modifier = Modifier,
    onPlayerReady: ((YouTubePlayer) -> Unit)? = null,
    onError: ((String) -> Unit)? = null
) {
    var hasError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        if (hasError) {
            // Error UI
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "⚠️",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Video Unavailable",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            AndroidView(
                factory = { context ->
                    YouTubePlayerView(context).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                            override fun onReady(youTubePlayer: YouTubePlayer) {
                                val videoId = extractYouTubeVideoId(videoUrl)
                                Log.d("YouTubePlayer", "Extracted video ID: $videoId from URL: $videoUrl")

                                if (videoId != null) {
                                    youTubePlayer.loadVideo(videoId, 0f)
                                } else {
                                    hasError = true
                                    errorMessage = "Invalid video URL format"
                                    onError?.invoke(errorMessage)
                                }
                                onPlayerReady?.invoke(youTubePlayer)
                            }

                            override fun onError(
                                youTubePlayer: YouTubePlayer,
                                error: PlayerConstants.PlayerError
                            ) {
                                Log.e("YouTubePlayer", "Player error: $error")
                                hasError = true
                                errorMessage = when (error) {
                                    PlayerConstants.PlayerError.HTML_5_PLAYER -> "HTML5 player not found"
                                    PlayerConstants.PlayerError.UNKNOWN -> "Unknown player error"
                                    PlayerConstants.PlayerError.INVALID_PARAMETER_IN_REQUEST -> "Invalid player host"
                                    else -> "Video unavailable (${error.ordinal})"
                                }
                                onError?.invoke(errorMessage)
                            }

                            override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {
                                Log.d("YouTubePlayer", "Loading video: $videoId")
                            }

                            override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {
                                // Video is playing
                            }

                            override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {
                                Log.d("YouTubePlayer", "Video duration: $duration seconds")
                            }
                        })
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/**
 * Extract YouTube video ID from various URL formats
 * Supports:
 * - https://www.youtube.com/watch?v=VIDEO_ID
 * - https://youtu.be/VIDEO_ID
 * - https://www.youtube.com/embed/VIDEO_ID
 * - https://www.youtube-nocookie.com/embed/VIDEO_ID
 */
private fun extractYouTubeVideoId(url: String): String? {
    val patterns = listOf(
        """(?:youtube\.com\/watch\?v=|youtu\.be\/|youtube\.com\/embed\/|youtube-nocookie\.com\/embed\/)([a-zA-Z0-9_-]{11})""".toRegex(),
        """(?:youtube\.com\/watch\?.*&v=)([a-zA-Z0-9_-]{11})""".toRegex()
    )

    for (pattern in patterns) {
        val match = pattern.find(url)
        if (match != null) {
            return match.groupValues.getOrNull(1)
        }
    }

    return null
}
