
## cookie, session, token

---
- 定义： cookie，就是发用户名和密码而已，服务器发送用户名密码通过set-cookie到浏览器，客户端请求带cookie作为验证。
- session：用sessionid取代用户名密码
1. 登陆成功设置唯一sessionid
2. 绑定sessionid和身份
3. 发送给客户端，客户发cookie的sessionid
4. 查找关联，若过期则重新登录

- token：加密用户名cookie，隐藏了密码，header，payload，signature
- cookie存在浏览器
- session存在服务器

token采用payload存储用户身份信息，signature存储加密部分，用header表明的算法进行加密，服务端负责签名不需要存储sessionid