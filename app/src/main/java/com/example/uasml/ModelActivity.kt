package com.example.uasml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uasml.databinding.ActivityModelBinding

class ModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Penjelasan gambar/visualisasi yang sesuai dengan body fat prediction
        binding.desc1.text = "Penjelasan: Model yang digunakan adalah Neural Network (regresi) untuk memprediksi persentase lemak tubuh. Model ini memiliki beberapa lapisan Dense dengan aktivasi ReLU, dan satu lapisan output dengan aktivasi linear karena output berupa nilai kontinu."

        binding.desc2.text = "Penjelasan: Model dikompilasi menggunakan optimizer Adam dan fungsi loss `mean_squared_error` karena model bertujuan meminimalkan selisih antara nilai prediksi dan nilai aktual (regresi)."

        binding.desc3.text = "Penjelasan: Visualisasi arsitektur model dibuat menggunakan `plot_model` dari `tensorflow.keras.utils`, dengan parameter `show_shapes=True` untuk menampilkan dimensi input dan output tiap layer."

        binding.desc4.text = "Penjelasan: Arsitektur model terdiri dari tiga lapisan Dense: 128 neuron → 64 neuron → 32 neuron, dengan aktivasi ReLU, diikuti oleh output layer dengan satu neuron (aktivasi linear). Struktur ini digunakan untuk menangani input sebanyak 15 fitur numerik."

        binding.desc5.text = "Penjelasan: Model dilatih menggunakan data sebanyak 252 sampel selama 50 epoch dan batch size 16. Proses training disimpan dalam variabel `history`, yang kemudian divisualisasikan untuk melihat tren loss."
    }
}
