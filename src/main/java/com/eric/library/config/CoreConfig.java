package com.eric.library.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.eric.library.core.persistence.UserMapper;
import com.eric.library.core.persistence.LibraryHSQLRepository;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.core.persistence.ManageMapper;
import com.eric.library.core.service.UserRequestsHandler;
import com.eric.library.core.service.UserService;
import com.eric.library.core.service.LevelRequestHandler;
import com.eric.library.core.service.LevelService;
import com.eric.library.core.service.ManageRequestsHandler;
import com.eric.library.core.service.ManageService;

@Configuration
public class CoreConfig {
    
    private static Logger LOGGER = LoggerFactory.getLogger(CoreConfig.class);

    @Bean
    public UserService createCourseService(LibraryRepository repository) {
        return new UserRequestsHandler(repository);
    }

    @Bean
    public ManageService createTeacherService(LibraryRepository repository) {
        return new ManageRequestsHandler(repository);
    }

    @Bean
    public LevelService createLevelService() {
        return new LevelRequestHandler();
    }
    
    @Bean
    public LibraryRepository createLibraryRepository(UserMapper cm, ManageMapper tm) {
        return new LibraryHSQLRepository(cm, tm);
    }
  
    @Bean
    public DataSource createDataSource() {
    	LOGGER.info("building a mysql datasource");
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
    	dataSource.setUsername("root");
    	dataSource.setPassword("");
    	
    	return dataSource;
    }

    
    @Bean
    public SqlSessionFactory createSqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        
        factory.setMapperLocations(new Resource[] {
                new ClassPathResource("/mappers/UserMapper.xml"),
                new ClassPathResource("/mappers/ManageMapper.xml")
        });
        factory.setDataSource(dataSource);
        
        return factory.getObject();
    }
    
    @Bean
    public UserMapper createCourseMapper(SqlSessionFactory factory) throws Exception {
        MapperFactoryBean<UserMapper> mapperFactory = new MapperFactoryBean<UserMapper>();
        
        mapperFactory.setSqlSessionFactory(factory);
        mapperFactory.setMapperInterface(UserMapper.class);
        
        return mapperFactory.getObject();
    }
    
    @Bean
    public ManageMapper createTeacherMapper(SqlSessionFactory factory) throws Exception {
        MapperFactoryBean<ManageMapper> mapperFactory = new MapperFactoryBean<ManageMapper>();
        
        mapperFactory.setSqlSessionFactory(factory);
        mapperFactory.setMapperInterface(ManageMapper.class);
        
        return mapperFactory.getObject();
    }
}
