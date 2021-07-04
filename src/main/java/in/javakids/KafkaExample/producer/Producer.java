package in.javakids.KafkaExample.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
  
  private static String stringTopicName="string-topic";
  private static String xmlContentTopicName="xmlcontent-topic";
  
  @Autowired 
  private KafkaTemplate<String, String> kafkaTemp;
  
  public void publishToTopic(String message) {
	  System.out.println("Publishing to topic "+stringTopicName);
	  this.kafkaTemp.send(stringTopicName, message);
  }

  public void publishXmlStringToTopic(String xmlContent){
      System.out.println("Publishing to topic "+xmlContentTopicName);
      this.kafkaTemp.send(xmlContentTopicName, xmlContent);
  }

}
