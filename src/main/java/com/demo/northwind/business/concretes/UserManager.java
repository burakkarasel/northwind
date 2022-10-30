package com.demo.northwind.business.concretes;

import com.demo.northwind.business.abstracts.UserService;
import com.demo.northwind.core.dataAccess.UserDao;
import com.demo.northwind.core.entities.User;
import com.demo.northwind.core.utilities.results.Result;
import com.demo.northwind.core.utilities.results.SuccessDataResult;
import com.demo.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    public UserManager(){}

    @Autowired
    public UserManager(UserDao _userDao){
        super();
        this.setUserDao(_userDao);
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Added user");
    }

    @Override
    public Result findByEmail(String email) {
        return new SuccessDataResult<>(this.userDao.findByEmail(email), "Got user");
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
