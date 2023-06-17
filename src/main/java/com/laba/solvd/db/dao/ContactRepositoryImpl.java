package com.laba.solvd.db.dao;

import org.apache.log4j.Logger;

public class ContactRepositoryImpl {
    Logger log = Logger.getLogger(ContactRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
}
