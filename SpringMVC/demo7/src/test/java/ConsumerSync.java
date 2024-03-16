import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/12/17 16:47:51
 */
public class ConsumerSync {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // 给消费者配置对象添加参数
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.124.105:9092");
        // 配置序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // 设置手动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        // 配置消费者组（组名任意起名）
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        try (KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties)) {
            // 指定主题消费
            kafkaConsumer.subscribe(Collections.singletonList("topic1"));

            Set<TopicPartition> assignment = new HashSet<>();
            while (assignment.isEmpty()) {
                kafkaConsumer.poll(Duration.ofSeconds(1));
                // 获取消费者分区分配信息（有了分区分配信息才能开始消费）
                assignment = kafkaConsumer.assignment();
            }
            Map<TopicPartition, Long> timeMap = new HashMap<>();
            // 得到一周前的时间戳
            Long time = LocalDateTime.now().minusWeeks(1).toEpochSecond(ZoneOffset.UTC);
            // 封装集合存储，每个分区对应一天前的数据
            for (TopicPartition tp : assignment) {
                timeMap.put(tp, time);
            }
            // 获取从 1 周前开始消费的每个分区的 offset
            Map<TopicPartition, OffsetAndTimestamp> offsetMap = kafkaConsumer.offsetsForTimes(timeMap);
            // 遍历每个分区，对每个分区设置消费时间。
            for (TopicPartition tp : assignment) {
                OffsetAndTimestamp offsetAndTimestamp = offsetMap.get(tp);
                // 根据时间指定开始消费的位置
                if (offsetAndTimestamp != null) {
                    kafkaConsumer.seek(tp, offsetAndTimestamp.offset());
                }
            }
            // 拉取数据打印
            while (true) {
                // 设置 1s 中消费一批数据
                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(1));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record);
                }
                kafkaConsumer.commitSync();
            }
        }
    }
}
