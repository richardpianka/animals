
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/richardpianka/Code/animals/conf/routes
// @DATE:Tue Aug 09 23:35:59 EDT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:8
  CountController_0: controllers.CountController,
  // @LINE:10
  AsyncController_2: controllers.AsyncController,
  // @LINE:13
  Assets_4: controllers.Assets,
  // @LINE:15
  AnimalController_3: controllers.AnimalController,
  // @LINE:23
  ApiHelpController_5: controllers.ApiHelpController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:8
    CountController_0: controllers.CountController,
    // @LINE:10
    AsyncController_2: controllers.AsyncController,
    // @LINE:13
    Assets_4: controllers.Assets,
    // @LINE:15
    AnimalController_3: controllers.AnimalController,
    // @LINE:23
    ApiHelpController_5: controllers.ApiHelpController
  ) = this(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_4, AnimalController_3, ApiHelpController_5, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, CountController_0, AsyncController_2, Assets_4, AnimalController_3, ApiHelpController_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """animals/""" + "$" + """id<[^/]+>""", """controllers.AnimalController.animalById(id:Int)"""),
    ("""GET""", this.prefix, """controllers.Assets.at(path:String = "/public", file:String = "index.html")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-docs""", """controllers.ApiHelpController.getResources"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-docs/api/todos""", """controllers.ApiHelpController.getResource(path:String = "/api/todos")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_0.count,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      """ An example controller showing how to use dependency injection""",
      this.prefix + """count"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_2.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      """ An example controller showing how to write asynchronous code""",
      this.prefix + """message"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_AnimalController_animalById4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("animals/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AnimalController_animalById4_invoker = createInvoker(
    AnimalController_3.animalById(fakeValue[Int]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AnimalController",
      "animalById",
      Seq(classOf[Int]),
      "GET",
      """""",
      this.prefix + """animals/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Assets_at5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_at5_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ swagger""",
      this.prefix + """"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_ApiHelpController_getResources6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs")))
  )
  private[this] lazy val controllers_ApiHelpController_getResources6_invoker = createInvoker(
    ApiHelpController_5.getResources,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResources",
      Nil,
      "GET",
      """""",
      this.prefix + """api-docs"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ApiHelpController_getResource7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs/api/todos")))
  )
  private[this] lazy val controllers_ApiHelpController_getResource7_invoker = createInvoker(
    ApiHelpController_5.getResource(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResource",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api-docs/api/todos"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_Assets_at8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at8_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_0.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:13
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:15
    case controllers_AnimalController_animalById4_route(params) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_AnimalController_animalById4_invoker.call(AnimalController_3.animalById(id))
      }
  
    // @LINE:21
    case controllers_Assets_at5_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("index.html"))) { (path, file) =>
        controllers_Assets_at5_invoker.call(Assets_4.at(path, file))
      }
  
    // @LINE:23
    case controllers_ApiHelpController_getResources6_route(params) =>
      call { 
        controllers_ApiHelpController_getResources6_invoker.call(ApiHelpController_5.getResources)
      }
  
    // @LINE:28
    case controllers_ApiHelpController_getResource7_route(params) =>
      call(Param[String]("path", Right("/api/todos"))) { (path) =>
        controllers_ApiHelpController_getResource7_invoker.call(ApiHelpController_5.getResource(path))
      }
  
    // @LINE:33
    case controllers_Assets_at8_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at8_invoker.call(Assets_4.at(path, file))
      }
  }
}
