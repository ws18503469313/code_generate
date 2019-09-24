package com.generater.utils;

import com.generater.core.DBConnector;
import com.generater.model.Table;
import com.generater.model.TableDetail;

import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    /**
     * 根据数据库名称,表名称,获取数据库表详情
     * @param connector
     * @param table
     * @param dbName
     * @return
     */
    public static List<TableDetail>  getTableDetail(DBConnector connector, Table table, String dbName){
        StringBuilder selectTableDetailSql  = new StringBuilder();
        selectTableDetailSql.append(" SELECT COLUMN_NAME as cloumnName,COLUMN_TYPE as  colunmType, COLUMN_COMMENT as comment, ");
        selectTableDetailSql.append(" CASE COLUMN_KEY WHEN 'PRI' THEN 'TRUE' ELSE	'FALSE' END as pri, ");
        selectTableDetailSql.append(" CASE IS_NULLABLE WHEN 'YES' THEN	'TRUE' ELSE	'FALSE' END as nullAble ");
        selectTableDetailSql.append(" FROM INFORMATION_SCHEMA. COLUMNS ");
        selectTableDetailSql.append(" WHERE");
        selectTableDetailSql.append(" TABLE_SCHEMA = ? ");
        selectTableDetailSql.append(" AND TABLE_NAME = ? ");
        //根据表名获取所有表的字段详细信息,
        List<Object> selectTableDetailSqlParas = new ArrayList<>();
        selectTableDetailSqlParas.add(dbName);
        selectTableDetailSqlParas.add(table.getTableName());
        return connector.executeSql(selectTableDetailSql.toString(), selectTableDetailSqlParas, TableDetail.class);
    }

    /**
     *  根据数据库名称,获取表中的所有字段
     * @author polunzi
     * @Date: 2019/9/24
     */
    public static List<Table> getTables(DBConnector dbConnector, String dbName) throws Exception{
        String sql = "select TABLE_NAME as tableName, TABLE_COMMENT AS comment from information_schema.tables " +
                "where table_schema= ? ORDER BY table_name";
        List<Object> paras = new ArrayList<>();
        paras.add(dbName);
        return dbConnector.executeSql(sql, paras,  Table.class);

    }
}
