package com.anneng.net.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@ConfigurationProperties(prefix = "mysql")
public class DatasourceConfig extends HikariConfig {

    @Primary
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }
}
