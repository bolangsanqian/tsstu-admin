package com.fastadmin.core.config;

import com.fastadmin.common.annotation.MyDbRepository;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@AutoConfigureAfter(DataSourceConfig.class)
@Configuration
/*@MapperScan(
    basePackages = {"com.fastadmin.modules.*.dao"},
    sqlSessionTemplateRef  = "sqlSessionTemplate",
    properties = {"notEmpty=false", "IDENTITY=MYSQL"}
)*/
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, PageHelper pageHelper) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource); // 使用数据源, 连接库
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapping/*/*.xml"));
        factoryBean.setPlugins(new Interceptor[]{pageHelper});
        return factoryBean.getObject();
    }

    @Bean
    public PageHelper pageHelper(DataSource dataSource) {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(DataSource dataSource, PageHelper pageHelper) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory(dataSource,pageHelper)); // 使用上面配置的Factory
        return template;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer1() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        mapperScannerConfigurer.setBasePackage("com.fastadmin.modules.*.repository,com.fastadmin.core.base");
        Properties properties = new Properties();
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        mapperScannerConfigurer.setAnnotationClass(MyDbRepository.class);
        return mapperScannerConfigurer;
    }
}
