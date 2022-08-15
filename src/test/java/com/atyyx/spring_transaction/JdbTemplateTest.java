package com.atyyx.spring_transaction;

import com.atyyx.spring_transaction.pojo.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 22:04
 */
//指定当前测试类在Spring的测试环境中执行，此时就可以直接通过注入的方式直接获取ioc容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置Spring的测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml") // classpath指的是类路径
public class JdbTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert()
    {
        String sql="insert into user values(null,?,?,?,?,?)";
        // 用update实现增删改
        jdbcTemplate.update(sql,"root","123",23,"女","123@qq.com");
    }

    @DisplayName("查询一条数据")
    @Test
    public void testGetUserById()
    {
        String sql="select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    @DisplayName("查询所有的用户对象")
    public void testGetAllUser()
    {
        String sql="select * from user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        query.stream().forEach(s-> System.out.println(s));
    }

    @Test
    @DisplayName("查询单行单列")
    public void testGetCount()
    {
        String sql="select count(*) from user";
        Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.printf("当前里面一共有：%d条数据", cnt);
    }
}
