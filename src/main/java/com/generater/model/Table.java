package com.generater.model;

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
	private String comments;

	/**
	 * 实体类名称
	 */
	private String voName;

	/**
	 * 模块名称
	 */
	private String moduleName;

	public String getVoName() {
		return voName;
	}

	public Table() {
	}

	public Table(String tableName, String comment) {
		this.tableName = tableName;
		this.comments = comment;
	}

	public String getTableName() {
		return tableName;
	}

	public void setVoName(String voName) {
		this.moduleName = voName.toLowerCase();
		this.voName = voName + "VO";
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "{" +
				"tableName='" + tableName + '\'' +
				", comment='" + comments + '\'' +
				'}';
	}
}
