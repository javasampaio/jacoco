package br.com.sampaio.jacocoexample.dynamicfeature

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DynamicMainActivityTest {

    private lateinit var activityScenario: ActivityScenario<DynamicMainActivity>

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(DynamicMainActivity::class.java)
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun onViewComponents() {
        Espresso.onView(ViewMatchers.withId(R.id.dynamic_fab)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}