package tw.edu.pu.dmwd.natalie.intent_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tw.edu.pu.dmwd.natalie.intent_compose.ui.theme.Intent_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Intent_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    Column(modifier = Modifier

        .fillMaxSize()

        .background(Color.Yellow),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Button(onClick = {

            navController.navigate("JumpSecond")

        }) {

            Image(painter = painterResource(id = R.drawable.map1) ,
                contentDescription ="indonesia" )

        }

    }

}

@Composable

fun SecondScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Button(onClick = {

            navController.navigate("JumpFirst")

        }) {

            Image(painter = painterResource(id = R.drawable.map2) ,
                contentDescription ="taiwan" )

        }


    }

}

@Composable
fun Greeting(name: String) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val showMenu = remember {

        mutableStateOf(false)

    }
    Column {

        TopAppBar(

            title = { Text(text = "Let's go to Taiwan & Indonesia!") },

            actions = {

                IconButton(

                    onClick = { Toast.makeText(context, "作者：锺爱丽", Toast.LENGTH_SHORT).show() }

                ) {

                    Icon(Icons.Rounded.AccountBox, contentDescription = "author")

                }
                IconButton(

                    onClick = { showMenu.value = true }

                ) {

                    Icon(Icons.Default.MoreVert, contentDescription = null)

                }
                DropdownMenu(

                    expanded = showMenu.value, onDismissRequest = { showMenu.value = false }

                ) {

                    DropdownMenuItem(

                        onClick = {

                            navController.navigate("JumpFirst")

                        })

                    {

                        Text(text = "Indonesia")

                    }

                    DropdownMenuItem(

                        onClick =

                        {

                            navController.navigate("JumpSecond")

                        })

                    {

                        Text(text = "Taiwan")

                    }



                }

            }

        )
        NavHost(navController = navController, startDestination = "JumpFirst") {

            composable("JumpFirst") {
                FirstScreen(navController = navController)

            }

            composable("JumpSecond") {

                SecondScreen(navController = navController)

            }


        }
    }
}

