package core

import kamon.Kamon
import play.api.{Application, Logger, GlobalSettings}

/**
  * Created by mark.miller on 10/14/2015.
  */
object Global extends GlobalSettings {
  override def beforeStart(app: Application): Unit = {
    Logger.info("core.Global object is running!")
    Kamon.start()
  }
}
