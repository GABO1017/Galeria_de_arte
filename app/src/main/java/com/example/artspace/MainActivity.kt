package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.width
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    var order by remember { mutableStateOf(1) }

    val imageResource = when (order) {
        1 -> R.drawable.foto1
        2 -> R.drawable.foto2
        3 -> R.drawable.foto3
        4 -> R.drawable.foto4
        5 -> R.drawable.foto5
        6 -> R.drawable.foto6
        7 -> R.drawable.foto7
        8 -> R.drawable.foto8
        9 -> R.drawable.foto9
        10 -> R.drawable.foto10
        else -> R.drawable.foto10
    }

    val titleResource = when (order) {
        1 -> R.string.foto1
        2 -> R.string.foto2
        3 -> R.string.foto3
        4 -> R.string.foto4
        5 -> R.string.foto5
        6 -> R.string.foto6
        7 -> R.string.foto7
        8 -> R.string.foto8
        9 -> R.string.foto9
        10 -> R.string.foto10
        else -> R.string.foto10
    }

    val yearResource = when (order) {
        1 -> R.string.year1
        2 -> R.string.year2
        3 -> R.string.year3
        4 -> R.string.year4
        5 -> R.string.year5
        6 -> R.string.year6
        7 -> R.string.year7
        8 -> R.string.year8
        9 -> R.string.year9
        10 -> R.string.year10
        else -> R.string.year10
    }

    val descriptionResource = when (order) {
        1 -> R.string.descripcion1
        2 -> R.string.descripcion2
        3 -> R.string.descripcion3
        4 -> R.string.descripcion4
        5 -> R.string.descripcion5
        6 -> R.string.descripcion6
        7 -> R.string.descripcion7
        8 -> R.string.descripcion8
        9 -> R.string.descripcion9
        10 -> R.string.descripcion10
        else -> R.string.descripcion10
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        ArtworkTitle(
            title = R.string.empty,
            year = R.string.name,
            description = R.string.code,
        )
        Spacer(
            modifier = modifier.size(5.dp)
        )
        ArtworkImage(
            currentArtwork = imageResource
        )
        Spacer(
            modifier = modifier.size(5.dp)
        )
        ArtworkTitle(
            title = titleResource,
            description = descriptionResource,
            year = yearResource,
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier.padding(horizontal = 6.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick ={
                    if (order == 1) {
                        order = 10
                    }else{
                        order -= 1

                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.purple_500),
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(R.string.previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }

            Button(
                onClick ={
                    order = 1
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_300),
                    containerColor = colorResource(id = R.color.magenta)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.reinicia),
                    contentDescription = stringResource(R.string.boton_refresh),
                    modifier = Modifier.size(30.dp)
                )
            }

            Button(
                onClick = {
                    if (order == 10) {
                        order = 1
                    }else{
                        order+= 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.purple_500),
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Surface(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp),
    ) {
        Image(
            painter = painterResource(id = currentArtwork),
            contentDescription = null,
            modifier = modifier
                .padding(50.dp)
                .fillMaxWidth()
                .shadow(elevation = 10.dp,
                    shape = MaterialTheme.shapes.medium,
                    spotColor = Color.Black
                ),
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes description: Int,
    @StringRes year: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.purple_200),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.purple_200),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.purple_200),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

