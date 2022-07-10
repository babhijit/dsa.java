package abhijit.learnitivity.dsa.test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestCasesDataRetriever<TestCase> {
    public List<TestCase> fetch(String fileName,
                                Class<?> testClassType,
                                Type testCaseType) throws IOException {
        String testsData = IOUtils.toString(
                Objects.requireNonNull(testClassType.getResourceAsStream(fileName)),
                StandardCharsets.UTF_8
        );
        Gson gson = new Gson();
        JsonArray testCases = (JsonArray) JsonParser.parseString(testsData);

        List<TestCase> testCasesData = new ArrayList<>();
        testCases.forEach(testCase -> testCasesData.add(gson.fromJson(testCase, testCaseType)));
        return testCasesData;
    }
}
