package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def handleForm = Action(parse.tolerantFormUrlEncoded) {
    implicit request => val username = request.body.get("username").map(_.head).getOrElse("");
    //Ok("Username was " + username)
    Ok(views.html.showUsername(username))
  }

}
