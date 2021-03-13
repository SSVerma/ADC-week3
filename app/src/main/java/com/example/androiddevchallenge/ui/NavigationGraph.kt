/*
 * Copyright 2020 The Android Open Source Project
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
package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.home.HomePage

object AppDestinations {
    const val WELCOME_ROUTE = "welcome"
    const val LOGIN_ROUTE = "login"
    const val HOME_PAGE_ROUTE = "home_page"

    object BottomNavDestinations {
        const val HOME_ROUTE = "home"
        const val PROFILE = "profile"
    }
}

@Composable
fun NavigationGraph(startDestination: String = AppDestinations.WELCOME_ROUTE) {
    val navController = rememberNavController()

    val actions = remember(navController) { AppNavigationActions(navController = navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestinations.WELCOME_ROUTE) {
            WelcomeScreen(
                onSignUpClicked = {
                    actions.onWelcomeComplete()
                },
                onLoginClicked = {
                    actions.onWelcomeComplete()
                }
            )
        }
        composable(AppDestinations.LOGIN_ROUTE) {
            LoginScreen(
                onLoginSuccess = {
                    actions.onLoginComplete()
                }
            )
        }
        composable(AppDestinations.HOME_PAGE_ROUTE) {
            HomePage()
        }
    }
}

class AppNavigationActions(navController: NavHostController) {
    val onWelcomeComplete: () -> Unit = {
        navController.navigate(AppDestinations.LOGIN_ROUTE)
    }
    val onLoginComplete: () -> Unit = {
        navController.navigate(AppDestinations.HOME_PAGE_ROUTE)
    }
    val onBackPress: () -> Unit = {
        navController.navigateUp()
    }
}
