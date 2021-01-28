package com.example.notifier.service.impl;

import com.example.notifier.domain.SkillTestInfo;
import com.example.notifier.service.KafkaStreamingService;
import com.example.notifier.service.NotifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifierServiceImpl implements NotifierService {

    private final KafkaStreamingService kafkaStreamingService;
    @Autowired
    public NotifierServiceImpl(KafkaStreamingService kafkaStreamingService) {
        this.kafkaStreamingService = kafkaStreamingService;
    }

    @Override
    public String addNofification(SkillTestInfo skillTestInfo) {
        kafkaStreamingService.sendMessage(skillTestInfo.getName(),skillTestInfo);
        return skillTestInfo.getName();
    }
}
