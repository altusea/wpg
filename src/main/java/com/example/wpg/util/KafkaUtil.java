package com.example.wpg.util;

import org.apache.kafka.common.protocol.ApiKeys;
import org.apache.kafka.common.utils.AppInfoParser;

public class KafkaUtil {

    static void main() {
        String clientVersion = AppInfoParser.getVersion();
        System.out.println("当前 Kafka Java Client 版本: " + clientVersion);
        // 遍历 Kafka 客户端支持的所有底层 API 协议
        for (ApiKeys key : ApiKeys.values()) {
            System.out.printf("API名称: %-25s | 客户端支持最低版本: %d | 客户端支持最高版本: %d%n",
                    key.name(),
                    key.oldestVersion(),  // Client 支持的最低协议版本
                    key.latestVersion()); // Client 支持的最高协议版本
        }
    }
}
