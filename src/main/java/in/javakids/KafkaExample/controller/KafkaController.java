package in.javakids.KafkaExample.controller;

import in.javakids.KafkaExample.model.Employee;
import in.javakids.KafkaExample.producer.Producer;
import in.javakids.KafkaExample.util.XmlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/produce")
public class KafkaController {

	@Autowired
	Producer producer;
	
	@GetMapping(value="/stringmessage")
	public void sendMessage(@RequestParam("msg") String msg) {
		producer.publishToTopic(msg);
	}

	@GetMapping(value="/hello")
	public String helloMessage(){
		return "Hello World";
	}
	@GetMapping(value="/xmlContent")
	public void sendXmlContent(){
		Employee e = new Employee();
		e.setAge("25");
		e.setName("Shashi");
		e.setId(10);
		String xmlContent = XmlGenerator.jaxbObjectToXML(Employee.class,e);
		producer.publishXmlStringToTopic(xmlContent);
	}

}
