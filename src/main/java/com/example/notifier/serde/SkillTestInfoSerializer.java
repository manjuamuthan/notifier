package com.example.notifier.serde;

import com.example.notifier.domain.SkillTestInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class SkillTestInfoSerializer implements Serializer<SkillTestInfo> {

    private static final Logger LOOGER = LoggerFactory.getLogger(SkillTestInfoSerializer.class);
    private ObjectMapper objectMapper;

    public SkillTestInfoSerializer() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, SkillTestInfo data) {
        byte[] bytes = null;

        try {
            bytes = objectMapper.writeValueAsString(data).getBytes();
        } catch (JsonProcessingException e) {
            LOOGER.error("Error while converting SkillTestInfo to byte[] ", e);
        }

        return bytes;
    }

    @Override
    public void close() {

    }
}
