package com.generater.utils;

import com.generater.core.DBConnector;
import com.generater.model.Table;
import com.generater.model.TableDetail;

import java.util.List;

/**
 *
 */
public interface DBUtils {

    List<Table> getTables(DBConnector dbConnector, String dbName) throws Exception;

    List<TableDetail> getTableDetail(DBConnector connector, Table table, String dbName);
}
