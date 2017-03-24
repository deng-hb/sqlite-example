package com.denghb.sqlite.example;

import com.denghb.dbhelper.DbHelper;
import com.denghb.dbhelper.impl.DbHelperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * Hello world!
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");


        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:example.db");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 绝对路径
        dataSourceBuilder.url("jdbc:sqlite:" + file.getPath());
        return dataSourceBuilder.build();
    }


    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DbHelper dbHelper() {
        DbHelperImpl dbHelper = new DbHelperImpl();
        dbHelper.setJdbcTemplate(jdbcTemplate());
        return dbHelper;
    }
}
