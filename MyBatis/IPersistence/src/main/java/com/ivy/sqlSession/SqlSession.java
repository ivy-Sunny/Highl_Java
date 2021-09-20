package com.ivy.sqlSession;

import java.util.List;

public interface SqlSession {
    /**
     * 查询所有
     *
     * @param <E>
     * @return
     */
    public <E> List<E> selectList(String statementid, Object... params);

    /**
     * 根据条件查询所有
     */
    public <T> T selectOne(String statementid, Object... params);
}
