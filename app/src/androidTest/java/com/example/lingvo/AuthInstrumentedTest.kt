package com.example.lingvo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lingvo.providers.WordsProvider
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthInstrumentedTest {
    @Test
    fun login() {
        Assert.assertTrue(WordsProvider().checkUser("SampleUser", "SamplePassword"))
        Assert.assertFalse(WordsProvider().checkUser("NotSampleUser", "SamplePassword"))
        Assert.assertFalse(WordsProvider().checkUser("NotSampleUser", "NotSamplePassword"))
    }
}
