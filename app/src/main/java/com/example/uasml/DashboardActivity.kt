package com.example.uasml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        findViewById<Button>(R.id.btnTentang).setOnClickListener {
             startActivity(Intent(this, TentangActivity::class.java))
        }

        findViewById<Button>(R.id.btnDataset).setOnClickListener {
             startActivity(Intent(this, DatasetActivity::class.java))
        }

        findViewById<Button>(R.id.btnFitur).setOnClickListener {
            startActivity(Intent(this, FiturActivity::class.java))
        }

        findViewById<Button>(R.id.btnModel).setOnClickListener {
             startActivity(Intent(this, ModelActivity::class.java))
        }

        findViewById<Button>(R.id.btnSimulasi).setOnClickListener {
             startActivity(Intent(this, SimulasiActivity::class.java))
        }
    }
}