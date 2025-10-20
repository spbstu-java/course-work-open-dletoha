package labs.lab2.invoker;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import labs.lab2.annotaton.Repeat;
import labs.lab2.core.MyClass;

public class AnnotationInvoker {
    public static void main(String[] args) {
        MyClass target = new MyClass();
        Class<?> cls = target.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            int mods = method.getModifiers();
            if ((Modifier.isProtected(mods) || Modifier.isPrivate(mods))
                    && method.isAnnotationPresent(Repeat.class)) {

                Repeat rep = method.getAnnotation(Repeat.class);
                int times = rep.value();
                method.setAccessible(true);

                // Подготовка массива аргументов
                Class<?>[] types = method.getParameterTypes();
                Object[] params = new Object[types.length];
                for (int i = 0; i < types.length; i++) {
                    params[i] = defaultValue(types[i]);
                }

                // Многократный вызов
                try {
                    for (int i = 0; i < times; i++) {
                        Object result = method.invoke(target, params);
                        if (method.getReturnType() != Void.TYPE) {
                            System.out.println("Return: " + result);
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    private static Object defaultValue(Class<?> type) {
        if (!type.isPrimitive()) {
            return null;
        }
        if (type == boolean.class)
            return false;
        if (type == byte.class)
            return (byte) 0;
        if (type == short.class)
            return (short) 0;
        if (type == int.class)
            return 0;
        if (type == long.class)
            return 0L;
        if (type == float.class)
            return 0f;
        if (type == double.class)
            return 0d;
        if (type == char.class)
            return '\u0000';
        return null;
    }
}
