package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Recipe(val title: String, val imageRes: Int)

private val RetroRed = Color(0xFFD32F2F)
private val RetroCream = Color(0xFFFFF8E1)

@Composable
fun HomeScreen(featuredRecipes: List<Recipe>, onRecipeClick: (Recipe) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("QuickRecipe", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                backgroundColor = RetroRed,
                contentColor
