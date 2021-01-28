package com.example.notifier.service.impl;

import com.example.notifier.domain.SkillTestInfo;
import com.example.notifier.service.KafkaStreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.notifier.constants.CommonConstants.SKILL_TEST_INFO_TOPIC;

@Service
public class KafkaStreamingServiceImpl implements KafkaStreamingService {

    private final KafkaTemplate<String, SkillTestInfo> kafkaTemplate;
    @Autowired
    public KafkaStreamingServiceImpl(KafkaTemplate<String, SkillTestInfo> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String key, SkillTestInfo skillTestInfo) {
        kafkaTemplate.send(SKILL_TEST_INFO_TOPIC, key, skillTestInfo);
    }
}
