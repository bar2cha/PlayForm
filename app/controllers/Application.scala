package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def adduser = Action {
    Ok(views.html.adduser("Your new application is ready."))
  }

  def handleForm = Action(parse.tolerantFormUrlEncoded) {
    implicit request => val username = request.body.get("username").map(_.head).getOrElse("");
    //Ok("Username was " + username)
    Ok(views.html.showUsername("username", username))
  }

}
