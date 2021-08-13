package com.diego.duarte.empresas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.diego.duarte.intent.safeNavigateUp

class AppActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        mNavController = findNavController(R.id.mainNavHostFragment)
    }

    override fun onSupportNavigateUp() = mNavController.safeNavigateUp()
}
