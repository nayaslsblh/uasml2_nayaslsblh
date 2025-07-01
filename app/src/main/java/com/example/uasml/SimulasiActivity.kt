package com.example.uasml

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.uasml.ml.AkurasiLemakTubuh
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.ByteOrder

class SimulasiActivity : AppCompatActivity() {

    private lateinit var hasilPrediksi: TextView
    private val inputIds = listOf(
        R.id.inputDensity, R.id.inputBodyFat, R.id.inputAge,
        R.id.inputWeight, R.id.inputHeight, R.id.inputNeck,
        R.id.inputChest, R.id.inputAbdomen, R.id.inputHip,
        R.id.inputThigh, R.id.inputKnee, R.id.inputAnkle,
        R.id.inputBiceps, R.id.inputForearm, R.id.inputWrist
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulasi)

        hasilPrediksi = findViewById(R.id.hasilPrediksi)
        val btnPrediksi = findViewById<Button>(R.id.btnPrediksi)

        btnPrediksi.setOnClickListener {
            val inputValues = inputIds.map { id ->
                val editText = findViewById<EditText>(id)
                editText.text.toString().toFloatOrNull() ?: 0f
            }

            val byteBuffer = ByteBuffer.allocateDirect(4 * 15)
            byteBuffer.order(ByteOrder.nativeOrder())
            inputValues.forEach { byteBuffer.putFloat(it) }

            val model = AkurasiLemakTubuh.newInstance(this)
            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 15), DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)

            val outputs = model.process(inputFeature0)
            val output = outputs.outputFeature0AsTensorBuffer.floatArray[0].toInt()

            val kategori = when (output) {
                0 -> "Lemak Tubuh Rendah"
                1 -> "Lemak Tubuh Normal"
                2 -> "Lemak Tubuh Tinggi"
                else -> "Tidak Diketahui"
            }

            hasilPrediksi.text = "Hasil Prediksi: $kategori"
            model.close()
        }
    }
}
