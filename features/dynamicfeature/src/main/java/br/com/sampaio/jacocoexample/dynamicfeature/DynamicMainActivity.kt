package br.com.sampaio.jacocoexample.dynamicfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import br.com.sampaio.jacocoexample.dynamicfeature.databinding.DynamicActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class DynamicMainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: DynamicActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DynamicActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dynamicFab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}