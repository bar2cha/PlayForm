package controllers

import play.api._
import play.api.mvc._

class About extends Controller {
  // return plain text
  def about = Action {
    Ok("About")
  }
}
