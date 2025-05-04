import com.raquo.laminar.api.L.*

@main def hello = {
  val app = h1("a")
  renderOnDomContentLoaded(
    org.scalajs.dom.document.getElementById("app"),
    app
  )
}
