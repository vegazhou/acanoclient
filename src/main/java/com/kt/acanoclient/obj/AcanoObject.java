package com.kt.acanoclient.obj;

import com.kt.acanoclient.anno.ID;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.http.message.BasicNameValuePair;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vega Zhou on 2017/5/19.
 */
public abstract class AcanoObject {

    public List<BasicNameValuePair> buildRequestParams() {
        List<BasicNameValuePair> params = new ArrayList<>();
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors =
                propertyUtilsBean.getPropertyDescriptors(this);
        Class clazz = this.getClass();
        for (PropertyDescriptor descriptor : descriptors) {
            try {
                String name = descriptor.getName();
                Field field = this.getClass().getDeclaredField(name);
                ID idAnnotation = field.getAnnotation(ID.class);
                if (idAnnotation != null) {
                    continue;
                }
                if (getReadMethod(clazz, descriptor) != null) {

                    String v = new BeanUtilsBean().getProperty(this, name);
                    params.add(new BasicNameValuePair(name, v));
                }
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | NoSuchFieldException e) {

            }
        }
        return params;
    }


    Method getReadMethod(Class clazz, PropertyDescriptor descriptor) {
        return (MethodUtils.getAccessibleMethod(clazz, descriptor.getReadMethod()));
    }
}
