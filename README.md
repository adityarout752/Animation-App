# Anime App 🎌

## Video


https://github.com/user-attachments/assets/ddc5b2ea-f8ae-466d-ac03-1ed34f086565



A modern Android application built with Kotlin and Jetpack Compose that displays anime series using the Jikan API. Features include offline support, video trailers, and an attractive Material Design 3 UI.

## 📱 Features

- **Browse Top Anime**: View a curated list of top-rated anime series
- **Search Anime**: Search for anime by title with real-time results
  - Instant search as you type
  - Clear button to reset and return to top anime
  - Integrated search bar in home screen
- **Detailed Information**: Access comprehensive details including:
  - Video trailers (with ExoPlayer integration)
  - Synopsis and plot information
  - Genre tags
  - Studio information
  - Episode count and airing status
  - MyAnimeList scores
- **Offline Mode**: Full offline functionality with Room database caching
- **Favorites**: Mark anime as favorites for quick access
- **Error Handling**: Graceful error handling with retry mechanisms
- **Adaptive UI**: Beautiful Material Design 3 interface that adapts to light/dark themes

## 🏗️ Architecture

This app follows **MVVM Clean Architecture** principles with clear separation of concerns:

```
app/
├── data/                    # Data Layer
│   ├── local/              # Room Database
│   │   ├── entity/         # Database entities
│   │   ├── AnimeDao.kt     # Data Access Object
│   │   └── AnimeDatabase.kt
│   ├── remote/             # API Layer
│   │   ├── dto/            # Data Transfer Objects
│   │   └── JikanApi.kt     # Retrofit API service
│   ├── mapper/             # Entity/DTO/Domain mappers
│   └── repository/         # Repository implementation
│
├── domain/                  # Domain Layer
│   ├── model/              # Domain models
│   ├── repository/         # Repository interfaces
│   └── usecase/            # Business logic use cases
│       ├── GetTopAnimeUseCase.kt
│       ├── GetAnimeDetailsUseCase.kt
│       └── SearchAnimeUseCase.kt
│
├── presentation/            # Presentation Layer
│   ├── home/               # Home screen
│   │   ├── HomeScreen.kt
│   │   └── HomeViewModel.kt
│   ├── detail/             # Detail screen
│   │   ├── DetailScreen.kt
│   │   └── DetailViewModel.kt
│   ├── navigation/         # Navigation setup
│   └── theme/              # UI theme and styling
│
└── di/                      # Dependency Injection
    └── AppModule.kt        # Hilt modules
```

### Layer Responsibilities

#### Data Layer
- **Local**: Room database for offline caching
- **Remote**: Retrofit for API communication
- **Repository**: Implements domain repository interfaces, coordinates between local and remote sources

#### Domain Layer
- **Models**: Pure Kotlin data classes representing business entities
- **Repository**: Contracts/interfaces for data operations
- **Use Cases**: Single-responsibility business logic operations

#### Presentation Layer
- **ViewModels**: Manage UI state and business logic
- **Screens**: Jetpack Compose UI components
- **Navigation**: Screen navigation flow

## 🛠️ Tech Stack

### Core
- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern declarative UI framework
- **Material Design 3** - Latest Material Design guidelines

### Architecture Components
- **ViewModel** - Lifecycle-aware state management
- **Navigation Component** - Type-safe navigation
- **Hilt** - Dependency injection
- **Coroutines** - Asynchronous programming
- **Flow** - Reactive data streams

### Network & Data
- **Retrofit** - REST API client
- **OkHttp** - HTTP client with logging
- **Gson** - JSON serialization/deserialization
- **Room** - Local database with SQLite

### Media & UI
- **Coil** - Image loading library
- **ExoPlayer (Media3)** - Video playback
- **Material Icons** - Icon set



## 🔌 API Integration

The app uses the **Jikan API v4**

## 💾 Offline Support

The app implements a **cache-first strategy**:

1. **On Launch**: Check local database first
2. **If Cache Exists**: Display cached data immediately
3. **In Background**: Fetch fresh data from API
4. **On Success**: Update cache and UI
5. **On Failure**: Continue showing cached data with error banner


## 🎨 UI/UX Features

### Home Screen
- **Search Bar**: Real-time anime search with clear functionality
  - Search icon (leading icon)
  - Auto-clear button when text is entered
  - Transparent Material Design 3 styling
  - Instant filtering as you type
  - Returns to top anime when cleared
- **Grid Layout**: 2-column grid for efficient space usage
- **Card Design**: Elevated cards with rounded corners
- **Image Loading**: Smooth image loading with Coil
- **Score Badges**: Visual rating indicators
- **Gradient Overlays**: Enhanced readability on images

### Detail Screen
- **Video Player**: Integrated ExoPlayer for trailers
- **Fallback Images**: Shows poster if trailer unavailable
- **Rich Content**: Comprehensive anime information
- **Genre Tags**: Visual genre indicators
- **Favorite Toggle**: Heart icon for favorites
- **Scrollable Content**: Smooth vertical scrolling

### Theming
- **Light/Dark Mode**: Automatic theme switching
- **Custom Colors**: Anime-themed color palette
- **Material 3**: Latest Material Design components
- **Consistent Spacing**: 8dp grid system


### UI Response
- **Error Banner**: Shows error message while displaying cached data
- **Retry Button**: Allows users to retry failed operations
- **Loading Indicators**: Clear loading states

## 🔄 State Management

The app uses **Unidirectional Data Flow (UDF)**:

```
User Action → ViewModel → Use Case → Repository → API/Database
     ↑                                                      ↓
     └──────────── UI State Update ←──────────────────────┘
```
## 📐 Design Patterns Used

1. **MVVM**: Separation of UI and business logic
2. **Repository Pattern**: Single source of truth for data
3. **Use Case Pattern**: Encapsulated business logic
4. **Dependency Injection**: Loose coupling with Hilt
5. **Observer Pattern**: Reactive UI updates with Flow
6. **Factory Pattern**: ViewModel creation
7. **Singleton Pattern**: Database and API instances



## 📦 Dependencies

See `app/build.gradle.kts` for complete dependency list.


## 🙏 Acknowledgments

- **Copilot**: Took help from copilot for Making this project
- **Material Design**: For design guidelines
- **Android Community**: For excellent documentation and libraries


