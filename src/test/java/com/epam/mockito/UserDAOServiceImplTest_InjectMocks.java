package com.epam.mockito;

import com.epam.dao.UserDAO;
import com.epam.entity.User;
import com.epam.service.UserDAOServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserDAOServiceImplTest_InjectMocks {

    @InjectMocks
    UserDAOServiceImpl daoService;

    @Mock
    UserDAO dao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserByName() {
        User userExpected = new User().setAge(29).setName("Aset");
        when(dao.getUserByName(anyString())).thenReturn(userExpected);

        User userResult = daoService.getUserByName("SomeName");

        User anotherUser = new User().setAge(29).setName("Aset");

        assertEquals(anotherUser, userResult);// Test passes if same properties of two instances or there is only one instance in two references. Override equals.
        assertSame(userExpected, userResult); // Test passes if there is only one instance in two references
    }
}