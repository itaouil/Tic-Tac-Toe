package itaouil.io.tic_tac_toe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Button click event
    fun buClick(view: View) {

        // Cast the view to a button view
        val buSelected:Button = view as Button

        // Cell holder
        var cellID:Int = 0

        // Assign correct value to cell holder
        when (buSelected.id) {

            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9

        }

        // Show message
        Toast.makeText(this, "ID: " + cellID, Toast.LENGTH_LONG).show()

    }
}
