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
package com.example.androiddevchallenge.data

data class Category(
    val id: Int,
    val title: String,
    val imageUrl: String
)

val mockCategories = listOf(
    Category(
        id = 1,
        title = "Short mantras",
        imageUrl = "https://images.pexels.com/photos/2748817/pexels-photo-2748817.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=350"
    ),
    Category(
        id = 2,
        title = "Nature Meditation",
        imageUrl = "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Category(
        id = 3,
        title = "Stress and anxiety",
        imageUrl = "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Category(
        id = 4,
        title = "Self-massage",
        imageUrl = "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Category(
        id = 5,
        title = "Overwhelmed",
        imageUrl = "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Category(
        id = 6,
        title = "Nightly wind down",
        imageUrl = "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    )
)
