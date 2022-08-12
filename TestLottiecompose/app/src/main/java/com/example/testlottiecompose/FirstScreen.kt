package com.example.testlottiecompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.testlottiecompose.Utility.formatTime
import com.example.testlottiecompose.delegate.CountDownDelegate

@Composable
fun init(delegate: CountDownDelegate = CountDownDelegate()) {
    delegate.handleCountDownTimer()
    CountDownView(delegate)
}

@Composable
fun CountDownView(delegate: CountDownDelegate) {
    val time by delegate.time.observeAsState(Utility.TIME_COUNTDOWN.formatTime())

    CountDownView(
        time = time,
    )
}

@Composable
fun CountDownView(
    time: String,
) {
    CountDownIndicator(
        time = time
    )
}

@Composable
fun CountDownIndicator(
    time: String
) {
    val timeModel = Utility.getTimeModel(time)
    Row {
        Text(
            text = timeModel.hours.plus(":"),
            color = Color.Black,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = timeModel.minutes.plus(":"),
            color = Color.Black,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = timeModel.seconds,
            color = Color.Black,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )
    }
}
