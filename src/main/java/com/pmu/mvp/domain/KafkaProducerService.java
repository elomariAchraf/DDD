package com.pmu.mvp.domain;

public interface KafkaProducerService {
    void sendMessage(Course courseMessage);
}
