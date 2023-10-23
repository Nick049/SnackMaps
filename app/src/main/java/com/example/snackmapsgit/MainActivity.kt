package com.example.snackmapsgit

import android.os.Bundle
import android.provider.ContactsContract
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


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
                ListOfEntires()

            }
        }
    }
}

@Composable
fun ListOfEntires(){
    TestText()
}

@Composable
fun TestText() {
    Column {
    Row(modifier = Modifier.padding(all = 8.dp)) {
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
            Text("Product: Doritos")
            Text("Price: irrelevant")
            Text("Location: walmart")
        }
    }
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            //prints image file in drawables
            painter = painterResource(R.drawable.lalatortillas),
            contentDescription = "LaLa's Tortillas",
            modifier = Modifier
                //sets image size
                .size(150.dp)
        )
        //created space between image and text
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text("Product: LaLa's tortillas")
            Text("Price: irrelevant")
            Text("Location: walmart")
        }
    }
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                //prints image file in drawables
                painter = painterResource(R.drawable.missiontortillas10big),
                contentDescription = "Mission Tortillas",
                modifier = Modifier
                    //sets image size
                    .size(150.dp)
            )
            //created space between image and text
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text("Product: Mission tortillas")
                Text("Price: irrelevant")
                Text("Location: Walmart")
            }
        }
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                //prints image file in drawables
                painter = painterResource(R.drawable.tortillas26oz),
                contentDescription = "Tortillas",
                modifier = Modifier
                    //sets image size
                    .size(150.dp)
            )
            //created space between image and text
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text("Product: Great Value Tortillas")
                Text("Price: irrelevant")
                Text("Location: Walmart")
            }
        }

}
}



@Composable
fun ProductPlacer(product: String, type: String, location: String, address: String) {
    Column {
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
            Column{
                Text("$product")
                Text("$type")
                Text("$location")
            }
        }
    }



}

