package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by AdminY on 14.12.2015.
 */
public class ReflectionSampleApp{
    String testString;

    public ReflectionSampleApp() {
        testString = new String("Simple Console Application");
    }
    /*
        Написать простое консольное приложение, использующее рефлексию.
        В параметрах командной строки приложения указывается:
        ---имя класса,
        ---имя метода, который следует вызвать у класса (метод статический)
        ---и числовые параметры для этого метода (тип double).
        На экран должен быть выведен результат выполнения этого метода.
     */

    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                Class c = Class.forName(args[0]);
                System.out.println(c.toString());

                Method m = c.getMethod(args[1], Double.TYPE);
                System.out.println(m.toString());

                Double val = Double.valueOf(args[2]);

                Object res = m.invoke(null, val);
                System.out.println(res);

            } catch (ClassNotFoundException e) {
                System.out.println("Класс не найден");
            } catch (NoSuchMethodException e) {
                System.out.println("Метод не найден");
            } catch (IllegalAccessException e) {
                System.out.println("Метод недоступен");
            } catch (InvocationTargetException e) {
                System.out.println("При вызове возникло исключение");
            }
        }

    }
}
