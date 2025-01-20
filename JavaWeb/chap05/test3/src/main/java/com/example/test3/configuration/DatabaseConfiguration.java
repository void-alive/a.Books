package com.example.test3.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

// @Configuration : 해당 클래스 파일이 설정 파일임을 스프링 프레임워크에 알려주는 어노테이션
@Configuration
// @PropertySource : 설정 파일의 위치를 지정하는 어노테이션
//   지정한 설정파일을 불러와서 현재 클래스에서 사용
//   classpath : 프로젝트의 root 폴더를 의미
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

  //  @Autowired : 스프링 프레임워크가 해당 객체를 생성 및 관리하도록 설정하는 어노테이션
//    Application 클래스 타입의 변수 applicationContext 선언
//    변수만 생성하고 객체는 생성 x
//  @Autowired 사용 시 스프링 프레임워크에서 자체적으로 필요한 순간에 자동 객체 생성 및 관리
  @Autowired
  private ApplicationContext applicationContext;

  //  @Bean : 자바 빈즈를 의미하는 어노테이션
//  사용자가 직접 생성한 클래스의 자바 빈즈가 아닌 라이브러리로 제공되는 클래스의 자바 빈즈 의미
//  스프링 프레임워크가 자체적으로 관리
  @Bean
//  @ConfigurationProperties : @PropertySource 어노테이션을 통해 가져온 설정 파일의 특정 내용을 가져옴
//    application.properties 파일의 내용 중 spring.datasource.hikari 로 시작하는 설정 정보를 모두 가져와
//    hikariConfig 클래스 타입의 객체로 생성
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() {
//    DataSource : db 사용 시 커넥션 풀에 db 설정 정보를 저장하고 db와 연결을 미리 생성한 후 관리하는 클래스
//    HikariCP 에서 제공하는 HikariDataSource 클래스 타입의 객체를 사용해 DataSource 생성
//    객체 생성 시 HikariConfig 클래스 타입의 객체로 db 설정 정보를 사용함
    DataSource dataSource = new HikariDataSource(hikariConfig());
    System.out.println(dataSource.toString());
    return dataSource;
  }

  //  실제 db 연결 및 사용 정보
  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource());

//    setMapperLocations() : mybatis 사용 시 mybatis 의 SQL 쿼리 파일의 위치 설정
//      setMapperLocation() : 하나만 가져옴
//      setMapperLocations() : 전부 다 가져옴
//    getResources() : mybatis 의 sql 쿼리 파일을 가져오는 메소드
//      getResource() : 지정한 1개의 파일을 가져옴
//      getResources() : 지정한 패턴의 파일을 모두 가져옴
//    ** : 모든 하위 폴더를 의미
//    /sql/**/sql-*.xml : 최상위 폴더인 / 아래에 sql 폴더가 존재하고
//      sql 폴더 아래에 여러 단계의 하위 폴더가 존재하며
//      시작 파일명이 'sql-' 로 시작하며, 확장자는 '.xml' 로 끝나는 파일
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(
            "classpath:/sql/**/sql-*.xml"));
//    mybatis 설정을 추가해 사용
    sqlSessionFactoryBean.setConfiguration(mybatisConfig());
    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  //  @PropertySource 어노테이션을 통해 지정한 설정 파일인 application.properties 안에서
//    mybatis.configuration 설정 부분을 가져와 사용
//  org.apache.ibatis.session.Configuration 는 다른 곳에서 Configuration 클래스를 선언하여 사용하고 있어서
//    mybatis 에서 제공하는 Configuration 을 사용하면 클래스 이름이 같기 때문에 오류 발생 가능성 있음
//    따라서 패키지 명까지 전체로 입력함
  @Bean
  @ConfigurationProperties(prefix = "mybatis.configuration")
  public org.apache.ibatis.session.Configuration mybatisConfig() {
    return new org.apache.ibatis.session.Configuration();
  }
}
