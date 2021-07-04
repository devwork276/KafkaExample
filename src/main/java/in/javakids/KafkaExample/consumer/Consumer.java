package in.javakids.KafkaExample.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import in.javakids.KafkaExample.model.Employee;
import in.javakids.KafkaExample.util.XmlGenerator;

@Service
public class Consumer {
	@KafkaListener(topics ="string-topic")
	public void consumeFromTopic(String message) {
		System.out.println("Consummed message " + message);
	}

	@KafkaListener(topics = "xmlcontent-topic")
	public void consumeXmlContentTopic(String xmlContent) {
		System.out.println("Consummed message " + xmlContent);
		Employee employee = (Employee) XmlGenerator.objectToXml(xmlContent, Employee.class);
		System.out.println(employee);
	}
}
