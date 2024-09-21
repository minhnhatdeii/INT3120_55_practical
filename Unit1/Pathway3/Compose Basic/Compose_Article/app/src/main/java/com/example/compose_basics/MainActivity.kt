package com.example.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_basics.ui.theme.Compose_BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_BasicsTheme {
                Surface (
                    modifier = Modifier.focusGroup(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Greeting(
                        title = "Jetpack Compose tutorial",
                        text1 = "Jetpack Compose is a modern toolkit for building" +
                                " native Android UI. Compose simplifies and accelerates " +
                                " development on Android with less code, powerful tools, and " +
                                "intuitive Kotlin APIs.",
                        text2 = "In this tutorial, you build a simple UI component with declarative " +
                                "functions. You call Compose functions to say what elements you want and " +
                                "the Compose compiler does the rest. Compose is built around Composable " +
                                "functions. These functions let you define your app\\'s UI programmatically " +
                                "because they let you describe how it should look and provide data dependencies, " +
                                "rather than focus on the process of the UI\\'s construction, such as " +
                                "initializing an element and then attaching it to a parent. To create a " +
                                "Composable function, you add the @Composable annotation to the function name.",

                    )
                }

            }
        }
    }
}

@Composable
fun Greeting(title: String, text1: String, text2: String, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.image1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
        //Title
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(16.dp),
        )
        //Text 1
        Text(
            text = text1,
            modifier = modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            textAlign = TextAlign.Justify
        )
        //Text 2
        Text(
            text = text2,
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicsTheme {
        Greeting(
            title = "Jetpack Compose tutorial",
            text1 = "Jetpack Compose is a modern toolkit for building" +
                    " native Android UI. Compose simplifies and accelerates " +
                    " development on Android with less code, powerful tools, and " +
                    "intuitive Kotlin APIs.",
            text2 = "In this tutorial, you build a simple UI component with declarative " +
                    "functions. You call Compose functions to say what elements you want and " +
                    "the Compose compiler does the rest. Compose is built around Composable " +
                    "functions. These functions let you define your app\\'s UI programmatically " +
                    "because they let you describe how it should look and provide data dependencies, " +
                    "rather than focus on the process of the UI\\'s construction, such as " +
                    "initializing an element and then attaching it to a parent. To create a " +
                    "Composable function, you add the @Composable annotation to the function name."
        )
    }
}