package com.example.uasml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uasml.databinding.ActivityFiturBinding

class FiturActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiturBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiturBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fiturList = listOf(
            "1. Density",
            "2. Age (usia)",
            "3. Weight (berat badan)",
            "4. Height (tinggi badan)",
            "5. Neck circumference",
            "6. Chest circumference",
            "7. Abdomen circumference",
            "8. Hip circumference",
            "9. Thigh circumference",
            "10. Knee circumference",
            "11. Ankle circumference",
            "12. Biceps (flexed)",
            "13. Forearm circumference",
            "14. Wrist circumference",
            "15. Body Fat % (target)"
        )

        val formattedText = fiturList.joinToString("\n")
        binding.tvFiturList.text = formattedText
    }
}
