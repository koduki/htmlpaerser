// vim: set ts=4 sw=4 et:
package cn.orz.pascal.utils.xml
import org.specs._

object HtmlParserSpec extends Specification {
    "a html parser" should {
        val parser = new HtmlParser

        "<html></html> is <html><head></head><body></body></html>." in {
            parser.loadXML("<html></html>") must_== <html><head></head><body></body></html>
        }
         "not closed tag is complete closed tag." in {
            parser.loadXML("<html><head></head><body><br></body></html>") must_== <html><head></head><body><br></br></body></html>
        }
   }
}
