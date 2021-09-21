package com.ivy.sqlSession;

import com.ivy.pojo.BoundSql;
import com.ivy.pojo.Configuration;
import com.ivy.pojo.MappedStatement;
import com.ivy.utils.GenericTokenParser;
import com.ivy.utils.ParameterMapping;
import com.ivy.utils.ParameterMappingTokenHandler;
import com.ivy.utils.TokenHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) {
        /**
         * 1、注册驱动，获取连接
         * 2、获取sql语句
         *      对占位符进行转换，转换过程中还需要对#{}里面的值进行解析存储
         * 3、获取预处理对象
         * 4、设置参数
         * 5、执行sql
         * 6、封装返回结果急
         */
        Connection connection = configuration.getDataSource().getConnection();
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());

        return null;
    }

    /**
     * 完成对#{}的解析工作：
     * 1、将#{}使用 ？进行代替
     * 2、解析出#{}里面的值进行存储
     *
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        /**
         * 标记处理类：配置标记解析器来完成对占位符的解析处理工作
         */
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        /**
         * 解析出来的sql
         */
        String parseSql = genericTokenParser.parse(sql);
        /**
         * #{} 解析出来的参数名称
         */
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();

        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}