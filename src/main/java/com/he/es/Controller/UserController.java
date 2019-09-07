package com.he.es.Controller;

import com.he.es.Dao.UserDao;
import com.he.es.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author heningm
 * @date 2019/9/622:34
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserDao userDao;


    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/addUser")
    public String addUser(String username, String password, Integer age,Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        // 返回id做验证
        return String.valueOf(userDao.save(user).getId());
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(Integer id) {
        userDao.deleteById(id);
        return "Success!";
    }

    @PutMapping("/updateUser")
    public String updateUser(Integer id, String username, String password, Integer age) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setAge(age);
        //返回id做验证
        return String.valueOf(userDao.save(user).getId());
    }

    @GetMapping("/getUser")
    public User getUser(Integer id) {
        return userDao.findById(id).get();
    }

    @GetMapping("/getAllUsers")
    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }
}
