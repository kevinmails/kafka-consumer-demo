# kafka-consumer-demo
这个项目意在演示，在kafka分区无法增加的情况下，通过使用线程池来提升消费能力

<font color=red size=4>!!!需特别注意，多线程下很难保证消费的顺序，如果对消费有严格顺序要求的慎用</font>


####需要JDK1.8以上环境

1.本机安装kafka,官方安装手册：https://kafka.apache.org/quickstart

2.下载源码，导入IDE

3.运行kafka-consumer模块下的KafkaConsumerApplication类接收消息

4.运行kafka-producer模块下的KafkaProducerApplication类推送消息

5.到kafka-consumer的控制台观察结果

