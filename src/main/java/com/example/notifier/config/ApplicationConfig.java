package com.example.notifier.config;

import com.example.notifier.domain.SkillTestInfo;
import com.example.notifier.serde.SkillTestInfoSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class ApplicationConfig {

        @Value("${kafka.bootstrap-servers}")
        private String bootstrapServers;

        @Autowired
        private KafkaProperties kafkaProperties;

        @Bean
        public Map<String, Object> producerConfigs() {
            Map<String, Object> props = new HashMap<>();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SkillTestInfoSerializer.class);
            return props;
        }

        @Bean
        public ProducerFactory<String, SkillTestInfo> producerFactory() {
            return new DefaultKafkaProducerFactory<>(producerConfigs());
        }

        @Bean
        public KafkaTemplate<String, SkillTestInfo> kafkaTemplate() {
            return new KafkaTemplate<>(producerFactory());
        }

    }

