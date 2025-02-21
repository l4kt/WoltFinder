# WoltFinder

WoltFinder is an Android application that displays a list of venues based on the user's location. 
The app updates the venue list dynamically every 10 seconds and provides an option to mark venues as favorites. 
It utilizes Jetpack Compose for UI development and includes automated tests for core functionalities.

## Features

- **Real-time Venue Listing:** Display 15 venues and automatically update venue data every 10 seconds.
- **Favorite Venues:** Users can mark/unmark venues as favorites.
- **Smooth UI Animations:** Jetpack Compose provides a seamless UI experience.
- **Unit Testing:** Comprehensive tests for API services, repositories, etc.

## Project Structure

```
📂 wolt-finder-app/
│
├── 📂 app/                     # Root application module
│   ├── 📂 src/main/
│   │   ├── 📂 java/com/l4kt/woltfinder/
│   │   │   ├── 📂 data/         # Data Layer (Repository, Network, Models)
│   │   │   │   ├── 📂 api/      # Network API services
│   │   │   │   │   ├── ApiService.kt
│   │   │   │   │   ├── RetrofitInstance.kt
│   │   │   │   │
│   │   │   │   ├── 📂 model/    # Data Models
│   │   │   │   │   ├── ApiResponse.kt
│   │   │   │   │   ├── Venue.kt
│   │   │   │   │   ├── Image.kt
│   │   │   │   │
│   │   │   │   ├── 📂 repository/ # Repository layer
│   │   │   │   │   ├── Repository.kt
│   │   │   │   │
│   │   │   ├── 📂 presentation/  # Presentation Layer (UI + ViewModels)
│   │   │   │   ├── 📂 ui/         # Jetpack Compose UI components
│   │   │   │   │   ├── VenueListScreen.kt
│   │   │   │   │   ├── VenueList.kt
│   │   │   │   │   ├── VenueItem.kt
│   │   │   │   │   ├── TopAppBar.kt
│   │   │   │   │   ├── Theme.kt
│   │   │   │   │   ├── Type.kt
│   │   │   │   │   ├── FavoriteIcons.kt
│   │   │   │   │
│   │   │   │   ├── 📂 viewmodel/   # ViewModels (Business Logic)
│   │   │   │   │   ├── VenueViewModel.kt
│   │   │   │   │
│   │   │   ├── 📂 utils/           # Utility classes/helpers
│   │   │   │   ├── SharedPreferencesHelper.kt
│   │   │   │
│   │   │   ├── MainActivity.kt     # Main entry point of the app
│   │   │
│   │   ├── 📂 res/                  # Resources (xml, drawables, etc.)
│   │   │   ├── drawable/
│   │   │   ├── layout/
│   │   │   ├── values/
│   │   │
│   │   ├── AndroidManifest.xml      # App manifest
│   │
│   ├── 📂 src/test/                  # Unit tests
│   │   ├── com/l4kt/woltfinder/
│   │   │   ├── RepositoryTest.kt
│   │   │   ├── ApiServiceTest.kt
│   │   │   ├── VenueViewModelTest.kt
│   │   │   ├── SharedPreferencesHelperTest.kt
│   │
│   ├── 📂 src/androidTest/            # Instrumented tests
│   │   ├── com/l4kt/woltfinder/
│   │   │   ├── 
│   │
│   ├── build.gradle.kts               # Project build script
│   ├── libs.versions.toml               # Dependency versions
│
└── README.md                           # Project documentation

```

## Prerequisites

Ensure you have the following installed:

- [Android Studio](https://developer.android.com/studio) (Latest version)
- Java 17 or later
- Kotlin 1.9 or later
- Gradle 8.10+
- Android SDK API Level 35

## Installation

1. **Open the project in Android Studio:**
    - Launch Android Studio.
    - Select **"Open an existing project"**, and navigate to the project's root directory.

2. **Sync dependencies:**
    - Ensure all Gradle dependencies are downloaded by clicking `Sync Now` when prompted.

3. **Run the project:**
    - Connect an Android device or use an emulator.
    - Click on `Run > Run 'app'` in Android Studio.

## Running Tests

The project includes various tests to ensure code reliability:

- **Unit Tests:**
  ```bash
  ./gradlew testDebugUnitTest
  ```

Tests include:

- `ApiServiceTest.kt` - Tests network interactions.
- `VenueViewModelTest.kt` - Tests ViewModel business logic.
- `RepositoryTest.kt` - Ensures data retrieval from the repository.
- `SharedPreferencesHelperTest.kt` - Tests shared preferences functionality.

## Technologies Used

- **Jetpack Compose** - UI development.
- **Retrofit** - API requests.
- **Kotlin Coroutines** - Asynchronous operations.
- **MockK** - Unit testing.
- **Robolectric** - Unit tests for Android components.


## Known Issues & Debugging

If you encounter any issues:

- Ensure dependencies are up-to-date by running:
  ```bash
  ./gradlew dependencies
  ```
- Clear the build cache:
  ```bash
  ./gradlew clean
  ```
- Check the `logcat` output in Android Studio for debugging.

---

### Author

This project was built by Iniobong Equere.
