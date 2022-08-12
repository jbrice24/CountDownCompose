/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.testlottiecompose

import java.util.concurrent.TimeUnit
import kotlin.contracts.Returns

object Utility {

    // time to countdown - 1hr - 60secs
    const val TIME_COUNTDOWN: Long = 7200000
    private const val TIME_FORMAT = "%02d:%02d:%02d"

    // convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toHours(this),
        TimeUnit.MILLISECONDS.toMinutes(this) % 60,
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

    fun getTimeModel(time: String) : TimeModel {
        val splitTime = time.split(":")

        if(splitTime.size == 3) {
            return TimeModel(
                hours = splitTime[0],
                minutes = splitTime[1],
                seconds = splitTime[2]
            )
        } else {
            return TimeModel(
                hours = "00",
                minutes = "00",
                seconds = "00"
            )
        }
    }
}
