> 我还欠缺什么
> mysql, redis, 网络, hashmap
> LeetCode, 线程安全, 结合项目并发，jvm，spring,api,日志，接口测试
> 我完成了什么
> 并发，锁，部分mysql，rocketmq

死锁实战：https://blog.csdn.net/cooper20/article/details/110238195
索引失效：https://mp.weixin.qq.com/s/mwME3qukHBFul57WQLkOYg
优化总结：https://cloud.tencent.com/developer/article/1921568
mysql慢查询, 索引失效：https://cloud.tencent.com/developer/article/2350545
sharding:https://zhuanlan.zhihu.com/p/610182326


### 难的问题
1. 如何一次性导入1000w数据
2. mysql预防死锁：MySQL锁定：死锁及其避免方法
3. 

MySQL 索引
补充：
- 联合索引：ALTER TABLE `cus_order` ADD INDEX id_score_name(score, name);
- 索引下推：联合索引时，server筛下推到引擎筛，直接把对的name的也筛出来，减少回表次数。
- 索引失效：https://mp.weixin.qq.com/s/mwME3qukHBFul57WQLkOYg
1. 为什么索引能提⾼查询速度?
> 数据量大的情况下，索引可以减少检索的数据量。B+树结构
2. 聚集索引和⾮聚集索引的区别？⾮聚集索引⼀定回表查询吗?
> 聚集叶子节点放data，非聚集叶子节点放回表的主键索引。非聚集索引如果查主键索引就不需要回表
3. 索引这么多优点，为什么不对表中的每⼀个列创建⼀个索引呢？(使⽤索引⼀定能提⾼查
   询性能吗?)
> 1. 浪费空间
> 2. 执行器从更多选项中选，效率低
> 3. 增删改查浪费时间
> 4. 索引锁，更多锁竞争
4. 索引底层的数据结构了解么？Hash 索引和 B+树索引优劣分析
> 主要是因为 Hash 索引不支持顺序和范围查询。 并且，每次 IO 只能取一个。

5. B+树做索引⽐红⿊树,B树好在哪⾥？
> 对比优缺点
> 创建成本：红黑树O1，B+树O（logN），B+树分支更多，通过满了就分裂的方法维持平衡，红黑树通过标记颜色旋转保持平衡
> 数据量：B+树三层能放1000^3, 红黑树只有两个分支，能存放2^h。数据量大的情况下B+树检索次数更少。
> 效率：B+树IO更少
> B树所有节点都存data，B树叶子节点没有链表，只是二叉多很多叉
> B+树与 B 树相比，具备更少的 IO 次数、更稳定的查询效率和更适于范围查询这些优势
6. 最左前缀匹配原则了解么？
> 联合索引的最左侧，因为非聚集索引有优先级。若ADD INDEX a，b那么直接查b就无法用联合索引
> 因为b根本没有自己单独的索引，所以遇到查询范围>,< 则停止匹配，>=可以筛=的部分，between可取边界值
7. 什么是覆盖索引
> where的列，都包括在一个索引表里，直接查到数据无需回表。
8. 如何查看某条 SQL 语句是否⽤到了索引？
- explain
- 看type，all是全表扫描，const是值匹配，ref是列与列数据匹配，**index是索引覆盖**，index_merge是索引合并
- 看key_len了解索引叶子节点数据的大小
- 看执行计划筛的数量rows，filtered最后满足条件的数量
- extra，using where再server层判断
- optimizer trace看各种执行计划成本
- mysql> explain SELECT * FROM dept_emp WHERE emp_no IN (SELECT emp_no FROM dept_emp GROUP BY emp_no HAVING COUNT(emp_no)>1);
  +----+-------------+----------+------------+-------+-----------------+---------+---------+------+--------+----------+-------------+
  | id | select_type | table    | partitions | type  | possible_keys   | key     | key_len | ref  | rows   | filtered | Extra       |
  +----+-------------+----------+------------+-------+-----------------+---------+---------+------+--------+----------+-------------+
  |  1 | PRIMARY     | dept_emp | NULL       | ALL   | NULL            | NULL    | NULL    | NULL | 331143 |   100.00 | Using where |
  |  2 | SUBQUERY    | dept_emp | NULL       | index | PRIMARY,dept_no | PRIMARY | 16      | NULL | 331143 |   100.00 | Using index |
  +----+-------------+----------+------------+-------+-----------------+---------+---------+------+--------+----------+-------------+
- | 列名            | 含义                      |
  |---------------|-------------------------|
  | id            | 查询的序列标识符                |
  | select_type   | 查询类型关键字                 |
  | table         | 使用的表名                   |
  | partitions    | 匹配的分区，对于未分区的表为 NULL     |
  | type          | 表的访问方法                  |
  | possible_keys | 可能使用到的索引                |
  | key           | 实际使用到的索引                |
  | key_len       | 所选索引的长度，varchar（10）     |
  | ref           | 与索引比较的列或常量（仅当使用索引等值查询时） |
  | rows          | 预计要读取的行数                |
  | filtered      | 过滤条件后保留的记录数的百分比         |
  | Extra         | 附加信息                    |


优化总结：https://cloud.tencent.com/developer/article/1921568
mysql慢查询：https://cloud.tencent.com/developer/article/2350545
MySQL 性能优化
1. 能⽤ MySQL 直接存储⽂件（⽐如图⽚）吗？
- 文件（比如图片）这类大的二进制数据通常存储于文件服务器，数据库只存储文件地址信息
2. MySQL 如何存储 IP 地址？
3. 如何分析 SQL 的性能？
- explain，慢sql
4. 有哪些常⻅的 SQL 优化⼿段？
- 先分析，慢sql，profiling查看每一步时间，performance schema
- 外部：减少查询压力，线程池控制并发数量
- 语句：用子查询，join延迟关联分页优化，多用覆盖索引减少回表，顺序io
- 减少join：单表查询后在内存中自己做关联
- 一致性：外键的设置
- 优化慢sql：找到慢的语句再explain，设置合适的索引，避免冗余索引，字符串使用前缀索引
5. 简单说⼀下⼤表优化的思路。
- 分库分表
6. 读写分离如何实现？
- 主从mysql，通过binlog更新
7. 为什么要分库分表？有哪些常⻅的分库分表⼯具？
- Sharding-JDBC & Mycat
- 实战：https://zhuanlan.zhihu.com/p/610182326
8. 深度分⻚如何优化？
9. 数据冷热分离如何做？
- 业务层代码：判断冷数据，直接入库
- 任务调度：xxl-job定时扫描数据库，找出数据放到冷库
- 监听binlog
10. 常⻅的数据库优化⽅法有哪些？

死锁实战：https://blog.csdn.net/cooper20/article/details/110238195
   MySQL 锁
   表级锁和⾏级锁有什么区别？
   哪些操作会加表级锁？哪些操作会加⾏级锁？请简单举例说⼀下。
   InnoDB 有哪⼏类⾏锁？
   Next-Key Lock 的加锁范围？
   当前读和快照读有什么区别？
   MySQL 如何使⽤乐观锁和悲观锁？



