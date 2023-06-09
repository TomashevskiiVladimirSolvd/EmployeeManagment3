package com.laba.solvd.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static ConnectionPool instance;
    private final List<Connection> connections;

    private ConnectionPool(){
        try{Class.forName(Config.DRIVER.getValue());
    }catch(ClassNotFoundException e){
            throw new RuntimeException("Unable to find Driver class",e);
        }

        int connectionPoolSize = Integer.parseInt(Config.POOL_SIZE.getValue());
        this.connections = new ArrayList<>(connectionPoolSize);
        IntStream.range(0,connectionPoolSize)
                .boxed()
                .forEach(index ->connections.add(createConnections()));
}
private Connection createConnections(){
        Connection connection;
        try{
            connection= DriverManager.getConnection(Config.URL.getValue(),Config.USERNAME.getValue(), Config.PASSWORD.getValue());
        }catch (SQLException e){
            throw new RuntimeException("Unable to create connection",e);
        }
        return connection;
    }

    public Connection getConnection() {
        synchronized (connections) {
            while (connections.isEmpty()) {
                try {
                    connections.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Unable to get connection", e);
                }
            }

            Connection connection = connections.remove(connections.size() - 1);
            try {
                if (connection.isClosed()) {
                    connection = createConnections();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error checking connection status", e);
            }

            return connection;
        }
    }

}