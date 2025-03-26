package com.example.intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intents.Extras.PARAMETER_EXTRA
import com.example.intents.databinding.ActivityParameterBinding

class ParameterActivity : AppCompatActivity() {
    private val apb : ActivityParameterBinding by lazy {
        ActivityParameterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        setSupportActionBar(apb.toolbarIn.toolbar)
        supportActionBar?.subtitle = localClassName

        intent.getStringExtra(PARAMETER_EXTRA).let {
            apb.parameterEt.setText(it)
        }

        apb.returnAndCloseBt.setOnClickListener {
            Intent().apply {
                putExtra(PARAMETER_EXTRA, apb.parameterEt.text.toString())
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}