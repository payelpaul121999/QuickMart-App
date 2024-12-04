package com.ats.quickmart.onBoard.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ats.quickmart.R
import com.ats.quickmart.ui.theme.primaryContainerLightMediumContrast
import com.ats.quickmart.ui.theme.secondaryLight


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    /*BottomNavigation(
        // set background color
        backgroundColor = Color(0xFF0F9D58)
    ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
       Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            BottomNavigationItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false
            )
        }
    }*/
    val items = listOf(
        BottomNavItemStatic("Home", R.drawable.ic_home_dish, route = "home"),
        BottomNavItemStatic("Profile", R.drawable.baseline_search_24,  route = "search"),
        BottomNavItemStatic("Offer", R.drawable.ic_offer,   route = "offer"),
        BottomNavItemStatic("Cart", R.drawable.ic_cart,   route = "cart"),
        BottomNavItemStatic("Profile", R.drawable.ic_profile_selected,   route = "profile")
    )
    var selectedIndex by remember { mutableStateOf(0) } // Keep track of selected index

    BottomNavigation(
        backgroundColor = primaryContainerLightMediumContrast,
       // contentColor = Color.Gray
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.name,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(item.name) },
                selected = selectedIndex == index,
                selectedContentColor = Color.Blue, // Color for selected item
                unselectedContentColor = Color.Gray, // Color for unselected items
                onClick = {
                    selectedIndex = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class BottomNavItemStatic(
    val name: String,
    val iconRes: Int,
    val route:String
)


/*object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = Icons.Filled.Home,
            route = "home"
        ),
        BottomNavItem(
            label = "Search",
            icon = Icons.Filled.Search,
            route = "search"
        ),
        BottomNavItem(
            label = "Search",
            icon = Icons.Filled.Search,
            route = "search"
        ),
        BottomNavItem(
            label = "Profile",
            icon = Icons.Filled.Person,
            route = "profile"
        )
    )
}*/



/*data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route:String,
)*/

