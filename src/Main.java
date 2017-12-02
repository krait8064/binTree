import javax.security.auth.callback.Callback;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Collection<Parent> parents = new ArrayList<>();
        parents.add(new Parent());
        parents.add(new Child());
        Object[] obj = new Object[3];
        obj[0] = new Object[]{};
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            executorService.invokeAll(new ArrayList<Call<Integer>>());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Call<T> implements Callable<T> {
        @Override
        public T call() throws Exception {
            return null;
        }
    }

    static class Parent {
    }

    static class Child extends Parent {
    }
}
