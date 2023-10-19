package com.example.snackmapsgit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.snackmapsgit.ui.theme.SnackMapsGitTheme

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
        //text = webScrape.scrapeWalmart("https://www.walmart.com/store-finder?location=48854", activity),
        text = webScrape.scrapeWalmart("https://www.walmart.com/search?q=tortillas&typeahead=tort", activity),
        modifier = modifier
    )

}

fun Text(text: List<String>, modifier: Modifier) {

}


//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnackMapsGitTheme {
        //Greeting("Android")
    }
}