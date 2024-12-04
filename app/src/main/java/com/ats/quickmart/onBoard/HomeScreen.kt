package com.ats.quickmart.onBoard

import com.ats.quickmart.R

sealed class HomeScreen(
    val route: String,
    val selectedIcon: Int? = null,
    val unSelectedIcon: Int? = null
) {
    data object Home : HomeScreen(
        route = "home_screen", selectedIcon = R.drawable.ic_home_selected,
        unSelectedIcon = R.drawable.ic_home_selected,
    )

    data object WinScreen : HomeScreen(
        route = "win_screen", selectedIcon = R.drawable.ic_result,
        unSelectedIcon = R.drawable.ic_result,
    )

    data object YourBetScreen : HomeScreen(
        route = "your_bet_screen", selectedIcon = R.drawable.ic_trophy,
        unSelectedIcon = R.drawable.ic_trophy,
    )


    data object ContactUsScreen : HomeScreen(
        route = "contact_us_screen", selectedIcon = R.drawable.ic_contact,
        unSelectedIcon = R.drawable.ic_contact,
    )

    data object ProfileScreen : HomeScreen(
        route = "profile_screen", selectedIcon = R.drawable.ic_profile_selected,
        unSelectedIcon = R.drawable.ic_profile_selected,
    )

    fun withArgs(vararg args: Any?): String {
        val string = buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
        return string
    }

}