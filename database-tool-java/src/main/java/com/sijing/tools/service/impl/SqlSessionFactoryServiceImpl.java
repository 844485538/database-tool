package com.sijing.tools.service.impl;

import com.sijing.tools.service.SqlSessionFactoryService;
import com.sijing.tools.util.DataSourceUtil;
import com.sijing.tools.util.UUIDUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 李健新
 * @Date 2022/6/9
 * @Description
 */
@Service
public class SqlSessionFactoryServiceImpl implements SqlSessionFactoryService {

    public static final Map<String, SqlSessionFactory> SQL_SESSION_POOL = new ConcurrentHashMap<>();


    /**
     * 获取数据库连接
     *
     * @param host
     * @param port
     * @param username
     * @param password
     * @return
     */
    @Override
    public String getSqlSessionFactory(String host, Integer port, String username, String password){

        String sqlSessionId = UUIDUtil.getUuid();

        try {
            SqlSessionFactory sqlSessionFactory = DataSourceUtil.getSqlSessionFactory(host, port, username, password);
            SQL_SESSION_POOL.put(sqlSessionId, sqlSessionFactory);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败");
        }

        return sqlSessionId;
    }
}
