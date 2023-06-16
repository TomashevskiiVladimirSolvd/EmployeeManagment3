package com.laba.solvd.db.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;

public class ContactDAO {
    Logger log = Logger.getLogger(ContactDAO.class.getName());
    private static final ConnectionPool CONNECTIONPOOL= ConnectionPool.getInstance();
}
