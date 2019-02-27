package com.wen.algorithm.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectReflectUtil {

    public static void eachProperties(Object model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Field[] field = model.getClass().getDeclaredFields(); //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) { //遍历所有属性
            String name = field[j].getName(); //获取属性的名字

            System.out.println("attribute name:" + name);
            name = name.substring(0, 1).toUpperCase() + name.substring(1); //将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString(); //获取属性的类型
            if (type.equals("class java.lang.String") ) { //如果type是类类型，则前面包含"class "，后面跟类名
                //  获取get方法
                Method getMethd = model.getClass().getMethod("get"+name);
                //获取set方法
                Object value = getMethd.invoke(model, new Object[] {});
                if(null == value){
                    Method m = model.getClass().getMethod("set"+name, new Class[] {String.class});
                    m.invoke(model,new Object[] {new String("")});
                }

            }
            if (type.equals("class java.lang.Integer")) {
                //  获取get方法
                Method getMethd = model.getClass().getMethod("get"+name);
                //获取set方法
                Object value = getMethd.invoke(model, new Object[] {});
                if(null == value){
                    Method m = model.getClass().getMethod("set"+name, new Class[] {Integer.class});
                    m.invoke(model,new Object[] {new Integer(0)});
                }
            }
            if (type.equals("class java.lang.Long")) {
                //  获取get方法
                Method getMethd = model.getClass().getMethod("get"+name);
                //获取set方法
                Object value = getMethd.invoke(model, new Object[] {});
                if(null == value){
                    Method m = model.getClass().getMethod("set"+name, new Class[] {Long.class});
                    m.invoke(model,new Object[] {new Long(0l)});
                }
            }
            if (type.equals("class java.lang.Short")) {

            }
            if (type.equals("class java.lang.Double")) {

            }
            if (type.equals("class java.lang.Boolean")) {

            }
            if (type.equals("class java.util.Date")) {

            }
        }
    }

    /**
     * 根据属性名获取属性值
     * */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取属性名数组
     * */
    private  String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i].getType());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     * */
    private  List getFiledsInfo(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        List list = new ArrayList();
        Map infoMap=null;
        for(int i=0;i<fields.length;i++){
            infoMap = new HashMap();
            infoMap.put("type", fields[i].getType().toString());
            infoMap.put("name", fields[i].getName());
            infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
            list.add(infoMap);
        }
        return list;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     * */
    public  Object[] getFiledValues(Object o){
        String[] fieldNames=this.getFiledName(o);
        Object[] value=new Object[fieldNames.length];
        for(int i=0;i<fieldNames.length;i++){
            value[i]=this.getFieldValueByName(fieldNames[i], o);
        }
        return value;
    }
}
