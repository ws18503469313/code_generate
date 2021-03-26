package com.generater.utils;

import com.generater.core.DBConnector;
import com.generater.core.DbType;
import com.generater.model.Table;
import com.generater.model.TableDetail;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * 将数据库信息导出到本地excel
 */
public class ExportDB2Excel {


    private static String dbName = "mkt";
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception{

        DBConnector connector = new DBConnector(DbType.MYSQL);
        DBUtils utils = new MysqlDBUtils();
        List<Table> tables = utils.getTables(connector, dbName);
        Workbook workbook = new HSSFWorkbook();
        createSimpleGuide(workbook, tables);
        for(Table table : tables){
            List<TableDetail> details = utils.getTableDetail(connector, table, dbName);
            creaSheet(workbook, table.getTableName(), details);
        }
        //将文件导出到本地
        File file = new File("/Users/polunzi/temp/dbtabels_" + dbName + ".xls");
        OutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("done");
    }

    /**
     * 创建简单索引
     * @param workbook
     * @param tables
     */
    private static void createSimpleGuide(Workbook workbook, List<Table> tables) {
        Sheet sheet = workbook.createSheet("表清单");
        Row headRow = sheet.createRow(0);

        Cell cell = headRow.createCell(0);
        cell.setCellValue("名称");
        sheet.setColumnWidth(0, 7000);

        cell = headRow.createCell(1);
        cell.setCellValue("名称");
        sheet.setColumnWidth(1, 7000);
        Row detailRow = null;
        int rowNum = 1;
        for (Table  table : tables) {
            detailRow = sheet.createRow(rowNum++);

            cell = detailRow.createCell(0);
            if(table.getTableName() != null) {
                cell.setCellValue(table.getTableName());
            }else {
                cell.setCellValue("");
            }


            cell = detailRow.createCell(1);
            if(table.getComments() != null) {
                cell.setCellValue(table.getComments());
            }else {
                cell.setCellValue("");
            }
        }
    }
    /**
     * 	详情sheet表头
     */
//    private static final String[] heads = new String [] {"代码", "名称", "数据类型", "主要的", "强制", "注释"};
    private static final String[] headers = new String [] {"列名", "列标识符", "数据类型", "宽度", "主/外键", "字段约束值"};
    /**
     * 	将数据表的详情填充到sheet
     * @param workbook
     * @param tableName
     * @param details
     */
    private static void creaSheet(Workbook workbook, String tableName, List<TableDetail> details) {
        System.out.println("创建第" + workbook.getNumberOfSheets() + "张表======" + tableName);
        Sheet sheet = workbook.createSheet(tableName);

        Row headRow = sheet.createRow(0);
        Cell cell = null;
        for (int i = 0; i < headers.length; i++) {
            cell = headRow.createCell(i);
            cell.setCellValue(headers[i]);
            sheet.setColumnWidth(i, 4000);
        }
        int rowNum = 1;
        Row detailRow = null;
        for (TableDetail detail : details) {
            detailRow = sheet.createRow(rowNum++);
            int column = 0;
            // 列名
            cell = detailRow.createCell(column++);
            if(detail.getComments() != null) {
                cell.setCellValue(detail.getComments());
            }else {
                cell.setCellValue(detail.getCloumnName());
            }
            //列标识符
            cell = detailRow.createCell(column++);
            if(detail.getCloumnName() != null) {
                cell.setCellValue(detail.getCloumnName());
            }else {
                cell.setCellValue("");
            }

            //数据类型
            cell = detailRow.createCell(column++);
            if(detail.getColunmType() != null) {
                cell.setCellValue(detail.getColunmType());
            }else {
                cell.setCellValue("");
            }
            //数据类型
            cell = detailRow.createCell(column++);
            if(detail.getSize() != null) {
                cell.setCellValue(detail.getSize());
            }else {
                cell.setCellValue("");
            }
            //主键
            cell = detailRow.createCell(column++);
            if(detail.getPri() != null) {
                cell.setCellValue(detail.getPri());
            }else {
                cell.setCellValue("");
            }
            //是否可为空
            cell = detailRow.createCell(column++);
            if(detail.getNullAble() != null) {
                cell.setCellValue(detail.getNullAble());
            }else {
                cell.setCellValue("");
            }


        }
    }
}
