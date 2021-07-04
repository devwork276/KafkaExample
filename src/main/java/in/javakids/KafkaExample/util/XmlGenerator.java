/**
 * 
 */
package in.javakids.KafkaExample.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * @author ab68478
 *
 */
public class XmlGenerator {

	public static String jaxbObjectToXML(Class classInstance,Object object) {
		String xmlContent = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(classInstance);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			StringWriter sw = new StringWriter();

			jaxbMarshaller.marshal(object, sw);

			xmlContent = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlContent;
	}
	
	public static Object objectToXml(String xmlContent,Class<?> classInstance) {
		JAXBContext jaxbContext;
		 Object object=new Object();
		try
		{
		    jaxbContext = JAXBContext.newInstance(classInstance);              
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    object = (Object) jaxbUnmarshaller.unmarshal(new StringReader(xmlContent));
		     
		}
		catch (JAXBException e) 
		{
		    e.printStackTrace();
		}
		return object;
		
	}


}
