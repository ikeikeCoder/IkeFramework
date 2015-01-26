package org.fervorseed.ikeframework.config.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@EnableTransactionManagement
@Configuration
public class DataSourceConfig {

	/**
     * {@link javax.sql.DataSource}를 빈으로 등록한다.
     *
     * BoneCP는 오픈소스 JDBC Pool 라이브러리이다.
     * 같은 일을 하는 라이브러리로 Tomcat JDBC Pool(Apache DBCP), c3p0 등이 있다.
     */
    @Bean(destroyMethod = "close")
    public BoneCPDataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
//        dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClass"));
//        dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
//        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        return dataSource;
    }

    /**
     * 스프링이 트랜잭션을 관리할때 사용하는 트랜잭션매니저를 등록한다.
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
