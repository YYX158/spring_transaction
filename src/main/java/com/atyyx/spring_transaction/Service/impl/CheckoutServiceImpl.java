package com.atyyx.spring_transaction.Service.impl;

import com.atyyx.spring_transaction.Service.BookService;
import com.atyyx.spring_transaction.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:52
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds)
        {
            bookService.buyBook(userId,bookId);
        }
    }
}
