# spring-cloud-fastdevelop 微服务化项目架构
Rapid development scaffolding for Spring Cloud


### 基础配置

- 8761 注册中心 1个： 作为服务注册中心  
- 8762 配置中心 1个： 统一管理微服务直接的配置，配置消息总线blus ，用于动态刷新配置
  - 手动刷新配置： @RefreshScope  + 修改完配置，重启配置服务器，post重启 http://localhost:8762/refresh
- 8763 网关服务1个：作为服务网关控制  (项目对外统一入口)

### 高级配置

- 8764服务链路追踪服务 1个  http://localhost:8764/ 
  - 参考demo1 链路客户端pom需要加spring-cloud-starter-zipkin 
  - 配置需要加
        spring:
          zipkin:
            base-url: http://localhost:8764
        #    即以 100% 的概率将链路的数据上传给 Zipkin Server
          sleuth:
            sampler :
              percentage : 1.0



- 8765 聚合熔断监控服务： 服务集成熔断器图表  ，monitor-service则是把多个图表集成至一起。
  - monitor-service 工程集成了 Turbine 组件 ， 用于聚合多个 Hystrix Dashboard ， Hystrix Dashboard 是监控 Hystrix 熔断器状况的组件。服务集成了Hystrix Dashboard, monitor-service 的功能就是将多个服务的 Hystrix Dashboard 聚合在一起。 
  - 例：8861 集成Hystrix 和 Hystrix Dashboard，调用下服务，打开  http://localhost:8861/hystrix.stream即可查看熔断器的数据指标 。
  - 打开  http://localhost:8861/hystrix，输入  http://localhost:8861/hystrix.stream、2000、随便名字，单击“ monitor” 即可查看熔断器各种数据。
  - 聚合：原本显示一个  现在打开地址可以看到多个工程的聚合图表
- 8766 微服务监控  admin-service 是一个 Spring Boot Admin Server 工程，提供了非常强大 的服务监控功能 ，
可 以查看每个向 eureka-server 注册的服务 的健康状态 、 日志、注册时间线等 ， 井能够集成
Turbine 。
  - admin-service 工程集成了 Spring Boot Admin Server ， 该工程需要向 Eureka Server 注册，获
取 Eureka Server 的注册列表信息 。获取注册列表信息后， Spring Boot Admin Server 会请求注
册列表信息中服务 Actuator 的 API 接口 ，从而获取这些服务的监控信息。所以 ， 所有向 Eureka
Server 注册的其他服务需要加上 Actuator 起步依赖 spring-boot-starter-actuator, Spring Boot 版
本为 1.5x 。 Actuator 开启了安全验证 ， 在本案例中将安全验证关闭，也就是将 management.security.
enabled 设置为 false 。 
  - localhost:8766/  打开 admin-server 的界面 ,“ APPLICATIONS ’‘ 选项展示了 向 Eureka Server 注册的所有客户端实例 ， “ JOURNAL ＂选项为服务注册、 下线 、 剔除的时间线。“ ABOUT ” 选项是关于 Spring Boot Admin 的一些介绍。其 中， 在 “ APPLICATIONS ”选项 的界面展示的客户端实例右侧有一个“ Details ＂ 按钮， 单击该按钮，可以进入客户端实例的详细界面 。 在详细界面可 以查看客户端实例的信息 、 日志信息、指标信息 、 环境信息、日志
级别管理和JMX 等。 
  - 添加登陆页   http://localhost:8766  admin 123456
* 8767 全局日志服务  

  *  日志服务负责解释rabbitmq 发送的保存日志消息，存取消息至数据库
  * 配置了mybatis-generate 逆向工程用来生成mybatis快速开发实体
  * 日志客户端需配置rabbit相关、集成aop、rabbit发送、日志相关服务  
  * @SysLogger("")为标记日志注解

### 业务配置

- 服务提供、服务消费（微服务）
  -  demo1 8861 
  -  demo2 8862
  - demo3 8863  demo3 和demo2为统一工程，测试负载均衡。

### 待实现配置

- 进阶扩展1：日志、监控、权限......  
- 进阶扩展2：负载均衡   高可用注册中心、高可用配置中心......
- 进阶扩展3：会话共存分享（后期可以考虑下jwt json web token 的权限验证方式）
- 进阶扩展4：common : 公共子模块，定义公共类和公用的jar包供其它模块使用。（仅作为公共子模块，各个模块需要引用进来，不作为微服务）




### 注册中心服务注册情况
  | Application        | AMIs        | Availability Zones | Status                                                       |
| :----------------- | :---------- | :----------------- | :----------------------------------------------------------- |
| **ADMIN-SERVER**   | **n/a** (1) | (1)  | **UP** (1) - [Ryan:admin-server:8766](http://ryan:8766/info) |
| **DEMO1-SERVICE**  | **n/a** (1) | (1)  | **UP** (1) - [Ryan:demo1-service:8861](http://ryan:8861/info) |
| **DEMO2-SERVICE**  | **n/a** (2) | (2)  | **UP** (2) - [Ryan:demo2-service:8863](http://ryan:8863/info) , [Ryan:demo2-service:8862](http://ryan:8862/info) |
| **GATEWAY-SERVER** | **n/a** (1) | (1)  | **UP** (1) - [Ryan:gateway-server:8763](http://ryan:8763/info) |
| **LOGGER-SERVER**  | **n/a** (1) | (1)  | **UP** (1) - [Ryan:logger-server:8767](http://ryan:8767/info) |
| **MONITOR-SERVER** | **n/a** (1) | (1)  | **UP** (1) - [Ryan:monitor-server:8765](http://ryan:8765/info) |
| **ZIPKIN-SERVER**  | **n/a** (1) | (1)  | **UP** (1) - [Ryan:zipkin-server:8764](http://ryan:8764/info) |
