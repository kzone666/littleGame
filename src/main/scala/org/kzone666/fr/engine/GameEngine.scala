package org.kzone666.fr.engine

import org.lwjgl.glfw.{GLFWErrorCallback, GLFWKeyCallback}
import org.lwjgl.glfw.GLFW.{GLFW_KEY_ESCAPE, GLFW_PRESS}
import org.lwjgl.glfw.GLFW.{glfwSetWindowShouldClose,glfwWindowShouldClose}
import org.lwjgl.glfw.GLFW.glfwSetErrorCallback
import org.lwjgl.glfw.GLFW.glfwInit
import org.lwjgl.glfw.GLFW.glfwCreateWindow
import org.lwjgl.glfw.GLFW.glfwTerminate
import org.lwjgl.glfw.GLFW.glfwSetKeyCallback
import org.lwjgl.glfw.GLFW.glfwMakeContextCurrent

class GameEngine  extends IGameLogic  with  Runnable {

  val gameInPlay: Boolean = true
  val secsPerFrame: Long = 20
  val errorCallback:GLFWErrorCallback  = GLFWErrorCallback.createPrint(System.err)

  override def run(): Unit = {
    // Initializing the OpenGL context
    // #############################################################################################
    glfwSetErrorCallback(errorCallback)
    //  initialize GLFW
    if (!glfwInit) throw new IllegalStateException("Unable to initialize GLFW")
    //Now that GLFW is initialized we can start creating a window

    val window = glfwCreateWindow(640, 480, "Simple example", 0, 0)
    if (window == 0) {
      glfwTerminate
      throw new RuntimeException("Failed to create the GLFW window")
    }

    //  a key callback
    val keyCallback = new GLFWKeyCallback {
      override def invoke(window: Long, key: Int, scancode: Int, action: Int, mods: Int): Unit = {
        if ((key==GLFW_KEY_ESCAPE) && (action==GLFW_PRESS))
          glfwSetWindowShouldClose(window, true)
      }
    }
    //  register it to your window
    glfwSetKeyCallback(window, keyCallback)

    // When done creating a window you can also create the OpenGL context, which is needed for rendering.
    glfwMakeContextCurrent(window)

    //#############################################################################################

    while (!glfwWindowShouldClose(window)) gameLoop
  }
  override def handleUserInput: Unit = {println("handle input")}
  override def renderToTheScreen: Unit = {println("push to window")}
  override def updateGameState: Unit = {println("maj data du jeu")}


  def gameLoop () = {
    println("DEBUG : entrée dans gameLoop")
    //while(gameInPlay) {
      val before: Long = System.currentTimeMillis()
      handleUserInput /*Window => gameLoop*/
      updateGameState /* calculte new gameSate */
      renderToTheScreen /* gameLoop => Window*/
      val after:Long = System.currentTimeMillis()

      var tmp = before + secsPerFrame - after
      println(s"le temps de dormir = $tmp")

      Thread.sleep(before + secsPerFrame - after)
    //} /* END gameLoop while */
  } /*END gameLoop*/


}/*END GameEngine*/
