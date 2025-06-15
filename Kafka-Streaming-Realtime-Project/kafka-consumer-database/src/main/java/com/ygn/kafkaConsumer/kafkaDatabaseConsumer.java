package com.ygn.kafkaConsumer;

import com.ygn.kafkaConsumer.Repository.WikimediaDataRepository;
import com.ygn.kafkaConsumer.entity.WikimediaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaDatabaseConsumer.class);

    @Autowired
    private WikimediaDataRepository dataRepository;

    @KafkaListener(
                topics = "wikimedia_recentchange",
                groupId = "myGroup"
    )
    public void cosnume(String eventMessage)
    {
        LOGGER.info(String.format("Message recieved -> %s",eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        dataRepository.save(wikimediaData);
    }
}
