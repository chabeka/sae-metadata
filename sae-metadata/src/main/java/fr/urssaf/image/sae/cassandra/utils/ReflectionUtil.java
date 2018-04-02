package fr.urssaf.image.sae.cassandra.utils;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static  Object getMethod(Object object, Field field) {

        try {
            return field.get(object);
        } catch (Exception exception) {
            //
        }
        return null;
    }
}
