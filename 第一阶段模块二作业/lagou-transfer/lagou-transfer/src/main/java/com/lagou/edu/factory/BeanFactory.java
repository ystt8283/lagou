package com.lagou.edu.factory;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import sun.security.krb5.internal.PAData;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用反射生成对象
 */
public class BeanFactory {

    private static Map<String, Object> map = new HashMap<>();

    static {
        InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        SAXReader reader = new SAXReader();

        try {
            Element rootElement = reader.read(inputStream).getRootElement();
            List<Element> beanList = rootElement.selectNodes("//bean");
            for (Element element : beanList) {
                String id = element.attributeValue("id");
                String aClass = element.attributeValue("class");
                Class<?> aClass1 = Class.forName(aClass);
                Object o = aClass1.newInstance();
                map.put(id,o);
            }

            //检查property
            List<Element> propertyList = rootElement.selectNodes("//property");
            for (Element element : propertyList) {
                String name = element.attributeValue("name");
                String ref = element.attributeValue("ref");

                Element parent = element.getParent();
                Object ParentObject = map.get(parent.attributeValue("id"));
                Method[] methods = ParentObject.getClass().getMethods();
                for (Method method : methods) {
                    if(method.getName().equalsIgnoreCase("set" + name)) {
                        method.invoke(ParentObject, map.get(ref));
                    }
                }

                map.put(parent.attributeValue("id"), ParentObject);
            }



        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String id) {
        return map.get(id);
    }
}
