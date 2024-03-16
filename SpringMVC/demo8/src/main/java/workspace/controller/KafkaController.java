package workspace.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/12/23 16:52:18
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer<String, String> producer;
    @Autowired
    private KafkaConsumer<String, String> consumer;

    @GetMapping("/{message}")
    public Object sendMessage(@PathVariable String message) {
        return producer.send(new ProducerRecord<>("topic1", message));

    }

    @GetMapping("/get/{topic}")
    public String getMessage(@PathVariable String topic) {
        consumer.subscribe(Collections.singletonList(topic));
        ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(1));
        StringBuilder result = new StringBuilder();
        for (ConsumerRecord<String, String> record : poll) {
            result.append(record.value()).append("\n");
        }
        return result.toString();
    }
}
