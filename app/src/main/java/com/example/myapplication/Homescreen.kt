package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.ui.theme.RetroRed
import com.example.myapplication.ui.theme.RetroCream

val Pacifico = FontFamily(Font(R.font.pacifico_regular))
val Rubik = FontFamily(Font(R.font.rubik_regular))

data class Recipe(val title: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(featuredRecipes: List<Recipe>, onRecipeClick: (Recipe) -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "QuickRecipe",
                        style = TextStyle(
                            fontFamily = Pacifico,
                            fontSize = 26.sp,
                            color = Color.White
                        )
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = RetroRed
                )
            )
        },
        containerColor = RetroCream
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "Featured Recipes",
                style = TextStyle(
                    fontFamily = Rubik,
                    fontSize = 20.sp,
                    color = RetroRed,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(featuredRecipes) { recipe ->
                    RecipeCard(recipe = recipe, onClick = { onRecipeClick(recipe) })
                }
            }
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .width(200.dp)
            .height(260.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = recipe.imageRes),
                contentDescription = recipe.title,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = recipe.title,
                style = TextStyle(
                    fontFamily = Rubik,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = RetroRed
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val sampleRecipes = listOf(
        Recipe("Retro Burger", R.drawable.sample_recipe),
        Recipe("Creamy Ramen", R.drawable.sample_recipe),
        Recipe("Taco Fiesta", R.drawable.sample_recipe),
        Recipe("Golden Waffles", R.drawable.sample_recipe)
    )
    HomeScreen(featuredRecipes = sampleRecipes, onRecipeClick = {})
}
