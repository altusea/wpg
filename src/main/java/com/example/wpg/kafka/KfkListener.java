package com.example.wpg.kafka;

import com.example.wpg.kafka.msg.Foo2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KfkListener {

    private final Logger logger = LoggerFactory.getLogger(KfkListener.class);

    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    @KafkaListener(id = "fooGroup", topics = "topic1")
    public void listen(Foo2 foo) {
        logger.info("Received: " + foo);
        if (foo.getFoo().startsWith("fail")) {
            throw new RuntimeException("failed");
        }
        this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
    }

    @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
    public void dltListen(byte[] in) {
        logger.info("Received from DLT: " + new String(in));
        this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
    }
}
