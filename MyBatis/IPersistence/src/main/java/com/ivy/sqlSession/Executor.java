package com.ivy.sqlSession;

import com.ivy.pojo.Configuration;
import com.ivy.pojo.MappedStatement;

import java.sql.SQLException;
import java.util.List;

public interface Executor {
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws SQLException;
}
