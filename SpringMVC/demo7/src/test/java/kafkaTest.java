import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import sun.rmi.runtime.Log;
import workspace.entity.MyPartitioner;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/12/02 17:09:25
 */
public class kafkaTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 配置Kafka服务地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.124.105:9092");
        // 配置key的序列化
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 配置value的序列化
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        // 设置事务 id（必须），事务 id 任意起名
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, UUID.randomUUID().toString());
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        try {
            kafkaProducer.initTransactions();
            kafkaProducer.beginTransaction();
            for (int i = 0; i < 5; i++) {
                kafkaProducer.send(new ProducerRecord<>("topic1", "test" + i, "test" + i), (metadata, e) -> {
                    System.out.println("test1" + "->" + "分区：" + metadata.partition());
                });
            }
            kafkaProducer.commitTransaction();
        } catch (Exception e) {
            kafkaProducer.abortTransaction();
            throw new RuntimeException(e);
        } finally {
            kafkaProducer.close();
        }
    }
}
