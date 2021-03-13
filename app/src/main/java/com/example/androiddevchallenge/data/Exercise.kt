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

data class Exercise(
    val id: Int,
    val name: String,
    val imageUrl: String
)

val mockBodyExercises = listOf(
    Exercise(
        id = 1,
        name = "Inversions",
        imageUrl = "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 2,
        name = "Quick Yoga",
        imageUrl = "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 3,
        name = "Stretching",
        imageUrl = "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 4,
        name = "Tabata",
        imageUrl = "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 5,
        name = "HILT",
        imageUrl = "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 6,
        name = "Pre-natal yoga",
        imageUrl = "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    )
)

val mockMindExercises = listOf(
    Exercise(
        id = 1,
        name = "Meditate",
        imageUrl = "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
    ),
    Exercise(
        id = 2,
        name = "With kids",
        imageUrl = "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 3,
        name = "Aromatherapy",
        imageUrl = "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 4,
        name = "On the go",
        imageUrl = "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 5,
        name = "With pets",
        imageUrl = "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Exercise(
        id = 6,
        name = "High stress",
        imageUrl = "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    )
)
