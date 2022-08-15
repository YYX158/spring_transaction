package com.atyyx.spring_transaction.Dao;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:47
 */
public interface BookDao {
    /**
     * 根据图书的编号来查询图书的价格
     * @param bookId
     * @return
     */
    public Integer getPriceByBookId(Integer bookId);

    /**
     * 更新图书的库存
     * @param bookId
     */
    void updateStock(Integer bookId);

    /**
     * 更新用户的余额
     * @param userId
     * @param bookPrice
     */
    void updateBalance(Integer userId, Integer bookPrice);
}
