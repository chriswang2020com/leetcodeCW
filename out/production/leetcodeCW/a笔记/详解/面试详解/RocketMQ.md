消息堆积等系列：https://www.cnblogs.com/wzh2010/p/15888534.html

# 顺序消费

# 重复消费
1. 消息去重
2. 后端幂等性处理
3. 使用消息唯一标识
4. 消息状态存储

# 消息发送，producer
1. 由于无需更改内容，sendfile零拷贝技术映射实现

# 消息接收consumer
1. pushconsumer，simple，pullconsumer