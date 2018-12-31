package org.kzone666.fr

import org.kzone666.fr.engine.GameEngine

object Main extends App {
  new Thread(new GameEngine).start()
}
