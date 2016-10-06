package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def adduser = Action {
    Ok(views.html.adduser("Your new application is ready."))
  }

  def loginuser = Action {
      Ok(views.html.loginuser("Your new application is ready."))
    }

  def handleForm = Action(parse.tolerantFormUrlEncoded) {
    implicit request => val username = request.body.get("username").map(_.head).getOrElse("");
    //Ok("Username was " + username)
    Ok(views.html.showUsername("username", username))
  }

  def doLogin = Action { implicit request =>
    val loginRequest = loginForm.bindFromRequest.get
    Ok(s"username: '${loginRequest.username}', password: '${loginRequest.password}'")
  }

  def loginForm = Form(mapping("username" -> text, "password" -> text)
      (LoginRequest.apply)(LoginRequest.unapply))

  case class LoginRequest(username:String, password:String)

}
