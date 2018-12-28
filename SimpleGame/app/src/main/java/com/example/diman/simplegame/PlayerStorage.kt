package com.example.diman.simplegame

class PlayerStorage(val totalGamesAllowed: Int, var gamesPlayed: Int) {

  fun calcGamesLeft(): Int {
    return if (totalGamesAllowed > gamesPlayed) {
      totalGamesAllowed - gamesPlayed
    } else {
      0
    }
  }
}