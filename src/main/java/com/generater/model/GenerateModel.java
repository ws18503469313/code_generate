package com.generater.model;

import com.generater.core.DbType;
import com.generater.core.FileType;

import java.util.List;

public class GenerateModel {

    /**
     * @date: 2021/1/27
     * @desc: 数据库类型
     */
    private DbType dbType;

    /**
     * 生成的文件类型
     */
    private List<FileType> genFileType;

    /**
     * 数据库名
     */
    private String dbName;

    /**
     * 文件包的基本路径
     */
    private String basePackagePath;
    /**
     * 根据模板生成的文件的 package : com.cloud.user.model
     * 可以根据targetPath来获得
     */
    private String packagePath;
    /**
     * 生成的文件路径: D://project/jshm/src/main/java/com/cloud/user/model/
     */
    private String targetPath;
    /**
     * 生成的文件名
     */
    private String fileName;
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 数据库表信息
     */
    private Table table;
    /**
     * 数据库表字段信息
     */
    private List<TableDetail> details;
    /**
     * 生成的文件类型
     */
    private FileType fileType;
    /**
     * 默认不生成example文件
     */
    private Boolean notCreateExample = Boolean.FALSE;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }



    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getTemplateName() {
        return templateName;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public Table getTable() {
        return table;
    }
    public void setTable(Table table) {
        this.table = table;
    }
    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<TableDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TableDetail> details) {
        this.details = details;
    }

    public String  getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        if(!targetPath.endsWith("/")){
            this.targetPath = targetPath + "/";
        }else{
            this.targetPath = targetPath;
        }
    }

    public String getBasePackagePath() {
        return basePackagePath;
    }

    public void setBasePackagePath(String basePackagePath) {
        this.basePackagePath = basePackagePath;
    }

    public Boolean getNotCreateExample() {
        return notCreateExample;
    }

    public void setNotCreateExample(Boolean notCreateExample) {
        this.notCreateExample = notCreateExample;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public List<FileType> getGenFileType() {
        return genFileType;
    }

    public void setGenFileType(List<FileType> genFileType) {
        this.genFileType = genFileType;
    }

    @Override
    public String toString() {
        return "GenerateModel{" +
                "basePackagePath='" + basePackagePath + '\'' +
                ", packagePath='" + packagePath + '\'' +
                ", targetPath='" + targetPath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", templateName='" + templateName + '\'' +
                '}';
    }
}
