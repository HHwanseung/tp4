package org.zerock.tp4.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.zerock.tp4.board.config.BoardRootConfig;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration //이거 거니깐 Bean표시가 생김
@Import(BoardRootConfig.class)
public class RootConfig { //스캔을 할 일을 없

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/springdb");
        config.setUsername("springuser");
        config.setPassword("springuser");

        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }

    @Bean(name = "names") //메서드를 만들고 Bean을 걸어주면 빈으로 생성해줌
    public ArrayList<String> names(){
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("AAA");
        list.add("AAA");
        return list;
    }
}
