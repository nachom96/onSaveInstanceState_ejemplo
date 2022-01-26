package es.iessaladillo.nacho.onsaveinstancestateejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.iessaladillo.nacho.onsaveinstancestateejemplo.databinding.MainActivityBinding

// 1º Se crea el estado a guardar
private const val STATE_COUNT = "STATE_COUNT"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    // 2º Se crean las variables a guardar
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 5º Se llama al restoreInstanceState
        // Se llama aquí porque cuando se hace un cambio de configuración se vuelve a llamar al onCreate
        restoreInstanceState(savedInstanceState)
        setupViews()
    }

    // 4º Se almcaenan los datos en el savedInstanceState
    private fun restoreInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(STATE_COUNT, 0)
        }
    }

    private fun setupViews() {
        binding.btnIncrement.setOnClickListener { increment() }
        showCount()
    }

    private fun increment() {
        count += 1
        showCount()
    }

    private fun showCount() {
        binding.lblCount.text = count.toString()
    }

    // 3º Sobrescribe el onSaveInstanceState
    // En el outState se indica los elementos que se quieren guardar
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_COUNT, count)
    }

}
