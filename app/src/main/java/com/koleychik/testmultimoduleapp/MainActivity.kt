package com.koleychik.testmultimoduleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.koleychik.testmultimoduleapp.navigation.Navigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.component?.inject(this)
        navigator.bind(findNavController(R.id.nav_host))
    }

    override fun onDestroy() {
        super.onDestroy()
        navigator.unbind()
    }
}