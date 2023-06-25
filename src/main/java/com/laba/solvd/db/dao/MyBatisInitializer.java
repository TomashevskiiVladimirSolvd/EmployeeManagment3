package com.laba.solvd.db.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisInitializer{
        private static SqlSessionFactory sqlSessionFactory;


        public static void initialize() {
            try {
                String mybatisConfigFile = "src/main/resources/mybatis-config.xml";
                Reader reader = Resources.getResourceAsReader(mybatisConfigFile);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static SqlSession getSqlSession() {
            return sqlSessionFactory.openSession();
        }
}

