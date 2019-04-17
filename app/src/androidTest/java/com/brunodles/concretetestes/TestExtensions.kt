package com.brunodles.concretetestes

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers

// Performs
fun Int.click() { Espresso.onView(ViewMatchers.withId(this)).perform(ViewActions.click()) }
fun String.click() { Espresso.onView(ViewMatchers.withText(this)).perform(ViewActions.click()) }
fun Int.typeText(message: String) { Espresso.onView(ViewMatchers.withId(this)).perform(ViewActions.typeText(message)) }

// Checks
fun Int.isDisplayed() { Espresso.onView(ViewMatchers.withId(this)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())) }
fun String.isDisplayed() { Espresso.onView(ViewMatchers.withText(this)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())) }
