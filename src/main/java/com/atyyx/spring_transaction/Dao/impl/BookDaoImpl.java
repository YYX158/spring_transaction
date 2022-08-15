package com.atyyx.spring_transaction.Dao.impl;

import com.atyyx.spring_transaction.Dao.BookDao;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:48
 */
@Registered
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookId)
    {
        String sql="select price from t_book where book_id=?";
        Integer bookPrice = jdbcTemplate.queryForObject(sql, Integer.class, 1);
        return bookPrice;
    }

    @Override
    public void updateStock(Integer bookId)
    {
        String sql="update t_book set stock =stock -1 where book_id=?";
        jdbcTemplate.update(sql,bookId);
    }

    @Override
    public void updateBalance(Integer userId, Integer bookPrice) {

        String sql="update t_user set balance =balance -? where user_id=?";
        jdbcTemplate.update(sql,bookPrice,userId);
    }
}
