package com.example.snackmapsgit

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.snackmapsgit.ui.theme.SnackMapsGitTheme
import java.util.*;

class MainActivity : ComponentActivity() {
    var test: String = "start";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackMapsGitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(test,this)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, activity: MainActivity, modifier: Modifier = Modifier) {
    var webScrape = WebScraping();
    Text(
        text = "Hello $name!" + webScrape.getScrapeInBackground("https://www.walmart.com/ip/Doritos-Nacho-Cheese-Tortilla-Snack-Chips-Party-Size-14-5-oz-Bag/433078517?from=/search", activity),
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnackMapsGitTheme {
        //Greeting("Android")
    }
}