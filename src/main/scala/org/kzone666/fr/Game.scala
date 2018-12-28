package org.kzone666.fr

import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.glfw.GLFW._
import org.lwjgl.opengl.GL11._

class Game {
  val errorCallback: GLFWErrorCallback = GLFWErrorCallback.createPrint(System.err)
  def window  = glfwCreateWindow(640, 480, "Simple example", 0l,0l)
    throw new RuntimeException("Failed to create the GLFW window")
    /*=> glfwTerminate*/

  def initGame() = {
    // Setup an error callback. The default implementation
    // will print the error message in System.err.
    GLFWErrorCallback.createPrint(System.err).set
    // Initialize GLFW. Most GLFW functions will not work before doing this.
    if (!glfwInit) throw new IllegalStateException("Unable to initialize GLFW")
  }
  def startGame() = ???
  def stopGame() = ???
}
