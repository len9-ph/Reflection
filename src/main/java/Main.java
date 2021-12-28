import Inj.Injector;
import Inj.SomeBean;
import implementaion.SomeImpl;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] paths = {
                "C:\\Users\\Леонид\\Desktop\\Reflection\\src\\main\\resources\\data.properties",
                "C:\\Users\\Леонид\\Desktop\\Reflection\\src\\main\\resources\\data1.properties"
        };

        for(int i = 0; i <paths.length; i++) {
            System.out.println("Test №" + (i + 1) + ':');
            SomeBean sb = (new Injector(paths[i]).inject(new SomeBean()));
            sb.foo();
            System.out.println("=========================");
        }

    }
}
