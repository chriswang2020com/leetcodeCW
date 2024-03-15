## 自我介紹
面试官，您好！我叫王正宏。大学时间我主要利用课外时间学习了 Java 后端开发相关的知识。在校期间参与了一个网盘社区的开发，我在其中主要担任后端开发。

遇到的问题以及如何解决

面试提问
1. sharding-jdbc分库分表如何实现
2. MinIO如何分片上传
3. WebSocket原理 https://zhuanlan.zhihu.com/p/161661750   
- 推荐！！！ http://www.52im.net/thread-331-1-1.html 
- 前端 https://github.com/nnngu/WebSocketDemo-js/blob/master/index.html
- 后端 https://cloud.tencent.com/developer/article/2346495

4. 如何接入支付宝支付业务
5. completableFuture如何优化：https://tech.meituan.com/2022/05/12/principles-and-practices-of-completablefuture.html
- 线程池实战：https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html
6. Hyperloglog数据结构：统计概率，https://www.yuque.com/snailclimb/tangw3/ylfks98yh4cd48rr
7. RocketMQ如何保证一致性：
8. redisson分布式锁
9. spring bean的周期，加载机制
10. RBAC模型，认证权限
11. 削峰操作：https://cloud.tencent.com/developer/article/1629610，https://blog.csdn.net/qq_36135928/article/details/121146631
12. ali支付：https://juejin.cn/post/6844903782749306894
13. 设计模式
14. 分布式算法。

# websocket
> 1. 如何进入websocket，connection：upgrade放在header里，升级http。
> - 轮询
> - ajax轮询：隔几秒发送请求
> - long poll：阻塞模型，不发response卡住服务器。需要高并发机器
> - websocket

## 补充点
1. 哪里实现了mysql锁粒度
2. java的锁粒度
3. 数据库表设计
4. 项目设计模式DDD等
5. 
---
websocket:https://zhuanlan.zhihu.com/p/161661750
completableFuture:https://tech.meituan.com/2022/05/12/principles-and-practices-of-completablefuture.html


---
简历内容

- 利用JWT实现用户邮箱验证码登录，登录成功后在Redis中储存用户登录凭证

- 实时文件共享功能：
  - 利用websocket实现云端与用户本地的实时同步。
  - 权限管理使用Sa-Token实现拥有空间权限的用户可以设置网盘路径与本地路径文件同步。
  - 使用MinIO的分片上传机制，允许5GB以下文件上传。
- 事务以及高并发优化：
  - 使用@Transactional注解，管理事务的开始、提交和回滚，实现数据一致性。MyBatis-Plus进行MySQL数据库用户，空间信息的增删改查。
  - 接入支付宝APP支付，允许空间所有者出售空间使用权。
  - 使用RocketMQ对同时刻大批量请求进行削峰。
  - 通过Redisson分布式锁限制空间下载次数解决超卖，重复秒杀问题，保证了接口的幂等性。
  - 使用RocketMQ优化下单操作，实现下单资格判断和订单信息入库的异步操作，提升并发性。
- 用户体验优化
  - 使用CompletableFuture 优化查询模块，对获取用户信息、商品详情等异步调用进行编排，响应时间从 0.5s 降低为 0.2s。
  - Redis存储token确保一致性，减少数据库IO
  - HyperLogLog和Bitmap用于高效统计UV，优化资源占用。
  - 使用redis的zset进行全平台点赞，购买量排行
  - RocketMQ作为消息队列中间件，主动推送文件共享和新评论通知给客户端，确保信息的实时性和系统的解耦。


使用RocketMQ优化下单操作，实现下单资格判断和订单信息入库的异步操作，提升并发性
使用 CompletableFuture 优化购物车查询模块，对获取用户信息、商品详情等异步调用进行编排，响应时间从 0.5s 降低为 0.2s。


客户端服务器通主动通知客户端点赞收藏消息。如何确保用户收到，重新联网时能狗收到？SSE？websocket
网盘社区：redis实现排行榜


---
登录功能：jwt，sa-token
权限管理sa-token：拥有者才能修改内容。https://zhuanlan.zhihu.com/p/343506493
基于mysql乐观锁和redisson分布式锁解决秒杀流程中的并发问题
分布式事务：限制下载次数。

利用基于Kafka消息中间件异步解耦，削峰的原理，堆抽奖发货进行异步解耦，堆活动库存扣减进行削峰
利用AOP切面拦截请求，获取参数进行路由计算，结合ThreadLocal存取，完成动态切换数据源

从0到1接入支付宝APP支付、网站支付、账单退款等，通过工厂模式+策略模式重构原有微信支付模块，提高支付模块可扩展性，降低耦合性

利用Spring Security + JWT 实现用户邮箱验证码登录与授权，登录成功后在Redis 中储存用户登录凭
利用Kafka，异步完成邮箱发开，转账等相对来说耗时操作，对这部分功能进行解耦并增大系统响应速度
利用Kafka 实现站内消息系统，当拍卖结束，拍卖买取消时使用Kafka 利用异步的方式发开站内通知
针对每一笔交易生成一个唯一的订单号，防止因网络等原因导致重复支付，重复廿款，重复交易问题
使用Minio的分片上传机制，有效提升了数据上传的效率
渠道打包模块的开发使用CompletableFuture，把大数据拆分为多个小数据后进行并行处理，平均打包时间缩短60%以上
使用MAT工具分析dump文件，定位OOM的原因。后面进行代码优化并进行压力测试，以压测标准进行JVM参数设 定，解决了大数据量Excel导致内存溢出的问题

1.	程序员方面：热爱编程，以写出高效、易维护的代码为目标，严格遵守代码规范
2.	自我方面：性格开朗，善于活跃气氛，融入能力非常强


1. 秒杀系统
2. redis排行榜
3. 登录
4. 线程优化，线程安全，事务安全
5. 设计模式
6. 消息推送方式：https://zhuanlan.zhihu.com/p/547875840
7. 支付系统
   https://zhuanlan.zhihu.com/p/161661750


使用 Redis 缓存解决了传统的基于 Cookie-Session 登录校验机制中存在的 Session 不共享问题，并使用
双层拦截器实现了 token 过期时间的动态更新。
参与购物车模块的开发，负责购物车的添加、清空、查询等功能。
使用 CompletableFuture 优化购物车查询模块，对获取用户信息、商品详情等异步调用进行编排，响应
时间从 0.5s 降低为 0.2s。https://tech.meituan.com/2022/05/12/principles-and-practices-of-completablefuture.html
基于 AOP，将球星卡增、删、改相关接口的操作日志记录到数据库表，便于后期数据追踪。
使用 WebSocket 实现来单提醒，用于服务端向用户发送出售成功的消息。


--- 
我的版本：
面试官，您好！我叫王正宏。大学时间我主要利用课外时间学习了 Java 后端开发相关的知识。在校期间参与了一个网盘社区的开发，我在其中主要担任后端开发

面试官，您好！我叫秀儿。大学时间我主要利用课外时间学习了 Java 后端开发相关的知识。在校期间参与过一个校园考试系统的开发，我在其中主要担任后端开发，主要负责项目搭建部署、技术选型、权限管理功能开发等工作。另外，我在大学的时候参加过一次软件编程大赛，我和我的团队做的在线客服系统成功获得了第二名的成绩。我在其中担任后端编程主力。我还利用自己的业余时间写了一个简单的 RPC 框架，这个框架用到了 Netty 进行网络通信， 目前我已经将这个项目开源，在 Github 上收获了 2k 的 Star! 我平时比较喜欢通过博客整理分享自己所学知识，现在已经是多个博客平台的认证作者，积累了 1w+ 的读者。我一直都非常想加入贵公司，我觉得贵公司的文化和技术氛围我都非常喜欢，期待能与你共事！