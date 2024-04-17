redis数据结构：https://blog.csdn.net/shark_chili3007/article/details/104171986
todo：
> redis事务？布隆过滤器。缓存机制读写穿透，
> zset，ziplist 已完成
> redis健壮性
> bigkey,热点
> mysql数据库分区。
> 为什么要用多线程
> 着重复习持久化，AOF写入流程
> redis平滑数据迁移 https://blog.csdn.net/qq_16063307/article/details/102928217




- save，aof，rdb
1. redis为什么这么快
- 存在内存中
- 优化数据类型
- 单线程事件循环
- io多路复用
- 特点：单线程维持原子性
2. 分布式缓存常⻅的技术选型⽅案有哪些？说⼀下 Redis 和 Memcached 的区别和共同点
memcashed和redis，都基于内存性能高，有过期策略。memcached只支持最简单的k/v数据类型。
--- 
## 我的八股
1. String + Json也是存储对象的一种方式，那么存储对象时，到底用 String + json 还是用 Hash 呢？
- 一般对象用 String + Json 存储，对象中某些频繁变化的属性可以考虑抽出来用 Hash 类型存储。


## 分布式锁的条件
- 互斥，锁只能被一个线程持有
- 高可用：锁不会被卡住不释放
- 可重入
- 高性能：获取释放锁快速，非阻塞：获取不到不等待

--- 
## redis应用
Redis 五种数据类型的应用场景：

- **String** 类型的应用场景：存token，缓存对象、常规计数、分布式锁、共享session信息等。
- **List** 类型的应用场景：消息队列（有两个问题：1. 生产者需要自行实现全局唯一 ID；2. 不能以消费组形式消费数据）等。
- **Hash** 类型的应用场景：缓存对象、购物车等。
- **Set** 类型的应用场景：聚合计算（并集、交集、差集）场景，比如点赞、共同关注、抽奖活动等。
- **Zset** 类型的应用场景：排序场景，比如排行榜、电话和姓名排序等。

Redis 后续版本又支持四种数据类型，它们的应用场景如下：

- **BitMap**（2.2 版新增）：二值状态统计的场景，比如签到、判断用户登陆状态、连续签到用户总数等；
- **HyperLogLog**（2.8 版新增）：海量数据基数统计的场景，比如百万级网页 UV 计数等；
- **GEO**（3.2 版新增）：存储地理位置信息的场景，比如滴滴叫车；
- **Stream**（5.0 版新增）：消息队列，相比于基于 List 类型实现的消息队列，有这两个特有的特性：自动生成全局唯一消息ID，支持以消费组形式消费数据。

- Redisson分布式锁
- 限流：Redis+Lua
- 延时队列，sorted set
- 分布式session
- 统计uv
---


### redisson分布式锁
**分布式锁的条件，3个**
- 互斥，锁只能被一个线程持有
- 高可用：锁不会被卡住不释放
- 可重入
- 额外有，高性能：获取释放锁快速，非阻塞：获取不到不等待


--- 
# 数据类型
- string--SDS
- list--quicklist
- hash--hash，listpack
- set--hash，整数集合
- zset--跳表skiplist，ziplist
- hyperloglog--伯努利实验
- bitmap--二进制
# 数据结构
## SDS数据结构
- 1. len：字符串长度，使用len取代C语言中的\0，strlen
- 2. 不会缓冲区溢出，自动扩容，alloc分配的空间长度-len算剩余空间
- 3. 紧凑型节省内存。
- 4. int，raw，embstr
## 压缩列表ziplist，quicklist，listpack
- 内存紧凑型，zlbytes，zltails记录元信息
- entry有三个prevlen前一个节点的长度，encoding记录数据类型和长度，data实际数据
- 缺陷1.连锁更新，2. 节点数量大查询O（N）
- quicklist = ziplist+双向链表，多个ziplist防止连锁更新
- listpack： 直接取消prevlen，防止列表连锁更新
--- 
```
> ## string的内部实现
>   > - SET lock_key unique_value NX PX 10000，实现分布式锁，NX键key不存在才能设置，10秒过期时间。
>   > - 两个存json例子
>   > 1. MSET user:1:name xiaolin user:1:age 18 user:2:name xiaomei user:2:age 20
>   > 2. SET user:1 '{"name":"xiaolin", "age":18}'
>   > ### 应用
> > 1. 缓存对象
> > 2. 常规计数
> > 3. 分布式锁
> > 4. 共享session信息，分布式session
> ## list
> > - LPUSH key value [value ...] 
> > - 消息队列，LPUSH+RPOP，全局id处理重复，LPUSH mq "111000102:stock:99"
> ## Hash适合存对象
> > - listpack或哈希表 
> > - 小数据使用，内存紧凑减少指针。
> > - HSET key field value 获取HGET key field
> > - HMSET uid:2 name Jerry age 13
> > - 缓存对象+购物车
> ## set保证唯一性，文章用户点赞只能点一次，交集运算共同好友
> - 用哈希表或 **整合数组**
> ## zset 做排行版
> - 底层，压缩链表或跳表，score+member
> - 跳表的优势，类似与B+树但不需要分裂节点和复杂的维护，存储量不需要那么大。不在乎平均分裂
> - ZADD cus_order_set 112 user1 100 user2 123 user3
> - ZREVRANGE cus_order_set 0 2 从高到低，前三个从0到2
> ## Hyperloglog
> - 伯努利实验，算实际/总数多次实验概率统计
> ## bitmap
> - 二进制，
> - 签到打卡，6月3日，在第二个比特上输入1，SETBIT uid:sign:100:202206 2 1
```