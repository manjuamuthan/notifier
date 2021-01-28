package com.example.notifier.service;

import com.example.notifier.domain.SkillTestInfo;

public interface KafkaStreamingService {
    void sendMessage(final String key, final SkillTestInfo skillTestInfo);
}
