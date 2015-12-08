package controllers

import javax.inject.Inject

import actors.MessageGenerator.{ConstantLoad, Peak, Schedule}
import actors.{RandomNumberActor, MessageGeneratorActor}
import actors.RandomNumberActor.{GenerateSecureNumber, GenerateNumber}
import akka.actor.{Props, ActorSystem}
import play.api._
import play.api.mvc._

class Application @Inject() (system: ActorSystem) extends Controller {

  def index = Action {
    val numberGenerator = system.actorOf(Props[RandomNumberActor])

    val generator = system.actorOf(Props[MessageGeneratorActor])

    generator ! ConstantLoad(Schedule(numberGenerator, GenerateNumber, 5000))
    generator ! ConstantLoad(Schedule(numberGenerator, GenerateSecureNumber, 1000))
    generator ! Peak(Schedule(numberGenerator, GenerateNumber, 100000))
    generator ! Peak(Schedule(numberGenerator, GenerateSecureNumber, 25000))

    Ok(views.html.index("Your new application is ready."))
  }

}
