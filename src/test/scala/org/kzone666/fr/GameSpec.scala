package org.kzone666.fr

import org.scalatest._
import org.kzone666.fr._

class GameSpec extends MockSpec {

  /*
      The error callback is called by the thread where the error was generated.
      If you are using GLFW from multiple threads, your error callback needs to be written accordingly.
      Because the description string provided to the callback may have been generated specifically for that error,
      it is not guaranteed to be valid after the callback has returned.
      If you wish to use it after that, you need to make your own copy of it before returning.
   */

  /*
  mock object : http://www.scalatest.org/user_guide/testing_with_mock_objects
   */
   val gameSpec = new Game

  "A new game" should "have a GLFWErrorCallback ane error is generated" in {
    assert(gameSpec.errorCallback != null)
  }

   gameSpec.errorCallback.close()
  "game have " should "destroy GLFWErrorCallback at the end of the game" in {
    assert(gameSpec.errorCallback === null)
  }
}
