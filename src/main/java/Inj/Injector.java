package Inj;

import annotations.AutoInjectable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    private File prop;

    public Injector(String path) {
        this.prop = new File(path);
    }

    public <T> T inject(T obj) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader(prop));

        Class objClass = obj.getClass();
        Object newInstance = objClass.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for(Field field : fields) {
            Annotation annotation = field.getAnnotation(AutoInjectable.class);
            field.setAccessible(true);
            if(annotation != null) {
                String type = prop.getProperty()
            }
        }
        return (T) newInstance;
    }
}
