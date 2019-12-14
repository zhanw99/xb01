package cn.zhanw.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration//标记他是配置类
@MapperScan(basePackages = "cn.zhanw.mapper")//加载映射文件
@ComponentScan(basePackages = "cn.zhanw.service")//开启服务包扫描
@EnableTransactionManagement//开启注解扫描
public class SpringMybatisConfig {

    @Bean
    public static DruidDataSource  getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        Properties properties = new Properties();
        InputStream is = SpringMybatisConfig.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.setConnectProperties(properties);
         return dataSource;
    }

    @Bean
    public static SqlSessionFactory  getSqlSessionFactoryBean(DataSource  dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory= new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        tk.mybatis.mapper.session.Configuration configuration = new tk.mybatis.mapper.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.setConfiguration(configuration);

        sqlSessionFactory.setTypeAliasesPackage("cn.zhanw");//取别名

        //设置分页插件   分页拦截器  类似过滤器
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(new Properties());//调用设置属性方法，进行方言设置
        sqlSessionFactory.setPlugins(new Interceptor[]{pageInterceptor});

        return sqlSessionFactory.getObject();
    }
    //    配置事务
    @Bean
    public static DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getSqlSessionFactoryBean(getDataSource()));
        System.out.println(getSqlSessionFactoryBean(getDataSource()));
    }
}
