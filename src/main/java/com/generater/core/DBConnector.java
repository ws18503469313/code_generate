package com.generater.core;

import com.generater.model.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.ResultTransformer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBConnector<T>     {


    private static SessionFactory buildSessionFactory;
    // 1 加载配置文件
    static {
        Configuration configuration = new Configuration().configure("db.xml");
        buildSessionFactory = configuration.buildSessionFactory();
    }
    // 2.获取SessionFactory对象 相当于获取连接池对象
    // SessionFactory 是线程安全的
    // 从工厂中获取一个session对象
    //openSession 获取的是一个全新的session
    public Session getSession() {
        return buildSessionFactory.openSession();
    }

    /**
     * 执行sql
     * @param sql
     * @param paras sql 中的参数
     * @param cls   返回的数据类型
     * @return
     */
    public  List<T> executeSql(String sql, List<Object> paras, Class cls) {
        Session session = getSession();
        NativeQuery query = session.createNativeQuery(sql);
        //这里需要注意hibernate的参数下标从 1 开始
        if(paras != null && paras.size() != 0){
            int i = 1;
            for(Object obj : paras){
                query.setParameter(i++, obj);
            }
        }
        //解析返回的数据集,转换为传来的class类型
        query.setResultTransformer(new BeanResultTransformer(cls));
        List<T> result =  query.list();
        //5 关闭资源
        session.close();
        return result;
    }


}
