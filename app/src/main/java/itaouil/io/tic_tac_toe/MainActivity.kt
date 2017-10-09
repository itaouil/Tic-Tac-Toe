package itaouil.io.tic_tac_toe

// Imports
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

// Available moves
private var availableMoves = ArrayList<Int>()

// Player1 moves
private var player1 = ArrayList<Int>()

// Player2 moves
private var player2 = ArrayList<Int>()

// Current player
private var activePlayer = 1

// Game winner
private var winner = -1

// Random instance
private val random = Random()

// Main activity class
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Populate available moves
        for (item in 1..9) {
            availableMoves.add(item)
        }

    }

    // Button click event
    fun buClick(view: View) {

        // Cast the view to a button view
        val buSelected:Button = view as Button

        // Cell holder
        var cellID = 0

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

        // Select the button
        selectButton(cellID, buSelected)

    }

    // Button selection
    private fun selectButton(cellID:Int, selectedButton:Button) {

        if (activePlayer == 1) {

            // Store player1 move
            player1.add(cellID)

            // Remove move from available moves
            availableMoves.remove(cellID)

            // Customise button selected
            selectedButton.text = "X"
            selectedButton.setBackgroundColor(Color.GREEN)

            // Change active player
            activePlayer = 2

            // Auto play
            autoPlay()

        } else {

            // Store player1 move
            player2.add(cellID)

            // Remove move from available moves
            availableMoves.remove(cellID)

            // Customise button selected
            selectedButton.text = "O"
            selectedButton.setBackgroundColor(Color.YELLOW)

            // Change active player
            activePlayer = 1

        }

        // Disable button
        selectedButton.isEnabled = false

        // Check for winner
        checkWinner()

    }

    // Check for the winner
    private fun checkWinner() {

        // Row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1

        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2

        // Row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1

        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2

        // Row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1

        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

        // Column 1
        if (player1.contains(1) && player1.contains(3) && player1.contains(6))
            winner = 1

        if (player2.contains(1) && player2.contains(3) && player2.contains(6))
            winner = 2

        // Column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1

        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2

        // Column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1

        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        // Diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1

        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2

        // Diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1

        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2

        // Winner Message
        if (winner != -1)
            Toast.makeText(this, "Player ${winner} won the game !", Toast.LENGTH_LONG).show()

    }

    // Auto play
    private fun autoPlay() {

        // Get random index
        val index = random.nextInt(availableMoves.size - 0) + 1

        // Get cellID
        val cellID = availableMoves[index]

        // Button selected
        val selectedButton:Button?

        // Get button ID
        when (cellID) {

            1 -> selectedButton = findViewById(R.id.bu1) as Button
            2 -> selectedButton = findViewById(R.id.bu2) as Button
            3 -> selectedButton = findViewById(R.id.bu3) as Button
            4 -> selectedButton = findViewById(R.id.bu4) as Button
            5 -> selectedButton = findViewById(R.id.bu5) as Button
            6 -> selectedButton = findViewById(R.id.bu6) as Button
            7 -> selectedButton = findViewById(R.id.bu7) as Button
            8 -> selectedButton = findViewById(R.id.bu8) as Button
            9 -> selectedButton = findViewById(R.id.bu9) as Button

            else -> selectedButton = findViewById(R.id.bu1) as Button

        }

        // Play the game
        selectButton(cellID, selectedButton)

    }

}
