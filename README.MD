**EXAMPLE**

    /**
     * 
     * 改项目会自动生成model client mapper, 模板位于resource/templates/文件夹下
     * 需要提供的参数:
     *  数据库名,
     *  生成文件的包位置:
     *      比如说项目结构:D:/project/damiwang/user-provide/src/main/java/com/cloud/provide/
     *      生成的 moedl 文件则位于:D:/project/damiwang/user-provide/src/main/java/com/cloud/provide/model/
     *      生成的 client 文件则位于:D:/project/damiwang/user-provide/src/main/java/com/cloud/provide/client/
     *      生成的 mapper 文件则位于:D:/project/damiwang/user-provide/src/main/java/com/cloud/provide/mapper/
     *      生成的 mapper.XML 文件则位于:D:/project/damiwang/user-provide/src/main/resources/mapper/
     * @param args
     * @throws Exception
     */
     
     
    public static void main(String args[]) throws Exception{
        log.info("程序开始");
        GenerateModel model = new GenerateModel();
        model.setDbName("jshm");
        model.setTargetPath("D:/project/damiwang/user-provide/src/main/java/com/cloud/provide/");
        FreemarkerUtil.paramsProcess(model);
        log.info("程序结束");
    }