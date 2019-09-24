package com.generater.utils;

import com.generater.core.BeanResultTransformer;

public class StringUtils {

    /**
     * 去掉下划线,并且将首字母大写
     * @param value
     * @return
     */
    public static StringBuilder modelNameProcess(String value){
        StringBuilder builder = new StringBuilder();
        if(value == null || value == "" ){
            return builder;
        }

        String [] seperator = value.toUpperCase().split(BeanResultTransformer.SPLIT);
        for(String str : seperator){
            builder.append(str.charAt(0));
            builder.append(str.substring(1).toLowerCase());
        }
        return builder;
    }


    public static void main(String args[]) throws Exception{
        System.out.println(modelNameProcess("aa_dwadge_wfwaddefw").toString());
    }
}
