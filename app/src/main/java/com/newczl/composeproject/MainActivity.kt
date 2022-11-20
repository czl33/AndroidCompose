package com.newczl.composeproject

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.newczl.composeproject.page.WelcomePage
import com.newczl.composeproject.ui.theme.*

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setDecorFitsSystemWindows(false)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .size(10.dp),
                    color = MaterialTheme.colors.background
                ) {

                    Show()
                }
            }
        }
    }
}

var Data =  staticCompositionLocalOf { "Hhaha" }

@Preview
@Composable
fun Show() {
    Column {
        Row {
            CompositionLocalProvider( Data provides "cccccc"){
                Text(text = Data.current)
            }
            CompositionLocalProvider{
                Data provides "huhuhuhuh"
            }
            Text(text = Data.current)
        }
        Text(text = Data.current)
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hell ${name.max}!")
}


@Composable
fun DefaultPreview() {
    ComposeProjectTheme {
        Greeting("czl${"czl".max}")
    }
}


inline val String.max: String get() = this.plus("hahasaaaa")

