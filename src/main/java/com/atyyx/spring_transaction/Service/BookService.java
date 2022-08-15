package com.atyyx.spring_transaction.Service;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:49
 */
public interface BookService {
    /**
     * 定义一个买书的操作
     * @param userId
     * @param bookId
     */
    public void buyBook(Integer userId,Integer bookId);
}
