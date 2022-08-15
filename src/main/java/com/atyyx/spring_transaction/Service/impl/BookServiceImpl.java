package com.atyyx.spring_transaction.Service.impl;

import com.atyyx.spring_transaction.Dao.BookDao;
import com.atyyx.spring_transaction.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *  事务的四大特性：
 *  ACID
 *  原子性
 *  一致性
 *  隔离性
 *  持久性----隔离级别
 *
 *  --mysql中默认的隔离级别是可重复读
 *
 *
 *  隔离级别一共有四种：
 *  ①读未提交  read uncommitted    脏读：读出来的数据没有任何意义，A读了B的数据，但是B没有提交而是回滚了
 *  ②读已提交:read committed    ：不可重读
 *  ③可重复读  repeatable read
 *  ④ 串行化  serializable
 *

 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:50
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    /**
     * noRollbackFor表示的意思，如果发生了ArithmeticException.class类的异常，那么不进行回滚
     * isolation = Isolation.DEFAULT表明采用默认的隔离的隔离级别
     * @param userId
     * @param bookId
     */
    @Transactional(readOnly = false,timeout = -1,noRollbackFor = ArithmeticException.class,isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRES_NEW)// 使用一个新的事物（用自己的事务----使用的是被调用者的事务
    @Override
    public void buyBook(Integer userId, Integer bookId)
    {
//        try
//        {
//            // 设置休眠时间为5s
//            TimeUnit.SECONDS.sleep(5);
//        }catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
        // 查询图书的价格
        Integer bookPrice = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId,bookPrice);
        //System.out.println(1/0);
    }
}
