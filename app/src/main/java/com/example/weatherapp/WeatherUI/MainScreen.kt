package com.example.weatherapp.WeatherUI

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@SuppressLint("InvalidColorHexValue")
@Composable
fun WeatherApp(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF59469d), Color(0xFF643d67)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    AppName()
                    CloudImage()
                    TimeDate()
                    Temperature()
                    LowAndHigh()
                    WeatherDetails()
                    Today()
                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(items) { item ->
                            FutureModel(model = item)
                        }
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Future",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Next 7 days",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                items(futureItems) {
                    FutureDetails(item = it)
                }
            }
        }
    }
}

@Composable
fun AppName() {
    Text(
        text = "Mostly Cloudy",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun CloudImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.cloudy_sunny),
        contentDescription = null,
        modifier
            .size(150.dp)
            .padding(top = 8.dp)
    )
}

@Composable
fun TimeDate() {
    Text(
        text = "Mon Oct 21 | 09:30 AM",
        fontSize = 19.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Temperature() {
    Text(
        text = "33°C",
        fontSize = 63.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun LowAndHigh() {
    Text(
        text = "H:35 L:25",
        fontSize = 16.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun WeatherDetails() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .background(
                color = colorResource(id = R.color.purple), shape = RoundedCornerShape(25.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WeatherItems(
                icon = R.drawable.rain, value = "30%", label = "Rain"
            )
            WeatherItems(
                icon = R.drawable.wind, value = "25%", label = "Wind Speed"
            )
            WeatherItems(
                icon = R.drawable.humidity, value = "20%", label = "Humidity"
            )
        }
    }
}

@Composable
fun WeatherItems(icon: Int, value: String, label: String) {
    Column(
        modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon), contentDescription = null
        )
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )
        Text(
            text = label, color = colorResource(id = R.color.white), textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Today() {
    Text(
        text = "Monday",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    )
}


val items = listOf(
    HourlyModel("9 pm", 28, "cloudy"),
    HourlyModel("10 pm", 29, "sunny"),
    HourlyModel("11 pm", 30, "wind"),
    HourlyModel("12 pm", 31, "rainy"),
    HourlyModel("1 am", 32, "storm"),
)

@Composable
fun FutureModel(model: HourlyModel) {
    Column(
        modifier = Modifier
            .width(90.dp)
            .wrapContentHeight()
            .padding(4.dp)
            .background(
                color = colorResource(id = R.color.purple), shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = model.hour,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(
                id = when (model.picPath) {
                    "cloudy" -> R.drawable.cloudy
                    "sunny" -> R.drawable.sunny
                    "wind" -> R.drawable.wind
                    "rainy" -> R.drawable.rainy
                    "storm" -> R.drawable.storm

                    else -> {
                        R.drawable.cloudy
                    }
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "${model.temp}°",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

val futureItems = listOf(
    FutureModel("Mon", "storm", "storm", 26, 12),
    FutureModel("Tue", "cloudy", "cloudy", 28, 16),
    FutureModel("Wed", "windy", "windy", 30, 15),
    FutureModel("Thu", "cloudy sunny", "cloudy sunny", 33, 18),
    FutureModel("Fri", "sunny", "sunny", 27, 20),
    FutureModel("Sat", "rainy", "rainy", 25, 11),
    FutureModel("Sun", "windy", "windy", 31, 23),
)

@Composable
fun FutureDetails(item: FutureModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.day, fontSize = 14.sp, color = Color.White
        )
        Image(
            painter = painterResource(id = drawableResource(picPath = item.picPath)),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 32.dp)
                .size(45.dp)
        )
        Text(
            text = item.status,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            color = Color.White,
            fontSize = 14.sp
        )
        Text(
            text = "${item.highTemp}°",
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            color = Color.White,
            fontSize = 14.sp
        )
        Text(
            text = "${item.lowTemp}°",
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            color = Color.White,
            fontSize = 14.sp
        )

    }
}

@Composable
fun drawableResource(picPath: String): Int {
    return when (picPath) {
        "storm" -> R.drawable.storm
        "cloudy" -> R.drawable.cloudy
        "windy" -> R.drawable.windy
        "cloudy_sunny" -> R.drawable.cloudy_sunny
        "rainy" -> R.drawable.rainy
        "sunny" -> R.drawable.sunny
        else -> {
            R.drawable.sunny
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WeatherAppPreview() {
    WeatherApp()
}