package com.imcbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author kevin
 *
 * Date 2020-09-24
 * Time 09:34
 */
@SpringBootTest
public class KafkaProducerClientTests {


    @Autowired
    private KafkaTemplate template;

    @Test
    public void produceKafkaMsg(){


        for (int i = 0; i < 1000; i++) {

            this.template.send("myTopic", "data:" + i );
        }


    }


}
