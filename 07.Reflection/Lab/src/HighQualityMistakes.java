import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class HighQualityMistakes {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get") && !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " must be public!"));

        Arrays.stream(clazz.getDeclaredMethods())
                .filter(s -> s.getName().startsWith("set") && !Modifier.isPrivate(s.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " must be private!"));
    }
}
