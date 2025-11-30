# 线上图书商城
## 技术栈

**spring-boot + Vue3 + Mybatis-Plus**

## 需求分析

### 1. 项目总体结构

```
src/main/java/com/bookstore
│
├── common
│   ├── exception           # 全局异常、自定义异常类
│   ├── result              # 统一响应封装（R、ResultCode）
│   ├── utils               # 工具类（JWT、Redis等）
│   └── config              # CORS、MyBatisPlus、Swagger
│
├── security
│   ├── jwt                 # Jwt 工具、Token 过滤器
│   ├── handler             # 未登录/权限不足处理
│   └── config              # SpringSecurity 配置
│
├── modules
│   ├── user               # 用户模块（注册登录/用户信息/地址管理）
│   │   ├── controller
│   │   ├── service
│   │   ├── service/impl
│   │   ├── mapper
│   │   └── entity
│   │
│   ├── book               # 图书模块（商品列表/分类/详情/评论）
│   │   ├── controller
│   │   ├── service
│   │   ├── service/impl
│   │   ├── mapper
│   │   └── entity
│   │
│   ├── cart               # 购物车模块
│   │   ├── controller
│   │   ├── service
│   │   ├── service/impl
│   │   ├── mapper
│   │   └── entity
│   │
│   ├── order              # 订单模块（提交订单 / 订单详情 / 订单支付）
│   │   ├── controller
│   │   ├── service
│   │   ├── service/impl
│   │   ├── mapper
│   │   └── entity
│   │
│   ├── admin              # 后台管理功能（图书增删查改、订单管理）
│       ├── controller
│       ├── service
│       ├── service/impl
│       ├── mapper
│       └── entity
│
└── BookstoreApplication.java

```

## 1️⃣ 用户模块（User Module）

### 功能对应你的需求：

- [ ] 注册登录（支持 JWT）

- [x]  用户管理（修改资料）

- [x]地址管理（收货地址：添加/编辑/删除/设默认）

- [x]用户收藏（书籍收藏夹）

### 文件示例

`modules/user/controller/UserController.java 
modules/user/controller/LoginController.java
modules/user/controller/RegistController.java
modules/user/service/UserService.java
modoules/user/service/impl/UserServiceImpl.java
modules/user/mapper/UserMapper.java 
modules/user/entity/User.java 
modules/user/entity/UserProfiles.java
modules/user/entity/UserFavourites.java
...`

## 2️⃣ 图书模块（Book Module）

### 功能对应：

- [ ] 图书分类（list 分类树）

- [ ] 图书 CRUD（后台管理）

- [x] 图书详情（前台）

- [x] 评论系统（书籍评论/评分）

- [ ] 评论展示（分页显示评论）待完善  

- [x] 图书搜索（按标题/作者/分类搜索）   


`modules/book/controller/BookController.java modules/book/controller/CategoryController.java modules/book/controller/CommentController.java`

---

## 3️⃣ 购物车模块（Cart Module）

### 功能： 实现增删改查

- [x] 添加商品到购物车

- [x] 修改数量

- [x] 删除条目

- [x] 获取用户购物车列表


`modules/cart/controller/CartController.java`

---

## 4️⃣ 订单模块（Order Module）

### 功能：

- [ ] 生成订单（从购物车或立即购买）

- [ ] 订单支付状态更新（模拟支付或支付宝沙箱）

- [ ] 订单列表

- [ ] 订单详情

- [ ] 取消订单 / 确认收货


`modules/order/controller/OrderController.java modules/order/entity/Order.java modules/order/entity/OrderItem.java`

---

## 5️⃣ 后台管理模块（Admin Module）

包含：

- [ ] 管理员登录（JWT 鉴权） 

- [ ] 图书管理（CRUD、上下架）

- [ ] 分类管理

- [ ] 用户管理

- [ ] 订单管理（查看/发货）

- [ ] 数据统计（可视化：销量、销售额）


`modules/admin/controller/AdminBookController.java modules/admin/controller/AdminOrderController.java modules/admin/controller/AdminUserController.java`

---

# ✅ 四、数据库表设计（与你的需求图对应）

### 核心表：

| 表名                | 描述    |
|-------------------|-------|
| `user`            | 用户表   |
| `user_profiles`   | 用户详情表 |
| `user_favourites` | 用户收藏表 |
| `book`            | 图书信息  |
| `reviews`         | 评论    |
| `cart`            | 购物车   |
| `order`           | 订单主表  |
| `order_item`      | 订单明细  |
| `admins`          | 后台管理员 |

---

# ✅ 五、SpringSecurity + JWT 鉴权结构

```
security/
├── config/SecurityConfig.java
├── jwt/JwtUtil.java
├── jwt/JwtAuthenticationFilter.java
├── handler/AccessDeniedHandler.java
└── handler/AuthenticationEntryPoint.java

```

前台用户与后台管理员可采用**两套 JWT** 或在 token 内加角色字段。

# ✅ 六、后端接口风格（RESTful 示例）

### 获取图书列表

`GET /api/book/list?page=1&size=10`

### 登录

`POST /api/auth/login`

### 创建订单

`POST /api/order/create`

### 后台添加图书

`POST /admin/book/add`

---

### 2. 项目基础功能（第13章）

#### 2.1 项目概述（13.1）

- 需求分析
    
- 功能结构
    
- 项目整体预览
    

#### 2.2 数据库设计（13.2）

- E-R 图设计
    
- 数据表结构设计
    

#### 2.3 项目环境搭建（13.3）

---

### 3. 前端功能模块（第14章）

#### 3.1 用户功能模块

##### 3.1.1 用户注册功能（14.1）

- 提交注册表单
    
- 用户名/邮箱/密码等字段校验
    
- 写入数据库
    
- 返回注册成功/失败状态
    

##### 3.1.2 用户登录功能（14.2）

- 用户名 + 密码验证
    
- Session 或 Cookie 管理
    
- 登录状态保持与退出
    

---

#### 3.2 商品浏览与搜索模块

##### 3.2.1 购物车功能（14.3）

- 添加商品到购物车
    
- 修改商品数量
    
- 删除购物车项
    
- 计算购物车总价
    

##### 3.2.2 商品分类查询功能（14.4）

- 按商品类目展示商品
    
- 类目筛选
    

##### 3.2.3 商品搜索功能（14.5）

- 输入关键字
    
- 返回匹配商品列表
    

---

### 4. 后台管理模块（第15章）

#### 4.1 后台管理系统概述（15.1）

后台系统面向管理员使用，主要实现以下目标：

- 管理商品信息、库存与推荐状态
    
- 管理客户帐号
    
- 管理订单
    
- 管理商品类别
    
- 提供可维护的后台管理界面

---

#### 4.2 商品管理模块（15.2）

##### 4.2.1 商品添加功能（15.2.1）

- 上传商品图片
    
- 输入商品名称、价格、描述、库存、分类等信息
    
- 提交后写入数据库
    

##### 4.2.2 商品信息修改功能（15.2.2）

- 可编辑商品名称、图片、描述、价格等
    
- 保存后更新数据库
    

##### 4.2.3 商品删除功能（15.2.3）

- 从商品列表中删除指定商品
    
- 执行逻辑删除或物理删除
    

##### 4.2.4 商品加入/移出推荐功能（15.2.4）

- 支持设置首页推荐商品
    
- 支持手动移出推荐列表
    

---

#### 4.3 订单管理模块（15.3）

##### 4.3.1 查询订单列表功能（15.3.1）

- 查看所有用户的订单记录
    
- 支持按日期/用户/订单状态筛选
    
- 支持分页查看订单
    

##### 4.3.2 删除订单功能（15.3.2）

- 删除指定订单（通常为逻辑删除）
    

---

#### 4.4 客户管理模块（15.4）

##### 4.4.1 添加客户功能（15.4.1）

- 后台可创建新用户
    
- 输入用户名、密码、联系方式等
    

##### 4.4.2 修改客户信息功能（15.4.2）

- 编辑客户基本信息，如昵称、电话、地址等
    

##### 4.4.3 删除客户功能（15.4.3）

- 删除指定用户（通常为禁用或逻辑删除）
    

##### 4.4.4 重置客户密码功能（15.4.4）

- 管理员可直接重置用户登录密码
    

---

#### 4.5 商品类别管理模块（15.5）

- 添加商品类别
    
- 编辑商品类别
    
- 删除商品类别
    
- 查看类别列表（含名称、排序等字段）
    

---

### 4.6 本章小结（15.6）

后台管理系统包含：

- 商品增删改查与推荐管理
    
- 客户账号管理
    
- 订单查询与删除
    
- 商品类别管理
    
---
