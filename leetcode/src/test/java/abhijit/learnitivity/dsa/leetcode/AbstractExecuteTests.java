package abhijit.learnitivity.dsa.leetcode;

import abhijit.learnitivity.dsa.test.GetTestCasesData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public abstract class AbstractExecuteTests<TestCase> {

    private final String fileName;
    private final Class<?> testCaseType;

    public AbstractExecuteTests(String fileName, Class<?>  testCaseType) {
        this.fileName = fileName;
        this.testCaseType = testCaseType;
    }

    protected abstract void executeTest(TestCase tc);

    @Test
    void executeAllTests() throws IOException {
        GetTestCasesData<TestCase> testCasesData = new GetTestCasesData<>();
        List<TestCase> testCases = testCasesData.fetchTestCases(fileName, getClass(), testCaseType);
        testCases.forEach(this::executeTest);
    }
}
