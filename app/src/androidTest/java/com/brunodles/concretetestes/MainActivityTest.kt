package com.brunodles.concretetestes

import android.app.Activity
import android.app.Instrumentation
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun whenLogin_withoutUsername_shouldShowInvalidUsernameMessage() {
        R.id.input_password.typeText("123123")

        "Login".click()

        "Empty username".isDisplayed()
    }

    @Test
    fun whenLogin_withoutPassword_shouldShowInvalidPasswordMessage() {
        R.id.input_username.typeText("123123")

        "Login".click()

        "Empty password".isDisplayed()
    }

    @Test
    fun whenLogin_withValidUsername_andPassword_shouldCallHomeActivity() {
        Intents.init()
        val homeActivityIntentMatcher = IntentMatchers.hasComponent(HomeActivity::class.java.name)
        intending(homeActivityIntentMatcher).respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))

        R.id.input_username.typeText("lucascampos")
        R.id.input_password.typeText("Ab.45678")

        R.id.btn_login.click()

        intended(homeActivityIntentMatcher)

        Intents.release()
    }

    @Test
    fun whenLogin_withInvalidPassword_shouldShowInvalidLoginOrPasswordMessage() {
        R.id.input_username.typeText("lucascampos")
        R.id.input_password.typeText("1234567")

        R.id.btn_login.click()

        "Invalid username or password".isDisplayed()
    }

    @Test
    fun whenOpen_shouldStartWithEmptyUsername_andPassword() {
        R.id.label_login.isDisplayed()
        R.id.label_passsword.isDisplayed()
    }
}






