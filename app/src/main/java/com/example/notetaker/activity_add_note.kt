package com.example.notetaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class activity_add_note : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val editText: EditText = findViewById(R.id.editTextNote)
        val buttonAdd: Button = findViewById(R.id.buttonAddNote)

        buttonAdd.setOnClickListener {
            val newNote = editText.text.toString().trim()
            if (newNote.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("NEW_NOTE", newNote)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
