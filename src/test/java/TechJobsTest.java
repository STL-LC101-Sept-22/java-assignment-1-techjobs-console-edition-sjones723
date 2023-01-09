import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
public class TechJobsTest {

    private static ByteArrayOutputStream baos;

    // set up an alternative output stream to capture output
    // this needs to be done before every test so we don't contaminate test output
    @Before
    public void setUpOutputStream() {
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    private static String runProgramWithInput(String input) {
        Scanner in = new Scanner(input);
        TechJobs.in = in;
        TechJobs.main(null);
        return baos.toString();
    }

    private static String getFileContents(String fileName) throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName);
        return Files.readString(path);
    }

    @Test
    public void testPrintJobs() throws IOException {
        String input = "0\n2\nBuzzbold\nx";
        String output = runProgramWithInput(input);
        String expected = getFileContents("src/test/resources/testPrintJobs.txt");
        assertEquals(expected, output);
    }

    @Test
    public void testPrintJobsNoResults() throws IOException {
        String input = "0\n2\nChicago\nx";
        String output = runProgramWithInput(input);
        String expected = getFileContents("src/test/resources/testPrintJobsNoResults.txt");
        assertEquals(expected, output);
    }

    @Test
    public void testFindByValue() throws IOException {
        String input = "0\n0\nRuby\nx";
        String output = runProgramWithInput(input);
        String expected = getFileContents("src/test/resources/testFindByValue.txt");
        assertEquals(expected, output);
    }

    @Test
    public void testCaseInsensitiveSearch() throws IOException {
        String input = "0\n3\nnew YORk\nx";
        String output = runProgramWithInput(input);
        String expected = getFileContents("src/test/resources/testCaseInsensitiveSearch.txt");
        assertEquals(expected, output);
    }


}
