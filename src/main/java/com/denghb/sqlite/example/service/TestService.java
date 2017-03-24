package com.denghb.sqlite.example.service;

import com.denghb.dbhelper.paging.PagingResult;
import com.denghb.sqlite.example.criteria.UserCriteria;
import com.denghb.sqlite.example.domain.User;

/**
 * Created by ppd on 2017/3/24.
 */
public interface TestService {

    void create(User user);

    boolean update(User user);

    boolean delete(long id);

    User query(long id);

    PagingResult<User> list(UserCriteria criteria);

}
