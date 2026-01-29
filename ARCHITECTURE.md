# Anime App - Visual Architecture

## 📱 Complete Project Structure

```
AnimeApp/
│
├── app/
│   ├── build.gradle.kts                    # App-level Gradle configuration
│   ├── proguard-rules.pro                  # ProGuard rules for release builds
│   │
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml         # App permissions and components
│       │   │
│       │   ├── java/com/animeapp/
│       │   │   │
│       │   │   ├── 📦 data/                # DATA LAYER
│       │   │   │   ├── local/              # Local data source (Room)
│       │   │   │   │   ├── entity/
│       │   │   │   │   │   └── AnimeEntity.kt
│       │   │   │   │   ├── AnimeDao.kt
│       │   │   │   │   ├── AnimeDatabase.kt
│       │   │   │   │   └── Converters.kt
│       │   │   │   │
│       │   │   │   ├── remote/             # Remote data source (API)
│       │   │   │   │   ├── dto/
│       │   │   │   │   │   └── AnimeDto.kt
│       │   │   │   │   └── JikanApi.kt
│       │   │   │   │
│       │   │   │   ├── mapper/             # Data transformations
│       │   │   │   │   └── AnimeMapper.kt
│       │   │   │   │
│       │   │   │   └── repository/         # Repository implementation
│       │   │   │       └── AnimeRepositoryImpl.kt
│       │   │   │
│       │   │   ├── 💼 domain/              # DOMAIN LAYER
│       │   │   │   ├── model/              # Business models
│       │   │   │   │   └── Anime.kt
│       │   │   │   │
│       │   │   │   ├── repository/         # Repository contracts
│       │   │   │   │   └── AnimeRepository.kt
│       │   │   │   │
│       │   │   │   └── usecase/            # Business logic
│       │   │   │       ├── GetTopAnimeUseCase.kt
│       │   │   │       └── GetAnimeDetailsUseCase.kt
│       │   │   │
│       │   │   ├── 🎨 presentation/        # PRESENTATION LAYER
│       │   │   │   ├── home/               # Home screen
│       │   │   │   │   ├── HomeScreen.kt   # UI
│       │   │   │   │   └── HomeViewModel.kt # State management
│       │   │   │   │
│       │   │   │   ├── detail/             # Detail screen
│       │   │   │   │   ├── DetailScreen.kt
│       │   │   │   │   └── DetailViewModel.kt
│       │   │   │   │
│       │   │   │   ├── navigation/         # Navigation graph
│       │   │   │   │   └── Navigation.kt
│       │   │   │   │
│       │   │   │   └── theme/              # App theming
│       │   │   │       ├── Theme.kt
│       │   │   │       └── Type.kt
│       │   │   │
│       │   │   ├── 🔧 di/                  # DEPENDENCY INJECTION
│       │   │   │   └── AppModule.kt        # Hilt modules
│       │   │   │
│       │   │   ├── 🛠️ util/                # UTILITIES
│       │   │   │   └── Resource.kt         # API state wrapper
│       │   │   │
│       │   │   ├── MainActivity.kt         # App entry point
│       │   │   └── AnimeApplication.kt     # Application class
│       │   │
│       │   └── res/                        # Android resources
│       │       ├── values/
│       │       │   ├── strings.xml
│       │       │   └── themes.xml
│       │       └── xml/
│       │           ├── backup_rules.xml
│       │           └── data_extraction_rules.xml
│       │
│       └── test/                           # Unit tests (TODO)
│           └── java/com/animeapp/
│
├── build.gradle.kts                        # Project-level Gradle
├── settings.gradle.kts                     # Gradle settings
├── gradle.properties                       # Gradle properties
│
├── 📄 Documentation
│   ├── README.md                          # Main documentation
│   ├── IMPLEMENTATION_NOTES.md            # Technical details
│   ├── QUICK_START.md                     # Getting started guide
│   └── .gitignore                         # Git ignore rules
│
└── 🚫 Generated (not in repo)
    ├── .gradle/                           # Gradle cache
    ├── .idea/                             # Android Studio
    ├── build/                             # Build outputs
    └── local.properties                   # Local SDK path
```

## 🔄 Data Flow Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                        PRESENTATION LAYER                        │
│                                                                  │
│  ┌────────────────┐              ┌────────────────┐            │
│  │  HomeScreen    │              │  DetailScreen  │            │
│  │   (Compose)    │              │   (Compose)    │            │
│  └───────┬────────┘              └───────┬────────┘            │
│          │                               │                      │
│          ▼                               ▼                      │
│  ┌────────────────┐              ┌────────────────┐            │
│  │  HomeViewModel │              │ DetailViewModel│            │
│  │   (StateFlow)  │              │   (StateFlow)  │            │
│  └───────┬────────┘              └───────┬────────┘            │
└──────────┼───────────────────────────────┼─────────────────────┘
           │                               │
           ▼                               ▼
┌─────────────────────────────────────────────────────────────────┐
│                         DOMAIN LAYER                             │
│                                                                  │
│  ┌──────────────────┐          ┌──────────────────────┐        │
│  │ GetTopAnimeUseCase│         │GetAnimeDetailsUseCase│        │
│  └────────┬──────────┘          └──────────┬───────────┘        │
│           │                                │                    │
│           └────────────────┬───────────────┘                    │
│                            ▼                                    │
│                  ┌──────────────────┐                          │
│                  │ AnimeRepository  │ (Interface)              │
│                  │   (Contract)     │                          │
│                  └─────────┬────────┘                          │
└────────────────────────────┼─────────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────────────┐
│                          DATA LAYER                              │
│                                                                  │
│              ┌────────────────────────────┐                     │
│              │  AnimeRepositoryImpl       │                     │
│              │   (Orchestrates data)      │                     │
│              └──────────┬────────┬────────┘                     │
│                         │        │                              │
│         ┌───────────────┘        └───────────────┐              │
│         ▼                                        ▼              │
│  ┌─────────────┐                         ┌─────────────┐       │
│  │ JikanApi    │                         │  AnimeDao   │       │
│  │ (Retrofit)  │                         │   (Room)    │       │
│  └──────┬──────┘                         └──────┬──────┘       │
│         │                                       │              │
│         ▼                                       ▼              │
│  ┌─────────────┐                         ┌─────────────┐       │
│  │  Internet   │                         │   SQLite    │       │
│  │     API     │                         │  Database   │       │
│  └─────────────┘                         └─────────────┘       │
└─────────────────────────────────────────────────────────────────┘

                             ▲
                             │
                    ┌────────┴────────┐
                    │  Hilt (DI)      │
                    │ Provides deps   │
                    └─────────────────┘
```

## 🎯 Component Interactions

### Home Screen Flow
```
User Opens App
    ↓
MainActivity Created
    ↓
HomeScreen Rendered
    ↓
HomeViewModel Initialized (via Hilt)
    ↓
GetTopAnimeUseCase Called
    ↓
AnimeRepository.getTopAnime()
    ↓
1. Query Room Database (AnimeDao)
    ↓
2. Emit Loading(cachedData)
    ↓
3. Call Jikan API (JikanApi)
    ↓
4. Map DTO → Entity (AnimeMapper)
    ↓
5. Save to Database (AnimeDao)
    ↓
6. Map Entity → Domain (AnimeMapper)
    ↓
7. Emit Success(freshData)
    ↓
ViewModel Updates State
    ↓
Compose Recomposes UI
    ↓
User Sees Updated List
```

### Detail Screen Flow
```
User Clicks Anime Card
    ↓
Navigation: home → detail/{animeId}
    ↓
DetailScreen Rendered
    ↓
DetailViewModel Initialized (via Hilt)
    ↓
savedStateHandle.get("animeId")
    ↓
GetAnimeDetailsUseCase Called
    ↓
AnimeRepository.getAnimeDetails(id)
    ↓
1. Query Database by ID
    ↓
2. Emit Loading(cachedAnime)
    ↓
3. Fetch from API
    ↓
4. Update Database
    ↓
5. Emit Success(anime)
    ↓
ViewModel Updates State
    ↓
UI Shows Details + Video
```

## 🔌 Dependency Injection Graph

```
Application
    ↓
AppModule (Hilt Module)
    ├── Provides OkHttpClient
    │       ↓
    ├── Provides JikanApi (Retrofit)
    │       ↓
    ├── Provides AnimeDatabase (Room)
    │       ↓
    ├── Provides AnimeDao
    │       ↓
    └── Provides AnimeRepository
            ↓
    ┌───────┴───────┐
    ↓               ↓
UseCases       ViewModels
    ↓               ↓
Repository     Screens
```

## 📦 Key Libraries and Roles

```
┌─────────────────────────────────────────────────────────┐
│                    LIBRARY ECOSYSTEM                     │
├─────────────────────────────────────────────────────────┤
│                                                          │
│  UI Layer:                                               │
│  ├── Jetpack Compose       → Declarative UI            │
│  ├── Material 3            → Design system              │
│  ├── Coil                  → Image loading              │
│  └── Media3 (ExoPlayer)    → Video playback            │
│                                                          │
│  Architecture:                                           │
│  ├── ViewModel             → State management           │
│  ├── Navigation            → Screen routing             │
│  └── Hilt                  → Dependency injection       │
│                                                          │
│  Data:                                                   │
│  ├── Room                  → Local database             │
│  ├── Retrofit              → HTTP client                │
│  ├── OkHttp                → Network layer              │
│  └── Gson                  → JSON parsing               │
│                                                          │
│  Async:                                                  │
│  ├── Coroutines            → Async programming          │
│  └── Flow                  → Reactive streams           │
│                                                          │
└─────────────────────────────────────────────────────────┘
```

## 🎨 UI Component Hierarchy

```
MainActivity
    └── AnimeAppTheme
        └── Surface
            └── Navigation
                │
                ├── HomeScreen
                │   ├── Scaffold
                │   │   ├── TopAppBar
                │   │   └── LazyVerticalGrid
                │   │       └── AnimeCard (×N)
                │   │           ├── AsyncImage
                │   │           ├── Gradient Overlay
                │   │           ├── Score Badge
                │   │           └── Title/Episodes
                │   │
                │   └── ErrorHandling
                │       ├── Error Banner
                │       └── Retry Button
                │
                └── DetailScreen
                    ├── Scaffold
                    │   ├── TopAppBar (with back)
                    │   └── ScrollableColumn
                    │       ├── VideoPlayer/Image
                    │       ├── Title Section
                    │       ├── Rating Chips
                    │       ├── Genre Tags
                    │       ├── Synopsis
                    │       └── Detail Rows
                    │
                    └── Favorite Button
```

## 🔐 Security & Permissions

```
AndroidManifest.xml
    ├── INTERNET                    → API calls
    ├── ACCESS_NETWORK_STATE        → Connection check
    └── usesCleartextTraffic        → HTTP support
```

## 📊 State Management Pattern

```
ViewModel (Source of Truth)
    ↓
StateFlow<UiState>
    ↓
    ├── Loading State
    │   ├── isLoading: true
    │   └── data: cachedData
    │
    ├── Success State
    │   ├── isLoading: false
    │   └── data: freshData
    │
    └── Error State
        ├── isLoading: false
        ├── data: cachedData
        └── error: message
            ↓
Composable Observes
    ↓
UI Recomposes
```

## 🔄 Offline-First Strategy

```
                    User Request
                         ↓
            ┌────────────┴────────────┐
            │                         │
    Check Local DB              Has Network?
            │                         │
            ↓                         ↓
    Emit Loading(cached)        Try API Call
            │                         │
            │                    ┌────┴────┐
            │                    │         │
            │               Success    Failure
            │                    │         │
            │              Update DB    Return
            │                    │      Cached
            │                    ↓         │
            └──────────→ Emit Result ←────┘
                            ↓
                      Update UI
```

## 🎯 Key Features Visualization

```
┌──────────────────────────────────────────────────────┐
│                   ANIME APP FEATURES                  │
├──────────────────────────────────────────────────────┤
│                                                       │
│  ✅ Top Anime List        ✅ Offline Mode            │
│     - Grid Layout            - Room Database         │
│     - Lazy Loading           - Cache-First           │
│     - Score Badges           - Auto Sync             │
│                                                       │
│  ✅ Anime Details         ✅ Error Handling          │
│     - Video Player           - Network Errors        │
│     - Synopsis               - Graceful Degradation  │
│     - Genres/Studios         - Retry Mechanism       │
│                                                       │
│  ✅ Favorites             ✅ Material Design 3       │
│     - Persistent             - Dark/Light Theme      │
│     - Toggle                 - Smooth Animations     │
│     - Room Storage           - Custom Colors         │
│                                                       │
└──────────────────────────────────────────────────────┘
```

This visual guide provides a complete overview of the app's architecture, data flow, and component organization!
