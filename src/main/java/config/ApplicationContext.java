package config;

import com.jolbox.bonecp.BoneCPDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Java based application context configuration class.
 *
 * @author Rugal Bernstein
 * @since 0.2
 */
@Configuration
@EnableTransactionManagement
@PropertySource(
    {
        "classpath:jdbc.properties"
    })
@MapperScan("rugal.sample.core.mapper")
@ComponentScan(value = "rugal")
public class ApplicationContext
{

    @Autowired
    private Environment env;

//<editor-fold defaultstate="collapsed" desc="Hikari connection pool configure">
//    @Bean
//    public HikariConfig hikariConfig()
//    {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
//        hikariConfig.setUsername(env.getProperty("jdbc.username"));
//        hikariConfig.setPassword(env.getProperty("jdbc.password"));
//        hikariConfig.setMaximumPoolSize(3);
//        hikariConfig.setJdbc4ConnectionTest(false);
//        hikariConfig.setConnectionTestQuery("SELECT 1;");
//        Properties dataSourceProperties = new Properties();
//        dataSourceProperties.put("serverName", "localhost");
//        dataSourceProperties.put("databaseName", "postgres");
//        hikariConfig.setDataSourceProperties(dataSourceProperties);
//        return hikariConfig;
//    }
//
//    @Bean(destroyMethod = "shutdown")
//    public DataSource dataSource()
//    {
//        HikariDataSource dataSource = new HikariDataSource(hikariConfig());
//        return dataSource;
//    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="BoneCP configuration">
    @Bean(destroyMethod = "close")
    public DataSource dataSource()
    {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setIdleConnectionTestPeriodInMinutes(60);
        dataSource.setIdleMaxAgeInMinutes(240);
        dataSource.setMaxConnectionsPerPartition(10);
        dataSource.setMinConnectionsPerPartition(1);
        dataSource.setPartitionCount(1);
        dataSource.setAcquireIncrement(5);
        dataSource.setStatementsCacheSize(100);
        return dataSource;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="mybatis sql session factory">
    @Bean
    @Autowired
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.put("lazyLoadingEnabled", true);
        sqlSessionFactory.setConfigurationProperties(properties);
        return sqlSessionFactory.getObject();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="dataSource transaction manager">
    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DataSource dataSource)
    {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource);
        return txManager;
    }
//</editor-fold>
}
