package com.betLoL.bet.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    @Autowired
    private final SqlSession sqlSession;

    public TestDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public String Test() {
        return sqlSession.selectOne("Test.Test");
    }
}
