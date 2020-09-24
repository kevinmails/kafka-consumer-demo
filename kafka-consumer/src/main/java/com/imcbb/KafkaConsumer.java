package com.imcbb;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author kevin
 * Date 2020-09-24
 * Time 09:43
 */
@Service
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);


    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new ThreadFactoryBuilder().setNameFormat("KThread-%d").build(),
            (r, executor) -> {
                logger.warn("Ops，Rejected！");
                try {
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
//                        new ThreadPoolExecutor.CallerRunsPolicy()

    );

    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) {

        executor.execute(() -> {
            logger.info("---------" + cr.toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
