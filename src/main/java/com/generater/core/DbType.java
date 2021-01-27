package com.generater.core;

/**
 * @author polunzi
 */
public enum DbType {
    /**
     * ORACLE
     */
    ORACLE("db-oracle.xml"),
    /**
     * MYSQL
     */
    MYSQL("db-mysql.xml");

    String configName;

    DbType(String configName) {
        this.configName = configName;
    }

    public String getConfigName() {
        return configName;
    }
}
