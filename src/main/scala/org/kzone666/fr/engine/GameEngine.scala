package org.kzone666.fr.engine

/*
  moteur du jeu :
  tant que  'running' => gameLoop

 */
class GameEngine {

  /*
  first gameLoop def
   */
  def gameLoop() = {
    handleUserInput
    updateGameState
    renderToTheScree
  }
}
