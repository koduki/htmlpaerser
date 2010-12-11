// vim: set ts=4 sw=4 et:
package cn.orz.pascal.utils.xml

import org.xml.sax.InputSource

import java.io.InputStream
import scala.xml._
import parsing._

/**
* Processing html as XML in scala.
*
* very inspire this article.
* http://www.hars.de/2009/01/html-as-xml-in-scala.html
*/
class HtmlParser extends NoBindingFactoryAdapter {
  override def loadXML(source : InputSource, _p: SAXParser) = {
    loadXML(source)
  }

  def loadXML(source : String): Node = {
    import java.io.ByteArrayInputStream    
    val in = new ByteArrayInputStream(source.getBytes())
    loadXML(in)
  }
  def loadXML(source : InputStream): Node = loadXML(new InputSource(source))
  def loadXML(source : InputSource): Node = {
    import nu.validator.htmlparser.{sax,common}
    import common.XmlViolationPolicy

    val reader = new sax.HtmlParser
    reader.setXmlPolicy(XmlViolationPolicy.ALLOW)
    reader.setContentHandler(this)
    reader.parse(source)
    rootElem
  }
}

