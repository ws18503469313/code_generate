package com.generater;

import com.generater.core.FileType;
import com.generater.model.GenerateModel;
import com.generater.utils.FreemarkerUtil;


public class Test {


    public static void main(String args[]) throws Exception{
        GenerateModel model = new GenerateModel();
        model.setDbName("jshm");
        model.setFileType(FileType.MODEL);
        model.setPackagePath("D:/");
        FreemarkerUtil.paramsProcess(model);
    }
}
