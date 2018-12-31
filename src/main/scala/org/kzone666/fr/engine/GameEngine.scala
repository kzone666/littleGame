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

    while(gameInPlay) {
      handleUserInput /*Window => gameLoop*/
      updateGameState /* calculte new gameSate */
      renderToTheScreen /* gameLoop => Window*/
    } /* END gameLoop while */
  } /*END gameLoop*/
}/*END GameEngine*/
