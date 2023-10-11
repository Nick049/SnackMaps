package com.example.snackmapsgit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.snackmapsgit.ui.theme.SnackMapsGitTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackMapsGitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {}
                TestText()
                TestText()
            }
        }
    }
}

@Composable
fun TestText() {
    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(
            //prints image file in drawables
            painter = painterResource(R.drawable.doritos),
            contentDescription = "doritos",
            modifier = Modifier
            //sets image size
            .size(150.dp)
        )
        //created space between image and text
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text("Doritos")
            Text("Nacho Cheese")
            Text("Location: walmart")
        }
    }
}

@Composable
fun ProductPlacer(product: String, type: String, location: String, address: String) {
    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(
            //prints image file in drawables
            painter = painterResource(R.drawable.doritos),
            contentDescription = "doritos",
            modifier = Modifier
                //sets image size
                .size(150.dp)
        )
        //created space between image and text
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text("$product")
            Text("$type")
            Text("$location")
            Text( "$address")
        }
    }


}