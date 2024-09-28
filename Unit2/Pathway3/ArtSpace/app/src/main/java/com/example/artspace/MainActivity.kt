package com.example.artspace

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {

    var numberArtWord by remember { mutableStateOf(1) }

    Column (
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        when(numberArtWord) {
            1-> artWorkDisplay(
                drawableResID = R.drawable.luffy,
                nameRes = R.string.luffy_name,
                pirateRes = R.string.luffy_pirate,

            )
            2-> artWorkDisplay(
                drawableResID = R.drawable.buggy,
                nameRes = R.string.buggy_name,
                pirateRes = R.string.buggy_pirate,

            )
            3-> artWorkDisplay(
                drawableResID = R.drawable.blackbeard,
                nameRes = R.string.blackbeard_name,
                pirateRes = R.string.blackbeard_pirate,

            )
            4-> artWorkDisplay(
                drawableResID = R.drawable.shank,
                nameRes = R.string.shank_name,
                pirateRes = R.string.shank_pirate,

            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(90.dp, Alignment.CenterHorizontally)
        ) {
            // Previous Button
            Button(
                onClick = {
                    numberArtWord--
                    if (numberArtWord < 1) {
                        numberArtWord = 4
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3EAEF4)
                ),
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            // Next Button
            Button(
                onClick = {
                    numberArtWord ++
                    if (numberArtWord > 4) {
                        numberArtWord = 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3EAEF4)
                ),
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}


@Composable
fun artWorkDisplay(
    @DrawableRes drawableResID: Int,
    @StringRes nameRes: Int,
    @StringRes pirateRes: Int,
) {
    Column (
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 35.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier
                .height(450.dp)
                .width(350.dp)
                .shadow(10.dp, shape = RoundedCornerShape(8.dp))
                .padding(
                    top = 40.dp,
                    bottom = 30.dp,
                    start = 30.dp,
                    end = 30.dp
                )
        ){
            Image(
                painter = painterResource(drawableResID),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop

            )
        }
        Spacer(Modifier.height(16.dp))
        Column (
            modifier = Modifier.background(Color(0xFFE0E0E0))
                .padding(
                    top = 20.dp,
                    bottom = 10.dp,
                    start = 30.dp,
                    end = 30.dp
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Artwork title
            Text(
                text = stringResource(nameRes),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            // Artwork year
            Text(
                text = stringResource(pirateRes),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}
@Preview (showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}