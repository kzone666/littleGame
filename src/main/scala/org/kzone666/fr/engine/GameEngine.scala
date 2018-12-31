package org.kzone666.fr.engine


class GameEngine  extends IGameLogic  with  Runnable {

  val gameInPlay: Boolean = true
  val secsPerFrame: Long = 20

  override def run(): Unit = {gameLoop()}
  override def handleUserInput: Unit = {println("handle input")}
  override def renderToTheScreen: Unit = {println("push to window")}
  override def updateGameState: Unit = {println("maj data du jeu")}


  def gameLoop () = {
    println("DEBUG : entrée dans gameLoop")
    while(gameInPlay) {
      val before: Long = System.currentTimeMillis()
      handleUserInput /*Window => gameLoop*/
      updateGameState /* calculte new gameSate */
      renderToTheScreen /* gameLoop => Window*/
      val after:Long = System.currentTimeMillis()

      var tmp = before + secsPerFrame - after
      println(s"le temps de dormir = $tmp")

      Thread.sleep(before + secsPerFrame - after)
    } /* END gameLoop while */
  } /*END gameLoop*/


}/*END GameEngine*/
