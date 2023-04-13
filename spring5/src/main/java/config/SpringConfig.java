package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 注解启动的配置类
 * 本质上代替spring.xml
 */
@Configuration//表示当前是配置类
@ComponentScan("com.jxcia")//包扫描
@PropertySource("classpath:jdbc.properties")//加载配置文件
public class SpringConfig {
    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private  String password;

    /**
     *  @Bean(name = "dataSource")等同于配置文件中<bean></bean>
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataScource(){
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

    }
    @Bean(name = "queryRunner")
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource){
        QueryRunner queryRunner=new QueryRunner(dataSource);
        return queryRunner;
    }

}
