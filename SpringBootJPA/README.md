# spring-boot-jpa
spring-boot-jpa 测试

#五大核心接口
Repository
JpaRepository
CurdRepository
PagingAndSortingRepository
JpaSpecificationExecutor

#jpa多对多、一对多之间的关系
1. 菜单和用户是多对多的关系
2. 一个角色对应多个用户

INSERT INTO t_users (id, name, age, address, roles_id) VALUES (1, 'zhangsan', 18, '12313', 1);
INSERT INTO t_users (id, name, age, address, roles_id) VALUES (2, 'zhangsan', 20, '222', 1);
INSERT INTO t_users (id, name, age, address, roles_id) VALUES (3, 'zhangsan', 20, '333', 1);
INSERT INTO t_users (id, name, age, address, roles_id) VALUES (4, 'zhangsan', 20, '444', 2);
INSERT INTO t_users (id, name, age, address, roles_id) VALUES (5, 'zhangsan', 20, '555', 2);
INSERT INTO t_users (id, name, age, address, roles_id) VALUES (6, 'zhangsan', 20, '666', 3);



INSERT INTO t_roles (roleid, rolename) VALUES (1, '张三丰');
INSERT INTO t_roles (roleid, rolename) VALUES (2, '风清扬');
INSERT INTO t_roles (roleid, rolename) VALUES (3, '令狐冲');

#Spring Boot 件 的配置文件 -  多环境配置
application-dev.properties 开发环境
application-test.properteis 测试环境
application-prod.properteis 生产环境

###运行项目：
java -jar xxx.jar --spring.profiles.active={profile}


###完成的命令：
java -jar springboot-helloworld-0.0.1-SNAPSHOT.jar --spring.profiles.active=
test|dev|prod



