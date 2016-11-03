# tomasky-fqxz

这是一个基于 spring-boot  spring-data mybatis dubbo 一个工程;
1，这一套代码确实给开发者们减少了繁重的配置，特别是spring-data-jap
2，如果要使用dubbo的话， 参考fqxz-web\src\main\resources\dubbo 配置。启动时候加载dubbo.xml文件， dubbo-consumer.xml 服务消费者 dubbo-provider.xml 服务提供者 dubbo-registry.xml 服务注册中心。还有dubbo monitor 是隐藏在后面的， 主要负责rpc的监控，负载均衡（zookeeper ）

