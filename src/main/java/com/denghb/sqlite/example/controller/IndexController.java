package com.denghb.sqlite.example.controller;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.sqlite.example.criteria.UserCriteria;
import com.denghb.sqlite.example.domain.User;
import com.denghb.sqlite.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by ppd on 2017/3/24.
 */
@RestController
public class IndexController {

    @Autowired
    private TestService testService;

    @RequestMapping("/")
    public String index() {

        return "Hello World";

    }

    @RequestMapping("/create")
    public String create() {
        User user = new User();
        user.setAge(12);
        user.setBirthday(new Date());
        user.setName("李四");
        user.setGrade(69.05);
        testService.create(user);
        return "Hello World";
    }

    @RequestMapping("/query/{id}")
    public User query(@PathVariable(name = "id", required = false) Long id) {
        return testService.query(id);
    }

    @RequestMapping("/list")
    public PagingResult<User> list() {
        return testService.list(new UserCriteria());
    }
}
