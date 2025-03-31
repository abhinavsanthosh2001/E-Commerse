package com.abhinav.order_service.config;

import com.abhinav.base_domains.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.bootstrap-servers}")
    String bootstrapServers;

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name(topicName)
                //.partitions(3)
                .build();
    }

    // For custom config
//    @Bean
//    public ProducerFactory<String, OrderEvent> producerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
//        return new DefaultKafkaProducerFactory<>(config);
//    }


//For custom config
//    @Bean
//    public KafkaTemplate<String, OrderEvent> kafkaTemplate() {
//        return new KafkaTemplate<>();
//    }
}
