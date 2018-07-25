package com.fastadmin.common.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static Map<String, Object> convertBean2Map(Object bean) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        if(null == bean){
            return map;
        }
        Class<?> clazz = bean.getClass();
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
        } catch (IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor descriptor : descriptors){
            String propertyName = descriptor.getName();
            if(!"class".equals(propertyName)){
                Method method = descriptor.getReadMethod();
                DateTimeFormat dt = null;
                try {
                    Field field = clazz.getDeclaredField(propertyName);
                    dt = field.getAnnotation(DateTimeFormat.class);
                } catch (NoSuchFieldException e) {
                }
                Object result;
                try {
                    result = method.invoke(bean);

                    if(null != result){
                        if(result instanceof Date){
                            if(dt!=null){
                                SimpleDateFormat sd = new SimpleDateFormat(dt.pattern());
                                String  format =   sd.format((Date)result);
                                map.put(propertyName, format);
                            }else {
                                map.put(propertyName, result);
                            }
                        }else{
                            map.put(propertyName, result);
                        }
                    }
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return map;
    }
}
