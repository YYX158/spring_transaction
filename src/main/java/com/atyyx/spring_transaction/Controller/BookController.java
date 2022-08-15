package com.atyyx.spring_transaction.Controller;

import com.atyyx.spring_transaction.Service.BookService;
import com.atyyx.spring_transaction.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:45
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer userId,Integer bookId)
    {
        bookService.buyBook(userId,bookId);
    }

    public void checkOut(Integer userId,Integer [] bookIds)
    {
        checkoutService.checkout(userId,bookIds);
    }
}
