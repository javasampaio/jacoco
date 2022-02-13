package br.com.sampaio.jacocoexample

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.sampaio.jacocoexemple.SingleFragmentActivity
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SecondFragmentTest {
    private lateinit var activityScenario: ActivityScenario<SingleFragmentActivity>

    private lateinit var navControllerMock: NavController

    @Before
    fun setup() {
        navControllerMock = mockk(relaxed = true)
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun onViewFragment() {
        startFragment()

        Espresso.onView(ViewMatchers.withId(R.id.button_second)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun startFragment() {
        activityScenario = ActivityScenario.launch(SingleFragmentActivity::class.java)

        val fragment = SecondFragment()
        activityScenario.onActivity {
            mockNavController(fragment)
            it.addFragment(fragment)
        }
    }

    private fun mockNavController(fragment: Fragment) {
        fragment.viewLifecycleOwnerLiveData.observeForever { owner ->
            owner?.apply {
                Navigation.setViewNavController(fragment.requireView(), navControllerMock)
            }
        }
    }
}