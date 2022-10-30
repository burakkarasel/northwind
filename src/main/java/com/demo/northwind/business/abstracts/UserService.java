package com.demo.northwind.business.abstracts;

import com.demo.northwind.core.entities.User;
import com.demo.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    Result findByEmail(String email);
}
