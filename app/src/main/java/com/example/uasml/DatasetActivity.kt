package com.example.uasml

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uasml.databinding.ActivityDatasetBinding


class DatasetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatasetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatasetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenDataset.setOnClickListener {
            val url = "https://www.kaggle.com/datasets/fedesoriano/body-fat-prediction-dataset"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
