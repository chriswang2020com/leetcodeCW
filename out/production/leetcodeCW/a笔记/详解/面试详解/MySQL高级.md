mysql大表优化
分区，垂直分表，水平分表，分库，
字符字段只建前缀索引
字符字段最好不要做主键
# 深度分页问题


# 索引失效
> 1. 最左前缀原则，无a就失效
> 2. 计算 WHERE stuno+1 = 900001;导致失效
> 3. 类型转换
> 4. like以%开头，索引是以前面的字符作为索引标记的
> 5. OR满足一个条件即可，有一个没索引就会全表扫描


# 数据库文件存储位置


# redo log
mysql每次查询都会把一整页拿到buffer中，再从buffer中过滤，减少io
更改时直接改buffer中更新
redo log（重做日志）让InnoDB存储引擎拥有了崩溃恢复能力。在innodb层
binlog（归档日志）保证了MySQL集群架构的数据一致性。在server层
> 目的：回滚，重做恢复
> 内容：事务id，更新后的rowid，回滚指针
> 流程：即使未commit也放入buffer，记录做了什么修改，搭建版本链，允许回滚
> 1. update事务进入bufferpool
> 2. redo buffer加载，事务提交后刷盘，后台线程每1s轮询
> 3. 数据页合适时机刷盘
> 刷盘地点：bufferpool redo buffer， pagecache，磁盘
> 每秒操作！
> 参数0：刷到redo buffer
> 参数1：刷到磁盘
> 参数2：刷到pagecache

# 两阶段提交
redolog的写入拆成prepare和commit步骤，binlog成功则设置为commit。重做时查prepare对应的binlog id，不存在则回滚。

# MVCC
> 1. 当前读 vs. 快照读
> - 当前读为SELECT ...  FOR UPDATE
> - 快照读为根据undolog的事务版本号读取
> 三大件：隐式字段，undolog，readview
> RU：最低隔离级别，允许读未提交的数据
> RC：只读取已提交，解决脏读，保留最新的事务id作为readview
> RR：可重复读，保留查询事务id开始时间的readview
> 序列化：禁止并发执行，绝对一致
> 临键锁：当执行当前读时，会锁定读取到的记录的同时，锁定它们的间隙，防止其它事务在查询范围内插入数据。只要我不让你插入，就不会发生幻读



