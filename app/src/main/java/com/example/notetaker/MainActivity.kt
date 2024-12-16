package com.example.notetaker
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter
    private val items: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        val addNoteButton: Button = findViewById(R.id.add_button)

        // Add a temporary item
        items.add("Temp Add Element")

        // Create the adapter and set it to the ListView
        adapter = MyAdapter(this, items)
        listView.adapter = adapter

        // Set click listener for the add note button
        addNoteButton.setOnClickListener {
            val intent = Intent(this@MainActivity, activity_add_note::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_NOTE);        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_ADD_NOTE && resultCode == RESULT_OK) {
            val newNote = data?.getStringExtra("NEW_NOTE")
            if (newNote != null) {
                items.add(newNote)
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_NOTE = 1
    }
}
