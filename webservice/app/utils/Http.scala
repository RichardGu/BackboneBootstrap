package utils

import scala.collection.immutable.Map

object Http {

  val DEFAULT_PAGE_LEN = 10

  implicit def toFlatQueryString(queryString: Map[String, Seq[String]]): Map[String, String] = {
    queryString.map { (entry) => (entry._1, entry._2.mkString(",")) }
  }

    // page, len, order, filter
  def parseQuery(query: Map[String, Seq[String]]): (Int, Int, String, String) = {
    //val map: Map[String, String] = Http.flatQueryString(query)

    val map: Map[String, String] = query          // Http.toFlatQueryString

    val page: Int = map.getOrElse("page","1").toInt
    val len: Int = map.getOrElse("len", DEFAULT_PAGE_LEN.toString).toInt
    val order = map.getOrElse("order", "name")
    val filter = map.getOrElse("filter", "")

    (page, len, order, filter)
  }
}