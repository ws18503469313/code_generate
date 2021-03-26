package com.generater.other;

import com.generater.core.DBConnector;
import com.generater.core.DbType;
import com.generater.model.Table;
import com.generater.utils.DBUtils;
import com.generater.utils.FreemarkerUtil;

import java.util.List;
import java.util.Locale;

public class GenSystemFiled {

    private static final String[] ALTER_TABLE_ADD_DEFAULT_FILEDS_WITH_DROP = {
            "ALTER TABLE %s DROP COLUMN `version_no`; ALTER TABLE %s ADD COLUMN `version_no` bigint(11) DEFAULT 0;",
            "ALTER TABLE %s DROP COLUMN `created_user_id`; ALTER TABLE %s ADD COLUMN `created_user_id` bigint(11) DEFAULT 0;",
            "ALTER TABLE %s DROP COLUMN `created_stamp`; ALTER TABLE %s ADD COLUMN `created_stamp` datetime DEFAULT now();",
            "ALTER TABLE %s DROP COLUMN `last_updated_user_id`; ALTER TABLE %s ADD COLUMN `last_updated_user_id` bigint(11) DEFAULT 0;",
            "ALTER TABLE %s DROP COLUMN `last_updated_stamp`; ALTER TABLE %s ADD COLUMN `last_updated_stamp` datetime DEFAULT now();"
    };
    private static final String[] ALTER_TABLE_ADD_DEFAULT_FILEDS = {
            "ALTER TABLE %s ADD COLUMN `version_no` bigint(11) DEFAULT 0;",
            "ALTER TABLE %s ADD COLUMN `created_user_id` bigint(11) DEFAULT 0;",
            "ALTER TABLE %s ADD COLUMN `created_stamp` datetime DEFAULT now();",
            "ALTER TABLE %s ADD COLUMN `last_updated_user_id` bigint(11) DEFAULT 0;",
            "ALTER TABLE %s ADD COLUMN `last_updated_stamp` datetime DEFAULT now();"
    };


    private static final String ID_TRANSFER [] = {
            "TRUNCATE %s;",
            "ALTER TABLE %s DROP COLUMN `id`;",
            "ALTER TABLE %s ADD COLUMN `id` bigint(11) NOT NULL PRIMARY KEY;"
    };
    public static void main(String[] args) throws Exception {
        DBConnector dbConnector = new DBConnector(DbType.MYSQL);
        DBUtils dbUtils = FreemarkerUtil.getDBUtil(DbType.MYSQL);
        List<Table> tables = dbUtils.getTables(dbConnector, "mkt");
        for (Table table : tables) {
            System.out.println("-- ----------------");
            if(!table.getTableName().toLowerCase(Locale.ROOT).contains("cart")){
                continue;
            }
            String tableName = table.getTableName();
            for (String format : ALTER_TABLE_ADD_DEFAULT_FILEDS) {
                System.out.println(String.format(format, tableName, tableName));
            }
//            for(String format : ID_TRANSFER){
//                System.out.println(String.format(format, tableName));
//            }

            System.out.println();
        }
    }
}
