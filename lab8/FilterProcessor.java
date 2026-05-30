package eight;

import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {

    @DataProcessor
    public List<String> filter(List<String> data) {

        return data.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
    }
}
