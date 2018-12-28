package com.example.diman.simplegame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  // Player has 3 attempts and he didn't play at all
  private val playerStorage = PlayerStorage(3, 0)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Increment number of games played
    btnPlayGame.setOnClickListener {
      if (playerStorage.calcGamesLeft() > 0) {
        playerStorage.gamesPlayed++
        Toast.makeText(this, "Playing ...", Toast.LENGTH_LONG).show()
      } else {
        Toast.makeText(this, "No more games left!", Toast.LENGTH_SHORT).show()
      }
    }

    // Get number of remaining games
    btnShowGamesLeft.setOnClickListener {
      Toast.makeText(
          this, "Games left: ${playerStorage.calcGamesLeft()}",
          Toast.LENGTH_SHORT
      ).show()
    }
  }
}
