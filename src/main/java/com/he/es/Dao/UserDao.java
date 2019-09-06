package com.he.es.Dao;

import com.he.es.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserDao extends ElasticsearchRepository<User,Integer>{
}
