package com.generater.model;

import com.generater.utils.StringUtils;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Locale;
/**
 *	一张表的字段详情
 * @author polunzi
 *
 */
public class TableDetail implements DbInfo {
	/**
	 * 字段名
	 */
	private String cloumnName;
    /**
     * 属性名
     */
    private String property;
	/**
	 * 字段类型(java)
	 */
	private String colunmType;
    /**
     * 数据库类型
     */
	private String jdbcType;
	/**
	 * 是否是主键
	 */
	private String pri;
	/**
	 * 可否为空
	 */
	private String nullAble;
	/**
	 * 备注
	 */
	private String comments;

    /**
     * 长度
     */
	private String size = "";
    /**
     * 根据数据库类型获得java类型名称
     * @param colunmType
     */
	public void setColunmType(String colunmType) {
        if(colunmType.toLowerCase().contains("char") || colunmType.toLowerCase().contains("char")
                || colunmType.toLowerCase().contains("blob")
                || colunmType.toLowerCase().contains("text")) {
            this.colunmType = "String";
            this.jdbcType = JDBCType.VARCHAR.getName();
        }else if(colunmType.toLowerCase().contains("bigint") ) {
            this.colunmType = "Long";
            this.jdbcType = JDBCType.BIGINT.getName();
        }
        else if(colunmType.toLowerCase().contains("int")
                || colunmType.toLowerCase().contains("smallint")
                || colunmType.toLowerCase().contains("mediumint")) {
            this.colunmType = "Integer";
            this.jdbcType = JDBCType.INTEGER.getName();
        }else if(colunmType.toLowerCase().contains("float") ) {
            this.colunmType = "Float";
            this.jdbcType = JDBCType.FLOAT.getName();
        }
        else if(colunmType.toLowerCase().contains("biginteger") || colunmType.toLowerCase().contains("integer") ) {
            this.colunmType = "Long";
            this.jdbcType = JDBCType.BIGINT.getName();
        }else if(colunmType.toLowerCase().contains("decimal") ) {
            this.colunmType = "BigDecimal";
            this.jdbcType = JDBCType.DECIMAL.getName();
        }else if(colunmType.toLowerCase().contains("timestamp")|| colunmType.toLowerCase().contains("datetime") ) {
            this.colunmType = "Date";
            this.jdbcType = JDBCType.TIMESTAMP.getName();
        }else if(colunmType.toLowerCase().contains("bit") ) {
            this.colunmType = "Boolean";
            this.jdbcType = JDBCType.TINYINT.getName();
        }else if(colunmType.toLowerCase().contains("double")){
            this.colunmType = "Double";
            this.jdbcType = JDBCType.DOUBLE.getName();
        }else if(colunmType.toLowerCase().contains("varchar2")){
            this.colunmType = "String";
            this.jdbcType = JDBCType.VARCHAR.getName();
        }else if(colunmType.toLowerCase().contains("char")){
            this.colunmType = "String";
            this.jdbcType = JDBCType.CHAR.getName();
        }
        else{
            this.colunmType = "Object";
            this.jdbcType = JDBCType.VARCHAR.getName();
        }

        int openIdx = colunmType.indexOf("(") + 1;
        int closeIdx = colunmType.indexOf(")");
        this.size = colunmType.substring(openIdx, closeIdx);
    }

    public String getCloumnName() {
        return cloumnName;
    }

    public void setCloumnName(String cloumnName) {
	    this.cloumnName = cloumnName;
        this.property = StringUtils.modelNameProcess(cloumnName).toString();
    }

    public String getColunmType() {
        return colunmType;
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri;
    }

    public String getNullAble() {
        return nullAble;
    }

    public void setNullAble(String nullAble) {
        this.nullAble = nullAble;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public String getProperty() {
        return property;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "TableDetail{" +
                "cloumnName='" + cloumnName + '\'' +
                ", colunmType='" + colunmType + '\'' +
                ", pri='" + pri + '\'' +
                ", nullAble='" + nullAble + '\'' +
                ", comment='" + comments + '\'' +
                '}';
    }
}
