package br.com.sampaio.jacocoexemple

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ScrollView
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import br.com.sampaio.jacocoexample.R

@RestrictTo(RestrictTo.Scope.TESTS)
class SingleFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val useScroll = intent.extras?.getBoolean(USE_SCROLL_KEY) ?: false

        val content = if (useScroll) {
            ScrollView(this).apply {
                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                isFillViewport = true
                addView(frameLayout())
            }
        } else {
            frameLayout()
        }

        setContentView(content)
    }

    private fun frameLayout() = FrameLayout(this).apply {
        layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        id = R.id.content_frame
    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.content_frame, fragment, "TEST")
            .commit()
    }

    fun addFragmentWithShowMethod() {
        supportFragmentManager.beginTransaction()
            .commit()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, fragment).commit()
    }

    fun addDialogFragment(dialog: AppCompatDialogFragment) {
        dialog.show(supportFragmentManager, "dialog")
    }

    companion object {
        private const val USE_SCROLL_KEY = "use_scroll"

        fun intentWithScroll() =
            Intent().putExtra(USE_SCROLL_KEY, true)
    }
}
