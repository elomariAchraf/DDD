package com.pmu.mvp.infrastructure.kafka;

import com.pmu.mvp.domain.Course;
import com.pmu.mvp.domain.KafkaProducerService;
import com.pmu.mvp.infrastructure.kafka.record.CourseMessage;
import com.pmu.mvp.infrastructure.kafka.record.converter.MessageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImplementation implements KafkaProducerService {

    private final KafkaTemplate<String, CourseMessage> kafkaTemplate;

    private final KafkaProducerConfiguration kafkaProducerConfiguration;

    private final MessageConverter messageConverter;
    public void sendMessage(Course course) {
        kafkaTemplate.send(kafkaProducerConfiguration.getTopic(), messageConverter.toCourseMessage(course));
    }
}
