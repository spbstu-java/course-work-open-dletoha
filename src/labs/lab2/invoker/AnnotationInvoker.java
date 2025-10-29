
package labs.lab2.invoker;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;
import labs.lab2.annotaton.Repeat;
import labs.lab2.core.MyClass;

public class AnnotationInvoker {

    public static void runWithInput(String input, Consumer<String> outputConsumer) {
        MyClass target = new MyClass();
        Class<?> cls = target.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            int mods = method.getModifiers();
            if ((Modifier.isProtected(mods) || Modifier.isPrivate(mods)) &&
                    method.isAnnotationPresent(Repeat.class)) {

                Repeat rep = method.getAnnotation(Repeat.class);
                int times = rep.value();
                method.setAccessible(true);

                Class<?>[] types = method.getParameterTypes();
                Object[] params = parseInput(input, types, outputConsumer);

                try {
                    for (int i = 0; i < times; i++) {
                        Object result = method.invoke(target, params);
                        if (method.getReturnType() != Void.TYPE) {
                            outputConsumer.accept("Return: " + result);
                        }
                    }
                } catch (Exception e) {
                    outputConsumer.accept("Ошибка при вызове метода: " + method.getName());
                    outputConsumer.accept("Причина: " + e.getMessage());
                }
            }
        }
    }

    private static Object[] parseInput(String input, Class<?>[] types, Consumer<String> outputConsumer) {
        Object[] result = new Object[types.length];

        if (input == null || input.trim().isEmpty()) {
            for (int i = 0; i < types.length; i++) {
                result[i] = defaultValue(types[i], outputConsumer);
            }
            return result;
        }

        String[] parts = input.split(",");
        for (int i = 0; i < types.length; i++) {
            if (i < parts.length) {
                result[i] = safeConvert(parts[i].trim(), types[i], outputConsumer);
            } else {
                result[i] = defaultValue(types[i], outputConsumer);
            }
        }
        return result;
    }

    private static Object safeConvert(String value, Class<?> type, Consumer<String> printer) {
        try {
            return convert(value, type);
        } catch (Exception e) {
            return defaultValue(type, printer);
        }
    }

    private static Object convert(String value, Class<?> type) {
        if (type == int.class || type == Integer.class)
            return Integer.parseInt(value);
        if (type == double.class || type == Double.class)
            return Double.parseDouble(value);
        if (type == boolean.class || type == Boolean.class)
            return Boolean.parseBoolean(value);
        if (type == long.class || type == Long.class)
            return Long.parseLong(value);
        if (type == float.class || type == Float.class)
            return Float.parseFloat(value);
        if (type == short.class || type == Short.class)
            return Short.parseShort(value);
        if (type == byte.class || type == Byte.class)
            return Byte.parseByte(value);
        if (type == char.class || type == Character.class)
            return value.charAt(0);
        if (type == String.class)
            return value;
        throw new IllegalArgumentException("Неподдерживаемый тип: " + type);
    }

    private static Object defaultValue(Class<?> type, Consumer<String> printer) {
        if (Consumer.class.isAssignableFrom(type)) {
            return printer;
        }
        if (!type.isPrimitive())
            return null;
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
