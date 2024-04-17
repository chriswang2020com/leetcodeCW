系统调用控制方法：https://www.cnblogs.com/lilpig/p/16735418.html
https://javabetter.cn/nio/moxing.html
select，poll，epoll三大件
write，read

- select 每次要重新创建文件描述符（从哪来，写哪去）fd_set轮询，在用户态和内核态之间复制
- poll创建数组，无需重构fd_set
- epoll内核中创建上下文

零拷贝技术
- mmap+write：虚拟内存映射
- sendfile：直接发送文件，缺点是不能修改