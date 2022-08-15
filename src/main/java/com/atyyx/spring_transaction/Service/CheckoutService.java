package com.atyyx.spring_transaction.Service;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:50
 */
public interface CheckoutService {
    /**
     * 结账方法
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
