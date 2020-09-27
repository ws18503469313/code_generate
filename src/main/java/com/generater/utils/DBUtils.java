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
//        selectTableDetailSql.append(" SELECT COLUMN_NAME as cloumnName,COLUMN_TYPE as  colunmType, COLUMN_COMMENT as comment, ");
//        selectTableDetailSql.append(" CASE COLUMN_KEY WHEN 'PRI' THEN 'TRUE' ELSE	'FALSE' END as pri, ");
//        selectTableDetailSql.append(" CASE IS_NULLABLE WHEN 'YES' THEN	'TRUE' ELSE	'FALSE' END as nullAble ");
//        selectTableDetailSql.append(" FROM INFORMATION_SCHEMA. COLUMNS ");
//        selectTableDetailSql.append(" WHERE");
//        selectTableDetailSql.append(" TABLE_SCHEMA = ? ");
//        selectTableDetailSql.append(" AND TABLE_NAME = ? ");
        /**
         * SELECT t.column_name as columnName, t.DATA_TYPE as dateType, t.NULLABLE as nullAble, t.DATA_LENGTH as dataLength,
         *        a.COMMENTS as comments
         *   FROM USER_TAB_COLUMNS t
         *   LEFT JOIN USER_COL_COMMENTS a
         *     ON t.table_name = a.table_NAME
         *    AND t.COLUMN_NAME = a.COLUMN_NAME
         *    where t.table_name = 'RE_PAT' order by column_id
         */
        selectTableDetailSql.append(" SELECT t.column_name as cloumnName,t.DATA_TYPE as  colunmType, a.COMMENTS as comments, ");
        selectTableDetailSql.append(" CASE t.NULLABLE WHEN 'Y' THEN 'TRUE' ELSE 'FALSE' END AS nullAble, ");
        selectTableDetailSql.append(" CASE t.COLUMN_ID WHEN 1 THEN 'TRUE' ELSE 'FALSE' END AS pri ");
        selectTableDetailSql.append(" FROM USER_TAB_COLUMNS t ");
        selectTableDetailSql.append("  LEFT JOIN USER_COL_COMMENTS a ON t.table_name = a.table_NAME  AND t.COLUMN_NAME = a.COLUMN_NAME ");
        selectTableDetailSql.append(" where t.table_name = ?  ");
        selectTableDetailSql.append(" order by column_id ");
        //根据表名获取所有表的字段详细信息,
        List<Object> selectTableDetailSqlParas = new ArrayList<>();
//        selectTableDetailSqlParas.add(dbName);
        selectTableDetailSqlParas.add(table.getTableName());
        return connector.executeSql(selectTableDetailSql.toString(), selectTableDetailSqlParas, TableDetail.class);
    }

    /**
     *  根据数据库名称,获取库中所有的表
     * @author polunzi
     * @Date: 2019/9/24
     */
    public static List<Table> getTables(DBConnector dbConnector, String dbName) throws Exception{
        String sql = "select t.table_name tableName, f.comments comments\n" +
                "from user_tables t\n" +
                "inner join user_tab_comments f on t.table_name = f.table_name";
//        String sql = "select TABLE_NAME as tableName, TABLE_COMMENT AS comment from information_schema.tables " +
//                "where table_schema= ? ORDER BY table_name";
        List<Object> paras = new ArrayList<>();
//        paras.add(dbName);
        return dbConnector.executeSql(sql, paras,  Table.class);

    }



    public static void main(String args[]) throws Exception{
//        getTableDetail(null, null, "");

        getTables(null, "");
    }
}
