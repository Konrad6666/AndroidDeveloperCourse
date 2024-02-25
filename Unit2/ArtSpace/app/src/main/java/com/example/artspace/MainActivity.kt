package com.example.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    ArtSpaceApp()
//                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var number by rememberSaveable { mutableIntStateOf(1) }
    var image = R.drawable.ic_launcher_foreground
    var title= R.string.artwork_title_1
    var artist= R.string.artwork_artist_and_year_1

    when (number) {
        1 -> {
            image = R.drawable.ic_launcher_foreground
            title = R.string.artwork_title_1
            artist = R.string.artwork_artist_and_year_1
        }
        2 -> {
            image = R.drawable.ic_launcher_background
            title = R.string.artwork_title_2
            artist = R.string.artwork_artist_and_year_2
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(0))
    ) {
        Spacer(modifier = Modifier.weight(1f))
        MainImage(image)
        Spacer(modifier = Modifier.weight(1f))
        TitleAndArtist(title, artist)
        PreviousNextButtons(
            onClickPrevious = {
                if (number < 2) {
                    number = 2
                } else {
                    number--
                }
            },
            onClickNext = {
                if (number > 1) {
                    number = 1
                } else {
                    number++
                }
            }
        )
    }
}

@Composable
fun TitleAndArtist(title: Int, artist:Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .shadow(5.dp, MaterialTheme.shapes.small)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp, 8.dp)
                .fillMaxWidth(0.9f)
        ) {
            Text(
                text = stringResource(title),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = stringResource(artist),
            )
        }
    }

}

@Composable
fun MainImage(
    drawableResourceId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(drawableResourceId),
        contentDescription = null,
        modifier = modifier
            .shadow(5.dp, MaterialTheme.shapes.medium)
            .size(300.dp)
    )
}

@Composable
fun PreviousNextButtons(onClickPrevious: () -> Unit, onClickNext: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 10.dp)
    ) {
        Buttons(
            onClick = onClickPrevious,
            text = "Previous"
        )
        Buttons(
            onClick = onClickNext,
            text = "Next"
        )
    }
}

@Composable
fun Buttons(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(16.dp)
            .width(150.dp)
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}