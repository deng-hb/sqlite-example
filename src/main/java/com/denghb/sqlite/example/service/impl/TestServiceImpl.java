package com.denghb.sqlite.example.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.sqlite.example.criteria.UserCriteria;
import com.denghb.sqlite.example.domain.User;
import com.denghb.sqlite.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ppd on 2017/3/24.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private DbHelper db;

    @Override
    public void create(User user) {
        db.insert(user);
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public User query(long id) {
        return db.queryById(User.class, id);
    }

    @Override
    public PagingResult<User> list(UserCriteria criteria) {

        StringBuffer sql = new StringBuffer("select * from user ");

        return db.list(sql, User.class, criteria);
    }
}
