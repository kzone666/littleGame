package org.kzone666.fr.engine

/*
  moteur du jeu :
  tant que  'running' => gameLoop

 */
class GameEngine  extends IGameLogic  with  Runnable{

  val gameInPlay: Boolean = true

  override def run(): Unit = {gameLoop()}
  override def handleUserInput: Unit = {println("handle input")}
  override def renderToTheScreen: Unit = {println("push to window")}
  override def updateGameState: Unit = {println("maj data du jeu")}


  def gameLoop () = {
    println("DEBUG : entrée dans gameLoop")
    while(gameInPlay) {
      handleUserInput /*Window => gameLoop*/
      updateGameState /* calculte new gameSate */
      renderToTheScreen /* gameLoop => Window*/
    } /* END gameLoop while */
  } /*END gameLoop*/


}/*END GameEngine*/
