# AQS组成部分
1. CLS队列，FIFO
2. state状态是volatile修饰的，确保一致性。为0代表未锁定。获取到资源state+1
3. 