# redis

redis的基础结构, String,
Hash
````
///hash
// put
stringRedisTemplate.opsForHash().putAll(tokenKey, userMap);
// get
Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(key);

///string
stringRedisTemplate.opsForValue().set(phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);
stringRedisTemplate.opsForValue().get(phone);
stringRedisTemplate.opsForValue().setBit(key, dayOfMonth - 1, true);
````


经典问题
### 缓存穿透：数据在数据库也不存在，永远不会生效
- 方法：缓存空对象
- 布隆过滤：概率统计

### 缓存雪崩： redis压力过大

### 缓存穿透
基于互斥锁

### 优惠券秒杀