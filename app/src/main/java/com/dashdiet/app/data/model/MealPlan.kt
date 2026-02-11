package com.dashdiet.app.data.model

data class MealPlan(
    val weekDay: DayOfWeek,
    val breakfast: Recipe? = null,
    val lunch: Recipe? = null,
    val dinner: Recipe? = null,
    val snack: Recipe? = null
)

enum class DayOfWeek(val titleResId: Int, val shortResId: Int) {
    MONDAY(com.dashdiet.app.R.string.day_monday, com.dashdiet.app.R.string.day_mon),
    TUESDAY(com.dashdiet.app.R.string.day_tuesday, com.dashdiet.app.R.string.day_tue),
    WEDNESDAY(com.dashdiet.app.R.string.day_wednesday, com.dashdiet.app.R.string.day_wed),
    THURSDAY(com.dashdiet.app.R.string.day_thursday, com.dashdiet.app.R.string.day_thu),
    FRIDAY(com.dashdiet.app.R.string.day_friday, com.dashdiet.app.R.string.day_fri),
    SATURDAY(com.dashdiet.app.R.string.day_saturday, com.dashdiet.app.R.string.day_sat),
    SUNDAY(com.dashdiet.app.R.string.day_sunday, com.dashdiet.app.R.string.day_sun)
}
