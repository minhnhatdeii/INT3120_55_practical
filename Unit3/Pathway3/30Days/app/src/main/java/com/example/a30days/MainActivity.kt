package com.example.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30days.data.ItemMN
import com.example.a30days.data.itemsMN
import com.example.a30days.ui.theme._30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    DayApp()
                }
            }
        }
    }
}

@Composable
fun DayApp() {
    Scaffold(
        topBar = {
            DayTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(itemsMN) {
                DayItem(
                    item = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun DayItem(
    item: ItemMN,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = item.day,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.displayLarge
                )
                Text(
                    text = stringResource(item.title),
                    fontSize = 30.sp,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.labelMedium

                )
                Button(
                    onClick = {
                        expanded = !expanded
                    }
                ){
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .clip(MaterialTheme.shapes.small)
                    ) {
                        Image(
                            painter = painterResource(item.imageResourceId),
                            contentDescription = null,
                            contentScale = ContentScale.Crop ,
                        )
                    }
                }
            }
            if (expanded) {
                Text(
                    text = stringResource(item.description),
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )

        },
        modifier = modifier
    )
}
@Preview
@Composable
fun DayPreview() {
    _30DaysTheme(darkTheme = true) {
        DayApp()
    }
}