package com.example.kafka.simple.produce;

import com.example.kafka.constants.kafkaConfigConstants;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


/**
 * @author weipeng_yuan
 * @date 2019-06027
 */
public class ProducerFastStart {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", kafkaConfigConstants.BROKE_LIST);


        KafkaProducer<String, String> producer =
                new KafkaProducer<>(properties);
        ProducerRecord<String, String> record =
                new ProducerRecord<>(kafkaConfigConstants.TOPIC, "hello, Kafka!");
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        producer.close();
    }
}
