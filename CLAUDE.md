# DashDiet - DASH Diet Android App

## Project Overview
DashDiet is a modern Android app for the DASH (Dietary Approaches to Stop Hypertension) diet. It provides meal menus, recipes, a weekly meal planner, and authentication via Google & Apple Sign-In.

## Tech Stack
- **Language**: Kotlin
- **UI**: Jetpack Compose + Material 3 (Material You)
- **Architecture**: MVVM + Clean Architecture
- **Auth**: Firebase Authentication (Google Sign-In + Apple Sign-In)
- **DI**: Hilt (Dagger)
- **Navigation**: Jetpack Navigation Compose
- **Build**: Gradle Kotlin DSL
- **Min SDK**: 26 (Android 8.0), **Target SDK**: 34

## Project Structure
```
app/src/main/
├── java/com/dashdiet/app/
│   ├── DashDietApp.kt          # Application class (Hilt entry point)
│   ├── MainActivity.kt          # Single activity
│   ├── di/                       # Hilt modules
│   │   └── AppModule.kt
│   ├── data/
│   │   ├── model/                # Data classes (Recipe, MealPlan, etc.)
│   │   └── repository/           # RecipeRepository, MealPlanRepository
│   └── ui/
│       ├── theme/                # Material 3 theme (Color, Type, Shape, Theme)
│       ├── components/           # Reusable composables
│       ├── navigation/           # NavGraph, Screen sealed class, BottomNavBar
│       └── screens/              # Feature screens (auth, home, recipes, etc.)
└── res/
    ├── values/strings.xml        # English (default)
    ├── values-es/strings.xml     # Spanish
    ├── values-zh/strings.xml     # Chinese Simplified
    ├── values-hi/strings.xml     # Hindi
    ├── values-ar/strings.xml     # Arabic
    ├── values-fr/strings.xml     # French
    └── values-tr/strings.xml     # Turkish
```

## Build & Run
```bash
# Debug build
./gradlew assembleDebug

# Run tests
./gradlew test

# Install on device
./gradlew installDebug
```

## Key Features
1. **Auth Screen** - Google & Apple Sign-In
2. **Home Screen** - Daily tips, featured recipes, category quick access
3. **Recipe Browser** - Browse 30+ DASH diet recipes by category
4. **Recipe Detail** - Full recipe with ingredients, steps, nutrition info
5. **Meal Planner** - Weekly meal plan builder
6. **Profile/Settings** - Language switcher, account info, DASH diet guidelines

## Languages (7)
English, Spanish, Chinese (Simplified), Hindi, Arabic, French, Turkish

## Firebase Setup
1. Create a Firebase project at https://console.firebase.google.com
2. Add an Android app with package name `com.dashdiet.app`
3. Download `google-services.json` to `app/` directory
4. Enable Google Sign-In and Apple Sign-In in Firebase Authentication

## Recipe Categories
- Breakfast (8 recipes), Lunch (8), Dinner (8), Snacks (6) = 30 total
- All recipes follow DASH diet guidelines (low sodium, high potassium, whole grains)
