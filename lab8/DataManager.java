package eight;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class DataManager {

    private List<String> data = new ArrayList<>();

    private final List<Object> processors = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {

        try {
            data = Files.readAllLines(Paths.get(source));
            System.out.println("The data is uploaded.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public void processData() {

        ExecutorService executor =
                Executors.newFixedThreadPool(processors.size());
        List<Future<List<String>>> futures =
                new ArrayList<>();

        for (Object processor : processors) {

            for (Method method :
                    processor.getClass().getDeclaredMethods()) {

                if (method.isAnnotationPresent(DataProcessor.class)) {

                    Future<List<String>> future =
                            executor.submit(() -> {

                                try {

                                    System.out.println(
                                            "In progress: "
                                                    + method.getName()
                                    );

                                    return (List<String>)
                                            method.invoke(
                                                    processor,
                                                    new ArrayList<>(data)
                                            );

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                return Collections.emptyList();
                            });

                    futures.add(future);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (Future<List<String>> future : futures) {

            try {
                result.addAll(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        data = result;

        executor.shutdown();
    }

    public void saveData(String destination) {

        try {
            Files.write(Paths.get(destination), data);

            System.out.println(
                    "The result is saved in "
                            + destination
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
