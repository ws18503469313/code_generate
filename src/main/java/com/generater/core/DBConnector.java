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

    static {
        Configuration configuration = new Configuration().configure("db.xml");
        buildSessionFactory = configuration.buildSessionFactory();
    }
    public Session getSession() {
        return buildSessionFactory.openSession();
    }

    public  List<T> executeSql(String sql, List<Object> paras, Class cls) {
        // 1 加载配置文件
        // 直接调用configure() 系统会默认读取 hibernate.cfg.xml 这个文件
//        Configuration configuration = new Configuration().configure("db.xml");
        // 2.获取SessionFactory对象 相当于获取连接池对象
        // SessionFactory 是线程安全的
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 从工厂中获取一个session对象
        //openSession 获取的是一个全新的session
        Session session = getSession();
        NativeQuery query = session.createNativeQuery(sql);
        if(paras != null && paras.size() != 0){
            int i = 1;
            for(Object obj : paras){
                query.setParameter(i++, obj);
            }
        }
        query.setResultTransformer(new BeanResultTransformer(cls));
        List<T> result =  query.list();
        //5 关闭资源
        session.close();
        return result;
    }


}
