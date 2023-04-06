package com.betLoL.bet.Service;

import com.betLoL.bet.Dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public String Test() {
        return testDao.Test();
    }
}
