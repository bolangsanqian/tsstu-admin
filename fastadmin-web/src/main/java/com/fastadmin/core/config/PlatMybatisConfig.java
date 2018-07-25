/*
package com.fastadmin.core.config;

import com.fastadmin.common.annotation.MyDbRepository;
import com.fastadmin.common.annotation.PlatDbRepository;
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
import tk.mybatis.spring.mapping.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@AutoConfigureAfter(DataSourceConfig.class)
@Configuration
*/
/*@MapperScan(
    basePackages = {"com.fastadmin.modules.*.dao"},
    sqlSessionTemplateRef  = "platSqlSessionTemplate",
    properties = {"notEmpty=false", "IDENTITY=MYSQL"}
)*//*

public class PlatMybatisConfig {

    @Bean
    public SqlSessionFactory platSqlSessionFactory(DataSource platDataSource, PageHelper pageHelper1) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(platDataSource); // 使用titan数据源, 连接titan库
        factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/platmapping/*.xml"));
        factoryBean.setPlugins(new Interceptor[]{pageHelper1});
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate platSqlSessionTemplate(DataSource platDataSource, PageHelper pageHelper1) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(platSqlSessionFactory(platDataSource,pageHelper1)); // 使用上面配置的Factory
        return template;
    }

    @Bean
    public PageHelper pageHelper1() {
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
    public MapperScannerConfigurer mapperScannerConfigurer1() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        mapperScannerConfigurer.setBasePackage("com.fastadmin.modules.*.dao");
        Properties properties = new Properties();
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);
        mapperScannerConfigurer.setAnnotationClass(PlatDbRepository.class);
        return mapperScannerConfigurer;
    }
}
*/
