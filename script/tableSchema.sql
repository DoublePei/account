use account;
CREATE TABLE `test` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(64)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/var/local/apache-maven-3.5.4/bin/mvn clean package -Dmaven.test.skip=true

ps aux | grep account | grep -v grep | awk '{print $2}' | xargs kill
#启动远程调试功能 端口号5005
    sleep 2
nohup java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5009 ./target/account-1.0-SNAPSHOT.jar &