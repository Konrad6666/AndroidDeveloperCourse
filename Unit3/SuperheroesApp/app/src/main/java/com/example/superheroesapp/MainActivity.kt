package com.example.superheroesapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.HeroesRepository
import com.example.superheroesapp.model.HeroesRepository.heroes
import com.example.superheroesapp.ui.theme.SuperheroesTheme
import com.example.superheroesapp.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroApp()
                }
            }
        }
    }
}

@Composable
fun HeroApp() {
    // A list of superheroes
    Scaffold(
        topBar = { HeroTopBar() },
        content = {
            LazyColumn(
                contentPadding = it,
                content = {
                    items(heroes) { hero ->
                        HeroCard(hero.nameRes, hero.descriptionRes,hero.imageRes)
                    }
                }
            )
        }
    )
}

@Composable
fun HeroCard(name: Int, description: Int,image: Int, modifier: Modifier = Modifier) {
    Card (
        elevation = CardDefaults.cardElevation(2.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(16.dp, 4.dp, 16.dp, 4.dp)
    ){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            HeroText(
                name = name,
                description = description,
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            HeroImage(
                image = painterResource(image),
                modifier = Modifier
            )
        }
    }
}

@Composable
fun HeroText(name: Int,description: Int, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
    ){
        Text(
            text = stringResource(id = name),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
        )
        Text(
            text = stringResource(id = description),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
        )
    }
}

@Composable
fun HeroImage(image: Painter, modifier: Modifier = Modifier) {
    Box(modifier = modifier){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(72.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme(darkTheme = true) {
        HeroApp()
    }
}