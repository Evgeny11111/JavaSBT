package ru.sbt;

import net.openhft.compiler.CompilerUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GeneratorFactory<T> implements Factory<T> {
    @Override
    public JsonGenerator<T> createGenerator(T object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String className = "ru.sbt.MyJsonGenerator";
        StringBuilder code = new StringBuilder(
                "package ru.sbt;\n" +
                "import java.util.List;\n\n" +
                "public class MyJsonGenerator implements JsonGenerator<" + clazz.getName() + "> {\n" +
                "public String toJson(List<" + clazz.getName() + "> entities){\n" +
                "String jsonString = \"\";\n" +
                "for (" + clazz.getName() + " entity : entities) {\n" +
                "jsonString += \"{\\n\";\n");

        for (Field field : fields) {
            field.setAccessible(true);
            String getter = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            code.append("jsonString += \"").append(field.getName()).append(" : \"entity.").append(getter).append("+ \\n\",\n");
        }
        code.append("""
                jsonString += "}\\n";
                }
                return jsonString;
                }
                }
                """);

        JsonGenerator<T> generator = null;
        try {
            Class<?> classGeneratorJson = CompilerUtils.CACHED_COMPILER.loadFromJava(className, code.toString());
            generator = (JsonGenerator<T>) classGeneratorJson.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return generator;
    }
}
