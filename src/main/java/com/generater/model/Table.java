package com.generater.model;

import com.generater.utils.StringUtils;

/**
 *	表的详情
 * @author polunzi
 *
 */
public class Table {

	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 备注
	 */
	private String comment;

	public Table() {
	}

	public Table(String tableName, String comment) {
		this.tableName = tableName;
		this.comment = comment;
	}

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "{" +
				"tableName='" + tableName + '\'' +
				", comment='" + comment + '\'' +
				'}';
	}
}
