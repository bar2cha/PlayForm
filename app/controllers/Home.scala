package controllers

import play.api._
import play.api.mvc._

class Home extends Controller {

  // Simple action - just returns plain text to the browser.
  def welcome = Action {
    Ok("Welcome")
  }
}
