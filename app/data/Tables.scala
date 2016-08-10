package data

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Animals.schema ++ Species.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Animals
   *  @param animalid Database column AnimalId SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column Name SqlType(VARCHAR), Length(100,true)
   *  @param speciesid Database column SpeciesId SqlType(INT) */
  case class AnimalsRow(animalid: Int, name: String, speciesid: Int)
  /** GetResult implicit for fetching AnimalsRow objects using plain SQL queries */
  implicit def GetResultAnimalsRow(implicit e0: GR[Int], e1: GR[String]): GR[AnimalsRow] = GR{
    prs => import prs._
    AnimalsRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table Animals. Objects of this class serve as prototypes for rows in queries. */
  class Animals(_tableTag: Tag) extends Table[AnimalsRow](_tableTag, "Animals") {
    def * = (animalid, name, speciesid) <> (AnimalsRow.tupled, AnimalsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(animalid), Rep.Some(name), Rep.Some(speciesid)).shaped.<>({r=>import r._; _1.map(_=> AnimalsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column AnimalId SqlType(INT), AutoInc, PrimaryKey */
    val animalid: Rep[Int] = column[Int]("AnimalId", O.AutoInc, O.PrimaryKey)
    /** Database column Name SqlType(VARCHAR), Length(100,true) */
    val name: Rep[String] = column[String]("Name", O.Length(100,varying=true))
    /** Database column SpeciesId SqlType(INT) */
    val speciesid: Rep[Int] = column[Int]("SpeciesId")

    /** Foreign key referencing Species (database name FK_Species) */
    lazy val speciesFk = foreignKey("FK_Species", speciesid, Species)(r => r.speciesid, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Animals */
  lazy val Animals = new TableQuery(tag => new Animals(tag))

  /** Entity class storing rows of table Species
   *  @param speciesid Database column SpeciesId SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column Name SqlType(VARCHAR), Length(100,true) */
  case class SpeciesRow(speciesid: Int, name: String)
  /** GetResult implicit for fetching SpeciesRow objects using plain SQL queries */
  implicit def GetResultSpeciesRow(implicit e0: GR[Int], e1: GR[String]): GR[SpeciesRow] = GR{
    prs => import prs._
    SpeciesRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table Species. Objects of this class serve as prototypes for rows in queries. */
  class Species(_tableTag: Tag) extends Table[SpeciesRow](_tableTag, "Species") {
    def * = (speciesid, name) <> (SpeciesRow.tupled, SpeciesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(speciesid), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> SpeciesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SpeciesId SqlType(INT), AutoInc, PrimaryKey */
    val speciesid: Rep[Int] = column[Int]("SpeciesId", O.AutoInc, O.PrimaryKey)
    /** Database column Name SqlType(VARCHAR), Length(100,true) */
    val name: Rep[String] = column[String]("Name", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table Species */
  lazy val Species = new TableQuery(tag => new Species(tag))
}
