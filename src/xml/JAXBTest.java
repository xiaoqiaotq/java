package xml;

import static org.junit.Assert.*;

import java.io.StringWriter;

import javax.sound.midi.SysexMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;

public class JAXBTest {
   @Test
	public void marshal1() throws Exception {
		JAXBContext context=JAXBContext.newInstance("xml");
		Marshaller marshaller=context.createMarshaller();
		Address address=new Address();
		address.setCountry("中国");
		StringWriter stringWriter=new StringWriter();
		marshaller.marshal(address, stringWriter);
		System.err.println(stringWriter);
	}
   @Test
   public void marshal2() throws Exception {
	   JAXBContext context=JAXBContext.newInstance("xml");
	   System.err.println(context);
	   Marshaller marshaller=context.createMarshaller();
	   Address address=new Address();
	   address.setCountry("中国");
	   marshaller.marshal(address, new MyHandler());
//	   StringWriter stringWriter=new StringWriter();
//	   marshaller.marshal(address, stringWriter);
//	   System.err.println(stringWriter);
   }
   @Test
   public void marshal3() throws Exception {
	   JAXBContext context=JAXBContext.newInstance("xml");
	   Marshaller marshaller=context.createMarshaller();
	   Address address=new Address();
	   address.setCountry("香港");
	   Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	   marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	   marshaller.marshal(address, doc);
	   marshaller.marshal(address, System.err);
	   System.err.println(doc);
	   System.err.println(doc.getDocumentElement());
//	   StringWriter stringWriter=new StringWriter();
//	   marshaller.marshal(address, stringWriter);
//	   System.err.println(stringWriter);
   }
}
