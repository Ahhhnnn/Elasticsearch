package com.he.es.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author heningm
 * @date 2019/9/622:15
 */
@Data
@Document(indexName = "users",type = "user")
public class User {
    private int id;
    private String username;
    private String password;
    private int age;
}
