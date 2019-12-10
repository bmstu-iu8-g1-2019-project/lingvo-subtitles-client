package com.example.lingvo

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lingvo.providers.WordsProvider
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun getTest() {
        val data = WordsProvider("SampleUser", "SamplePassword").getTest("Game of Thrones S1E1")
        Assert.assertFalse(data.isEmpty())
        Log.d("myLogs", data.toString())
    }

    @Test
    fun search() {
        val data = WordsProvider("SampleUser", "SamplePassword").search("Game of Thrones")
        Assert.assertFalse(data.isEmpty())
        Log.d("myLogs", data.toString())
    }
}
