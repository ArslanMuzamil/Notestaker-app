package com.example.notetaker

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailTextView: TextView = findViewById(R.id.detailTextView)
        val dataNotesTextView: TextView = findViewById(R.id.Data_Notes)

        // Get the data passed from MainActivity
        val item = intent.getStringExtra("ITEM")

        // Set the data to the TextViews
        detailTextView.text = "Notes Content"
        dataNotesTextView.text = item


    }
}
