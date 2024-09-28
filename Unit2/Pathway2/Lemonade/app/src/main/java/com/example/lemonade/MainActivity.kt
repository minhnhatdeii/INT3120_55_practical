package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {
    var count by remember { mutableStateOf(1)}
    var ramdomNumber by remember { mutableStateOf(2)}
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFFFFF33)
                )
            )
        }

    ){innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (count) {
                1 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = {
                                count++
                                ramdomNumber = (2..4).random()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF66FF66), // Màu nền mặc định
                            ),
                            shape = RoundedCornerShape(40.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_tree),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(128.dp)
                                    .padding(24.dp)

                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(R.string.Lemon_tree),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                2 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = {
                                if (ramdomNumber > 0) {
                                    ramdomNumber --
                                } else {
                                    count ++
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF66FF66), // Màu nền mặc định
                            ) ,
                            shape = RoundedCornerShape(40.dp)

                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_squeeze),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(128.dp)
                                    .padding(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(R.string.Lemon),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                3 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = {
                                count ++
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF66FF66), // Màu nền mặc định
                            ) ,
                            shape = RoundedCornerShape(40.dp)

                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_drink),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(128.dp)
                                    .padding(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(R.string.Glass_of_lemonade),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                4 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(
                            onClick = {
                                count = 1
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF66FF66), // Màu nền mặc định
                            ) ,
                            shape = RoundedCornerShape(40.dp)

                        ) {
                            Image(
                                painter = painterResource(R.drawable.lemon_restart),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(128.dp)
                                    .padding(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(R.string.Empty_glass),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}