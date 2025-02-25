import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GettersAndSettersTask {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        List<Method> getters = Arrays.stream(clazz.getDeclaredMethods()).filter(m -> m.getName().startsWith("get")).collect(Collectors.toList());
        List<Method> setters = Arrays.stream(clazz.getDeclaredMethods()).filter(m -> m.getName().startsWith("set")).collect(Collectors.toList());

        getters.stream().sorted(Comparator.comparing(Method::getName)).forEach(g -> System.out.println(g.getName() + " will return class " + g.getReturnType()));
        setters.stream().sorted(Comparator.comparing(Method::getName)).forEach(s -> System.out.println(s.getName() + "and will set field of class " + s.getParameterTypes()[0].getName()));

    }
}
