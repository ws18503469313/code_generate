package com.generater.core;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.generater.model.Table;
import org.hibernate.HibernateException;
import org.hibernate.transform.ResultTransformer;

public class BeanResultTransformer implements ResultTransformer {
    Class<?> cls;

    public BeanResultTransformer(Class cls) {
        this.cls = cls;
        this.methods = new ArrayList<>();
    }
    private List<Method> methods;
    private  boolean first = Boolean.TRUE;
    @Override
    public List transformList(List list) {
        return list;
    }

    @Override
    public Object transformTuple(Object[] values, String[] columns) {
        Object result = null;
        try {

            result = this.cls.newInstance();
            if(first){
                this.resoveMethodsOrder(columns);
                this.first = Boolean.FALSE;
            }

            this.setValue(result, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    private static final String SET_METHOD = "set";
    private static final String IS_METHOD = "is";
    public static final String SPLIT = "_";

    /**
     * 获取数据库解析集的解析顺序
     *
     * @param coloums
     */
    private  void resoveMethodsOrder( String[] coloums){

        List<Method> clsMethos = new ArrayList<Method>();
        clsMethos.addAll(Arrays.asList(cls.getDeclaredMethods()));

        for(String coloum : coloums){
            Iterator<Method> it = clsMethos.iterator();//不能直接拿arrays.asList来迭代,否则it.rempove的时候会报错
            parent: while(it.hasNext()){
                Method method = it.next();
                String methodName = method.getName().toLowerCase();
                if(!methodName.contains(SET_METHOD) && !methodName.contains(IS_METHOD)){//既不是set 方法 也不是is方法
                    continue ;
                }
                String [] seperators = coloum.toLowerCase().split(SPLIT);//将数据库字段根据 '_' 分割
                for(String seperator : seperators){
                    if(!methodName.contains(seperator)){//如果该 字段名称 的某一段 不包含在方法里面,则检测下一个方法
                        continue parent;           //eg: 一个字段为 filed_name, set 方法为setFieldName(), 则需要检测 filed 和 name 两个String 同时存在 方法名称中
                    }
                }
                this.methods.add(method);
                break parent;
            }
        }
    }

    /**
     * 根据解析好的sql查询字段集的顺序来设置对象属性
     * @param obj
     * @param values
     * @throws Exception
     */
    private  void setValue(Object obj, Object [] values) throws Exception {
        int i = 0;
        for (Object value : values){
            try{
                this.methods.get(i++).invoke(obj, value);
            }catch(Exception ex){
                System.out.println(this.methods.get(i).getName());
                System.out.println(value);
                System.out.println(obj.toString());
            }finally{

            }
        }

    }
}
