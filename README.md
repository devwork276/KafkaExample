# KafkaExample
Step 1: Get Kafka
  Download the latest Kafka release and extract it:
  $ tar -xzf kafka_2.13-2.8.0.tgz
  $ cd kafka_2.13-2.8.0
Step 2: Install Kafka
  # Start the ZooKeeper service
  # Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
  $ bin/zookeeper-server-start.sh config/zookeeper.properties
  Open another terminal session and run:
  # Start the Kafka broker service
  $ bin/kafka-server-start.sh config/server.properties
  Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.
Step 3: CREATE A TOPIC TO STORE YOUR EVENTS
  bin/kafka-topics.sh --create --topic string-topic --bootstrap-server localhost:9092
  bin/kafka-topics.sh --create --topic xmlcontent-topic --bootstrap-server localhost:9092
Step 4: Run The SprintBoot Application 
Step 5: To Test XmlContent Access this Url in browser : http://localhost:8081/kafka/produce/xmlContent
        To Test StringContent access this url in browser : http://localhost:8081/kafka/produce/stringmessage?msg="Hello"
        Observe Console or logger.
  
