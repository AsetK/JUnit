package com.epam.service;

import com.epam.dao.UserDAO;
import com.epam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOServiceImpl implements UserDAOService {

    @Autowired
    UserDAO dao;

    public User getUserByName(String name) {
        return dao.getUserByName(name);
    }
}
