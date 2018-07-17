package com.baseapp.molina.ale.baseapp

import com.baseapp.molina.ale.baseapp.utils.CommonUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(CommonUtils.isEmailValid("name@email.com"))
    }
}
