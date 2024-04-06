package com.arun.usermanagement.consumer;

import com.arun.usermanagement.util.ApplicationConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JournalConsumer {


    @KafkaListener(topics = ApplicationConstants.TOPIC_NAME, groupId = ApplicationConstants.GROUP_ID_JSON)
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
