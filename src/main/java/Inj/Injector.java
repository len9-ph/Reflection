package Inj;

import annotations.AutoInjectable;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class which is implementing dependency injection based on given
 * @author
 */
public class Injector {
    private Properties properties;

    public Injector(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(path)));
    }

    /**
     * Method that makes injection
     * @param obj - object
     * @param <T> - object class
     * @return - new instance of initial object with injected dependencies, cast to its class
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public <T> T inject(T obj) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<? extends Object> ob = obj.getClass();
        Field[] fields = ob.getDeclaredFields();
        for(Field field : fields) {
            Annotation annotation = field.getAnnotation(AutoInjectable.class);
            field.setAccessible(true);
            if(annotation != null) {
                String typeName = properties.getProperty(field.getType().getName());
                Object classObject = Class.forName(typeName).newInstance();
                field.set(obj, classObject);
            }
        }
        return obj;
    }
}
