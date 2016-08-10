package data

/**
  * Created by richardpianka on 8/9/16.
  */
object Generator extends App {

  slick.codegen.SourceCodeGenerator.main(
    Array(
      "slick.driver.MySQLDriver",
      "com.mysql.jdbc.Driver",
      "jdbc:mysql://animals-cluster.cluster-crw8ngxc2vao.us-east-1.rds.amazonaws.com:3306/animals",
      "src/main/scala",
      "animals.data",
      "admin",
      "password"
    )
  )
}
