package com.generater.model;

import com.generater.utils.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *	一张表的字段详情
 * @author polunzi
 *
 */
public class TableDetail {
	/**
	 * 字段名
	 */
	private String cloumnName;
	/**
	 * 字段类型
	 */
	private String colunmType;
	/**
	 * 是否是主键
	 */
	private String isPri;
	/**
	 * 可否为空
	 */
	private String nullAble;
	/**
	 * 备注
	 */
	private String comment;
	
	public String getCloumnName() {
		return cloumnName;
	}
	public void setCloumnName(String cloumnName) {


	    this.cloumnName = StringUtils.modelNameProcess(cloumnName).toString();
	}
	public String getColunmType() {
		return colunmType;
	}
	public void setColunmType(String colunmType) {
        if(cloumnName.toLowerCase().contains("char") || cloumnName.toLowerCase().contains("char")
                || cloumnName.toLowerCase().contains("blob")
                || cloumnName.toLowerCase().contains("text"))
            this.colunmType = "String";
        else if(cloumnName.toLowerCase().contains("biginteger") )
            this.colunmType = "Long";
        else if(cloumnName.toLowerCase().contains("int")
                || cloumnName.toLowerCase().contains("smallint")
                || cloumnName.toLowerCase().contains("mediumint"))
            this.colunmType = "Integer";
        else if(cloumnName.toLowerCase().contains("float") )
            this.colunmType = "Float";
        else if(cloumnName.toLowerCase().contains("biginteger") || cloumnName.toLowerCase().contains("integer") )
            this.colunmType = "Long";
        else if(cloumnName.toLowerCase().contains("decimal") )
            this.colunmType = "BigDecimal";
        else if(cloumnName.toLowerCase().contains("timestamp")|| cloumnName.toLowerCase().contains("datetime") )
            this.colunmType = "Date";
        else if(cloumnName.toLowerCase().contains("bit") )
            this.colunmType = "Boolean";
        else this.colunmType = "Object";
    }
	public String getIsPri() {
		return isPri;
	}
	public void setIsPri(String isPri) {
		this.isPri = isPri;
	}
	public String getNullAble() {
		return nullAble;
	}
	public void setNullAble(String nullAble) {
		this.nullAble = nullAble;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
