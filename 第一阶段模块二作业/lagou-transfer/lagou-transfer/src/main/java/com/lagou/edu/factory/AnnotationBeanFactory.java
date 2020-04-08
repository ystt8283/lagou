package com.lagou.edu.factory;

import com.lagou.edu.annotation.Autoware;
import com.lagou.edu.annotation.Service;
import com.lagou.edu.utils.FetchClassesUtils;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationBeanFactory {
    private Map<String, Object> map = new HashMap<>();

    public Object getBean(String name) {
        return map.get(name);
    }

    public void init(String pagckageName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Set<String> className = FetchClassesUtils.getClassName(pagckageName, true);
        for (String s : className) {
            Class<?> aClass = Class.forName(s);
            Service annotation = aClass.getAnnotation(Service.class);
            if(annotation != null) {
                System.out.println(annotation.value());
                map.put(annotation.value(), aClass.newInstance());
            }
        }

        //变量map中的已存储的bean，检查这些类中带有@autoware注解的field
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Autoware annotation = field.getAnnotation(Autoware.class);
                if(annotation != null) {
                    System.out.println("-----shuxing-----");
                    System.out.println(field.getName());
                    field.set(entry.getValue(), map.get(annotation.value()));
                }
            }
        }


    }
}
