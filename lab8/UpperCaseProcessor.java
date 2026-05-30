package eight;

import java.util.List;
import java.util.stream.Collectors;

public class UpperCaseProcessor {

    @DataProcessor
    public List<String> toUpperCase(List<String> data) {

        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
