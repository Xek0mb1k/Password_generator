package com.example.passwordgenerator

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.passwordgenerator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setDefaultValues()

        setNoClickableCheckbox()




        binding.seekBarLengthBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, p2: Boolean) {
                binding.lengthTextView.text = getString(R.string.password_length) + " $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }

        })

        binding.generatorPasswordButton.setOnClickListener {

            binding.generatedPasswordTextView.text = Generator().generate(
                binding.seekBarLengthBar.progress,
                binding.uppLetCheckBox.isChecked,
                binding.lowLetCheckBox.isChecked,
                binding.numbersCheckBox.isChecked,
                binding.symbolsCheckBox.isChecked,
                binding.uniqueCharacterCheckBox.isChecked
            )
            if (binding.generatedPasswordTextView.text == "")
                Toast.makeText(
                    this,
                    "ERROR! Please, reduce password length or check more letters",
                    Toast.LENGTH_SHORT
                ).show()

        }

        binding.copyButton.setOnClickListener {
            Toast.makeText(this, "Password copied", Toast.LENGTH_SHORT).show()

            val clipboard: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("label", binding.generatedPasswordTextView.text)
            clipboard.setPrimaryClip(clip)
        }
    }

    private fun setNoClickableCheckbox() {
        binding.uppLetCheckBox.setOnClickListener {
            if (binding.uppLetCheckBox.isChecked){
                binding.uppLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.lowLetCheckBox.isChecked){
                binding.lowLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.numbersCheckBox.isChecked){
                binding.numbersCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.symbolsCheckBox.isChecked){
                binding.symbolsCheckBox.isClickable = countWorkedCheckBox() > 1
            }
        }

        binding.lowLetCheckBox.setOnClickListener {
            if (binding.uppLetCheckBox.isChecked){
                binding.uppLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.lowLetCheckBox.isChecked){
                binding.lowLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.numbersCheckBox.isChecked){
                binding.numbersCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.symbolsCheckBox.isChecked){
                binding.symbolsCheckBox.isClickable = countWorkedCheckBox() > 1
            }
        }

        binding.numbersCheckBox.setOnClickListener {
            if (binding.uppLetCheckBox.isChecked){
                binding.uppLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.lowLetCheckBox.isChecked){
                binding.lowLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.numbersCheckBox.isChecked){
                binding.numbersCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.symbolsCheckBox.isChecked){
                binding.symbolsCheckBox.isClickable = countWorkedCheckBox() > 1
            }
        }

        binding.symbolsCheckBox.setOnClickListener {
            if (binding.uppLetCheckBox.isChecked){
                binding.uppLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.lowLetCheckBox.isChecked){
                binding.lowLetCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.numbersCheckBox.isChecked){
                binding.numbersCheckBox.isClickable = countWorkedCheckBox() > 1
            }
            if (binding.symbolsCheckBox.isChecked){
                binding.symbolsCheckBox.isClickable = countWorkedCheckBox() > 1
            }
        }
    }

    private fun countWorkedCheckBox(): Int {
        var count = 0
        if (binding.uppLetCheckBox.isChecked) count+=1
        if(binding.lowLetCheckBox.isChecked) count+=1
        if(binding.numbersCheckBox.isChecked) count+=1
        if(binding.symbolsCheckBox.isChecked) count+=1
        return count
    }

    @SuppressLint("SetTextI18n")
    private fun setDefaultValues() {
        binding.uppLetCheckBox.isChecked = true
        binding.lowLetCheckBox.isChecked = true
        binding.numbersCheckBox.isChecked = true
        binding.symbolsCheckBox.isChecked = true

        binding.seekBarLengthBar.progress = 8
        binding.lengthTextView.text = "LENGTH: 8"
    }
}