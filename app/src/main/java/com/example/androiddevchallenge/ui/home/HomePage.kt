/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.AppDestinations
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

sealed class BottomNavScreen(
    val route: String,
    @StringRes val tabTitleStringRes: Int,
    val tabIcon: ImageVector
) {
    object Home : BottomNavScreen(
        route = AppDestinations.BottomNavDestinations.HOME_ROUTE,
        tabTitleStringRes = R.string.home,
        tabIcon = Icons.Default.Spa
    )

    object Profile : BottomNavScreen(
        route = AppDestinations.BottomNavDestinations.PROFILE,
        tabTitleStringRes = R.string.profile,
        tabIcon = Icons.Default.AccountCircle
    )
}

private val bottomTabs = listOf(
    BottomNavScreen.Home,
    BottomNavScreen.Profile,
)

@Composable
fun HomePage() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                Modifier.navigationBarsHeight(additional = 56.dp)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                bottomTabs.forEachIndexed { index, screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = screen.tabIcon,
                                contentDescription = stringResource(id = screen.tabTitleStringRes)
                            )
                        },
                        label = { Text(text = stringResource(id = screen.tabTitleStringRes)) },
                        selected = currentRoute == screen.route,
                        selectedContentColor = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .background(color = MaterialTheme.colors.background)
                            .navigationBarsPadding(),
                        onClick = {
                            navController.navigate(screen.route) {
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(color = MaterialTheme.colors.onBackground)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = MaterialTheme.colors.background,
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true

    ) {
        NavHost(
            navController = navController,
            startDestination = AppDestinations.BottomNavDestinations.HOME_ROUTE
        ) {
            composable(AppDestinations.BottomNavDestinations.HOME_ROUTE) {
                HomeScreen()
            }
            composable(AppDestinations.BottomNavDestinations.PROFILE) {
                ProfileScreen()
            }
        }
    }
}
