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

import com.eric.library.core.persistence.CourseMapper;
import com.eric.library.core.persistence.LibraryHSQLRepository;
import com.eric.library.core.persistence.LibraryRepository;
import com.eric.library.core.persistence.TeacherMapper;
import com.eric.library.core.service.CourseRequestsHandler;
import com.eric.library.core.service.CourseService;
import com.eric.library.core.service.LevelRequestHandler;
import com.eric.library.core.service.LevelService;
import com.eric.library.core.service.TeacherRequestsHandler;
import com.eric.library.core.service.TeacherService;

@Configuration
public class CoreConfig {
    
    private static Logger LOGGER = LoggerFactory.getLogger(CoreConfig.class);

    @Bean
    public CourseService createCourseService(LibraryRepository repository) {
        return new CourseRequestsHandler(repository);
    }

    @Bean
    public TeacherService createTeacherService(LibraryRepository repository) {
        return new TeacherRequestsHandler(repository);
    }

    @Bean
    public LevelService createLevelService() {
        return new LevelRequestHandler();
    }
    
    @Bean
    public LibraryRepository createLibraryRepository(CourseMapper cm, TeacherMapper tm) {
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
                new ClassPathResource("/mappers/CourseMapper.xml"),
                new ClassPathResource("/mappers/TeacherMapper.xml")
        });
        factory.setDataSource(dataSource);
        
        return factory.getObject();
    }
    
    @Bean
    public CourseMapper createCourseMapper(SqlSessionFactory factory) throws Exception {
        MapperFactoryBean<CourseMapper> mapperFactory = new MapperFactoryBean<CourseMapper>();
        
        mapperFactory.setSqlSessionFactory(factory);
        mapperFactory.setMapperInterface(CourseMapper.class);
        
        return mapperFactory.getObject();
    }
    
    @Bean
    public TeacherMapper createTeacherMapper(SqlSessionFactory factory) throws Exception {
        MapperFactoryBean<TeacherMapper> mapperFactory = new MapperFactoryBean<TeacherMapper>();
        
        mapperFactory.setSqlSessionFactory(factory);
        mapperFactory.setMapperInterface(TeacherMapper.class);
        
        return mapperFactory.getObject();
    }
}