package com.generater.utils;

import com.generater.core.DBConnector;
import com.generater.core.FileType;
import com.generater.model.GenerateModel;
import com.generater.model.Table;
import com.generater.model.TableDetail;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FreemarkerUtil {

    private static final Logger log = LoggerFactory.getLogger(FreemarkerUtil.class);

    /**
     * 参数完善
     * @param model
     * @throws Exception
     */
    public static void paramsProcess(GenerateModel model)  throws Exception {
        DBConnector dbConnector = new DBConnector();
        List<Table> tables = DBUtils.getTables(dbConnector, model.getDbName());
        log.info("获取数据库: {}所有表: {}", model.getDbName(), tables.toString());
        String target = model.getTargetPath();
        model.setBasePackagePath(getBasePackagePath(target));
        for(Table table : tables){
            List<TableDetail> colums = DBUtils.getTableDetail(dbConnector, table, model.getDbName());
            log.info("获取数据库: {}表: {} 所有字段信息: {}", model.getDbName(), table.toString(), colums.toString());
            table.setTableName(StringUtils.modelNameProcess(table.getTableName()).toString());
            model.setTable(table);
            model.setDetails(colums);
            for(FileType type : FileType.values()){
                switch (type) {
                    case MODEL://ok
                        model.setTargetPath(target+ FileType.MODEL.getRemarke() + "/");
                        model.setPackagePath(getBasePackagePath(model.getTargetPath()));
                        model.setFileName(model.getTable().getTableName() + FileType.MODEL.getSufix());
                        model.setTemplateName(FileType.MODEL.getRemarke() + ".ftl");
                        generate(model);
                        log.info("开始生成表:[{}]的 model文件, 参数:{}", table.getTableName(), model.toString());
                        break;
                    case CLIENT://ok
                        model.setTargetPath(target+ FileType.CLIENT.getRemarke() + "/");
                        model.setPackagePath(getBasePackagePath(model.getTargetPath()));
                        model.setFileName(model.getTable().getTableName() + FileType.CLIENT.getSufix());
                        model.setTemplateName(FileType.CLIENT.getRemarke() + ".ftl");
                        generate(model);
                        break;
                    case MAPPER:
                        model.setTargetPath(target+ FileType.MAPPER.getRemarke() + "/");
                        model.setPackagePath(getBasePackagePath(model.getTargetPath()));
                        model.setFileName(model.getTable().getTableName() + FileType.MAPPER.getSufix());
                        model.setTemplateName(FileType.MAPPER.getRemarke() + ".ftl");
                        generate(model);
                        break;
                    case XML:
                        String mainPath = target.substring(0, target.indexOf("java"));
                        String mapperPath = mainPath + "resources/";
                        model.setTargetPath(mapperPath+ FileType.XML.getRemarke() + "/");
//                        model.setPackagePath(getBasePackagePath(model.getTargetPath()));
                        model.setFileName(model.getTable().getTableName() + FileType.XML.getSufix());
                        model.setTemplateName(FileType.XML.getRemarke() + ".ftl");
                        generate(model);
                        break;
                    case EXAMPLE:
                        if(model.getNotCreateExample()){
                            break;
                        }
                        model.setTargetPath(target+ FileType.EXAMPLE.getRemarke() + "/");
                        model.setPackagePath(getBasePackagePath(model.getTargetPath()));
                        model.setFileName(model.getTable().getTableName() + FileType.EXAMPLE.getSufix());
                        model.setTemplateName(FileType.EXAMPLE.getRemarke() + ".ftl");
                        generate(model);
                        log.info("开始生成表:[{}]的 example 文件, 参数:{}", table.getTableName(), model.toString());
                        break;
                }
                model.setTargetPath(target);
            }
        }

    }

    /**
     * 获取启动类所在的文件夹
     * @param str
     * @return
     */
    private static String getBasePackagePath(String str){
        StringBuilder builder = new StringBuilder();
        String [] dirs = str.split("/");
        boolean isJavaPackage = Boolean.FALSE;
        for(String dir: dirs){
            if(isJavaPackage){
                builder.append(dir);
                builder.append(".");
            }else if(dir.toLowerCase().equals("java")){
                isJavaPackage = Boolean.TRUE;
            }else{
                continue;
            }
        }
        return builder.substring(0, builder.length()-1);
    }
    /**
     * 模板存放路径
     */
    private static final String TEMPLATE_DIRECTORY = "src/main/resources/templates";

    /**
     * 根据模板填充数据,生成文件
     * @param model
     * @throws Exception
     */
    private static void generate(GenerateModel model)  throws Exception {
        File dir = new File(model.getTargetPath());
        if(!dir.exists()) dir.mkdirs();
        String filename = model.getTargetPath() + "/" + model.getFileName();
        Writer writer = null;
        try{
            writer = new FileWriter(filename);
            Template template = getConfiguration(TEMPLATE_DIRECTORY).getTemplate(model.getTemplateName(), "UTF-8");
            template.process(model, writer);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            writer.close();
        }
    }

    /**
     * 配置freemarker,加载模板
     * @param templateDirectory
     * @return
     */
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
