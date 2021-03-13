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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Category
import com.example.androiddevchallenge.data.Exercise
import com.example.androiddevchallenge.data.mockBodyExercises
import com.example.androiddevchallenge.data.mockCategories
import com.example.androiddevchallenge.data.mockMindExercises
import com.example.androiddevchallenge.ui.DefaultPlaceholder
import com.example.androiddevchallenge.ui.common.NetworkImage

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        var search by remember { mutableStateOf("") }

        TextField(
            value = search,
            onValueChange = { search = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            },
            placeholder = { DefaultPlaceholder(hint = stringResource(R.string.search)) },
            textStyle = MaterialTheme.typography.body1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onSurface,
                backgroundColor = MaterialTheme.colors.surface
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 56.dp, start = 16.dp, end = 16.dp),
        )

        Text(
            text = stringResource(R.string.favorite_collections),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(40.dp)
                .padding(horizontal = 16.dp),
        )

        CategoryList(categories = mockCategories)

        Text(
            text = stringResource(R.string.align_body),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp)
                .padding(horizontal = 16.dp),
        )

        ExerciseList(exercises = mockBodyExercises)

        Text(
            text = stringResource(R.string.align_mind),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(40.dp)
                .padding(horizontal = 16.dp),
        )

        ExerciseList(exercises = mockMindExercises)

        Spacer(modifier = Modifier.height(128.dp))
    }
}

@Composable
fun CategoryList(categories: List<Category>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        content = {
            itemsIndexed(categories) { index, category ->
                if (index < categories.size / 2) {
                    Column {
                        CategoryItem(category = categories[index])
                        Spacer(modifier = Modifier.height(8.dp))
                        CategoryItem(category = categories[categories.size / 2 + index])
                    }
                }
            }
        },
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    )
}

@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = modifier.size(width = 192.dp, height = 56.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.surface)
        ) {
            NetworkImage(
                url = category.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .width(56.dp)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = category.title,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun ExerciseList(exercises: List<Exercise>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp),
        content = {
            items(exercises) { exercise ->
                ExerciseItem(exercise = exercise)
            }
        },
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    )
}

@Composable
fun ExerciseItem(
    exercise: Exercise,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        NetworkImage(
            url = exercise.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(shape = CircleShape)
                .width(88.dp)
                .aspectRatio(1f)
        )
        Text(
            text = exercise.name,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
    }
}
