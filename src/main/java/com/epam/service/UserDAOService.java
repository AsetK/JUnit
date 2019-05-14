package com.epam.service;

import com.epam.entity.User;

public interface UserDAOService {

    User getUserByName(String name);
}
