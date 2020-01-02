package com.yostar.curd.controller;

import com.yostar.curd.pojo.User;
import com.yostar.curd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        if (user != null) {
            return  ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> findUsers() {
        List<User> users = userService.findUsers();
        if (CollectionUtils.isEmpty(users)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping("users")
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        if (result > 0) {
            return ResponseEntity.ok(user.getId());
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();

    }

    @PutMapping("users")
    public ResponseEntity<Void> updateUserById(@RequestBody User user) {
        int result = userService.updateUserById(user);
        System.out.println(result);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Integer id) {
        int i = userService.deleteUserById(id);
        System.out.println(i);
        return ResponseEntity.ok().build();
    }
}
