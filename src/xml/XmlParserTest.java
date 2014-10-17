package xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XmlParserTest {
	@Test
	public void test1() throws ParserConfigurationException, SAXException{
		System.setProperty("javax.xml.parsers.SAXParserFactory", "dsf");
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		System.err.println(parser);
	}
}
