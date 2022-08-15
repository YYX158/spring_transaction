package com.atyyx.spring_transaction.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yyx
 * @version 1.0
 * @date : 2022/8/15 21:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String  name;
    private String  password;
    private Integer age;
    private String gender;
    private String email;
}
