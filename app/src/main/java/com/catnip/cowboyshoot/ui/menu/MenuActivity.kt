package com.catnip.cowboyshoot.ui.menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.catnip.cowboyshoot.databinding.ActivityMenuBinding
import com.catnip.cowboyshoot.ui.game.GameActivity

class MenuActivity : AppCompatActivity() {
    private val binding: ActivityMenuBinding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickListeners()
        supportActionBar?.hide()
        name = intent?.getStringExtra("name").toString()
        binding.apply {
            tvTitleName.text = buildString {
                append("Hi ")
                append(name)
                append(" !")
            }
        }
        Log.d("Testing4", "onCreate: $name")
    }

    private fun setOnClickListeners() {
        binding.apply {
            layoutVsComputer.setOnClickListener {
                val intent = Intent(this@MenuActivity, GameActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                intent.putExtra("name", name)
                startActivity(intent)
                finish()
            }

            layoutVsPlayer.setOnClickListener {
                Toast.makeText(this@MenuActivity, "This feature is currently under maintenance", Toast.LENGTH_SHORT).show()
            }
        }
    }
}