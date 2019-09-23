package com.generater.utils;

import com.generater.core.BeanResultTransformer;

public class StringUtils {

    public static StringBuilder modelNameProcess(String value){
        String [] seperator = value.toUpperCase().split(BeanResultTransformer.SPLIT);
        StringBuilder builder = new StringBuilder();
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
