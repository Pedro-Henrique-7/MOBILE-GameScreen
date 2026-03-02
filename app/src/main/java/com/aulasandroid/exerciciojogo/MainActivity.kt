package com.aulasandroid.exerciciojogo

import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.exerciciojogo.ui.theme.ExercicioJogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercicioJogoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

//                    ScreenGameOver(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                    )
                    ScreenGame(
                        modifier = Modifier
                            .padding(innerPadding)
                    )


                }
            }
        }
    }
}

@Composable
fun ScreenGame(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()

            .background(color = Color.Black),
    ) {
        TopBar(modifier = Modifier)

        Column(
            modifier = modifier
                .height(128.dp),
            verticalArrangement = Arrangement.Center,

            )
        {
            MainAndroidRow(
                modifier = Modifier,
                size = 82.dp,
                horizontalArrangement = Arrangement.SpaceBetween
            )


        }
        Column(
            modifier = modifier
                .weight(1f, true)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlaneShooter(modifier = modifier.size(86.dp), color = Color.White)
            Text(
                modifier = modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth(),
                text = "PRESS START",
                textAlign = TextAlign.Center,
                fontSize = 45.sp,
                color = Color.White

            )
        }
    }
}

@Composable
fun ScreenGameOver(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.Center
    ) {
        MainAndroidRow(
            modifier = Modifier,
            size = 52.dp,
            horizontalArrangement = Arrangement.Center
        )
        Text(
            text = "GAME OVER",
            color = Color.White,
            fontSize = 48.sp


        )
    }
}

@Composable
fun AndroidEnemy(modifier: Modifier = Modifier, color: Color) {
    Image(
        contentDescription = "Android Enemy",
        painter = painterResource(R.drawable.ic_android_black_24dp),
        modifier = modifier,
        colorFilter = ColorFilter.tint(color),
    )
}


@Composable
fun PlaneShooter(modifier: Modifier = Modifier, color: Color) {

    Image(
        contentDescription = "Shooter",
        painter = painterResource(id = R.drawable.outline_align_justify_space_even_24),
        modifier = modifier,
        colorFilter = ColorFilter.tint(color),


        )
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier,
                text = "SCORE: 0050",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "LIVES:",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(18.dp),
                color = Color.Green
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(18.dp),
                color = Color.Green
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(18.dp),
                color = Color.Green
            )
        }
    }


}

@Composable
fun MainAndroidRow(
    modifier: Modifier = Modifier,
    size: Dp,
    horizontalArrangement: Arrangement.Horizontal
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = horizontalArrangement
    ) {
        AndroidEnemy(
            modifier = Modifier
                .size(size),
            color = Color.Green
        )
        AndroidEnemy(
            modifier = Modifier
                .size(size),
            color = Color.Red
        )
        AndroidEnemy(
            modifier = Modifier
                .size(size),
            color = Color.Blue
        )
        AndroidEnemy(
            modifier = Modifier
                .size(size),
            color = Color.Yellow
        )
        AndroidEnemy(
            modifier = Modifier
                .size(size),
            color = Color.Green
        )
    }
}