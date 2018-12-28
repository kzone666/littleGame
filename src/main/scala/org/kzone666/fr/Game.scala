package org.kzone666.fr

import org.lwjgl.glfw.GLFWErrorCallback

class Game {
  val errorCallback: GLFWErrorCallback = GLFWErrorCallback.createPrint(System.err)
}
