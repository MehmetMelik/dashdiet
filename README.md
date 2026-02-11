# DashDiet

A modern Android app for the DASH (Dietary Approaches to Stop Hypertension) diet, featuring meal planning, recipes, and nutritional guidance.

## Features

- **30+ DASH Diet Recipes** across Breakfast, Lunch, Dinner, and Snacks categories
- **Weekly Meal Planner** with daily nutritional totals
- **Detailed Nutrition Info** including calories, sodium, potassium, fiber, protein, fat, and carbs
- **Recipe Search & Filtering** by category and keyword
- **DASH Diet Guidelines** with benefits, daily servings, and tips
- **Google & Apple Sign-In** via Firebase Authentication
- **7 Language Support** — English, Spanish, Chinese, Hindi, Arabic, French, Turkish
- **Material You** theming with dark mode support

## Screenshots

*Coming soon*

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose + Material 3 |
| Architecture | MVVM + Clean Architecture |
| DI | Hilt (Dagger) |
| Auth | Firebase Authentication |
| Navigation | Jetpack Navigation Compose |
| Build | Gradle Kotlin DSL |

## Requirements

- Android Studio Hedgehog or later
- Min SDK 26 (Android 8.0)
- Target SDK 34

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/MehmetMelik/dashdiet.git
   ```

2. Copy the Firebase config template and add your credentials:
   ```bash
   cp app/google-services.json.template app/google-services.json
   ```

3. Fill in your Firebase project details in `app/google-services.json`

4. Build and run:
   ```bash
   ./gradlew assembleDebug
   ```

## Project Structure

```
app/src/main/java/com/dashdiet/app/
├── data/
│   ├── model/          # Recipe, MealPlan, User data classes
│   └── repository/     # RecipeRepository, MealPlanRepository
├── di/                 # Hilt dependency injection modules
└── ui/
    ├── components/     # RecipeCard, NutritionBadge, SearchBar, etc.
    ├── navigation/     # NavGraph, Screen routes, BottomNavBar
    ├── screens/
    │   ├── auth/       # Google & Apple Sign-In
    │   ├── dashinfo/   # DASH diet guidelines
    │   ├── home/       # Daily tips & featured recipes
    │   ├── mealplan/   # Weekly meal planner
    │   ├── profile/    # Settings & language switcher
    │   └── recipes/    # Recipe list & detail
    └── theme/          # Material 3 colors, typography, shapes
```

## License

This project is for educational purposes.
