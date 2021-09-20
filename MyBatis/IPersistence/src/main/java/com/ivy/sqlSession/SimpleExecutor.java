package com.ivy.sqlSession;

import com.ivy.pojo.Configuration;
import com.ivy.pojo.MappedStatement;

import java.util.List;

public class SimpleExecutor implements Executor{
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) {
        return null;
    }
}
