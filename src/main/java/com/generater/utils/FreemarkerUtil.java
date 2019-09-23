package com.generater.utils;

import com.generater.core.DBConnector;
import com.generater.core.FileType;
import com.generater.model.GenerateModel;
import com.generater.model.Table;
import com.generater.model.TableDetail;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FreemarkerUtil {

    public static void main(String[] args) throws IOException {
        // 参数值
        Table table = new Table();
        table.setComment("comment_1");
        table.setTableName("ss_user");
        // 模板目录
        String templateDirectory = "src/main/resources/template";
        // 模板名称
        String templateFile = "model1.ftl";
        // 模板生成后存放目录
        String targetPath = "D:/";
        // 模板生成后新文件名
        String fileName = "ntest.java";
        // 创建文件夹
        File dir = new File(targetPath);
        if(!dir.exists()) dir.mkdirs();
        File nFile = new File(targetPath +"/"+ fileName);
        if (nFile.exists()) {
            throw new RuntimeException("File \'"+fileName+"\' already exists");
        }
        // 生成目标文件
        Writer writer = null;
        try {
            writer = new FileWriter(nFile);
            Template template = getConfiguration(templateDirectory).getTemplate(templateFile, "UTF-8");
            template.process(table, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }
    public static void paramsProcess(GenerateModel model)  throws Exception {
        String targetPath = null;
        DBConnector dbConnector = new DBConnector();
        List<Table> tables = DBUtils.getTables(dbConnector, model.getDbName());
        for(Table table : tables){
            List<TableDetail> colums = DBUtils.getTableDetail(dbConnector, table, model.getDbName());
            model.setTable(table);
            model.setDetails(colums);
            for(FileType type : FileType.values()){
                targetPath = model.getPackagePath() + "/" + model.getFileType().getRemarke();
                model.setPackagePath(targetPath);
                switch (type) {
                    case MODEL:
                        StringBuilder build = StringUtils.modelNameProcess(table.getTableName());
                        build.append(FileType.MODEL.getSufix());
                        model.setFileName(build.toString());
                        model.setTemplateName("model.ftl");
                        generate(model);
                        break;
                    case CLIENT:
                        break;
                    case MAPPER:
                        break;
                }
            }
        }

    }
    private static void generate(GenerateModel model)  throws Exception {
        File dir = new File(model.getPackagePath());
        if(!dir.exists()) dir.mkdirs();
        String filename = model.getPackagePath() + "/" + model.getFileName();
        Writer writer = null;
        try{
//            File file = new File(filename);
//            if(file.exists()){
//                System.out.println("[" + filename + "]已存在");
//            }
            writer = new FileWriter(filename);
            // 模板目录
            String templateDirectory = "src/main/resources/templates";
            Template template = getConfiguration(templateDirectory).getTemplate(model.getTemplateName(), "UTF-8");
            template.process(model, writer);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            writer.close();
        }
    }

    private static Configuration getConfiguration(String templateDirectory) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        try {
            configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configuration;
    }

}
