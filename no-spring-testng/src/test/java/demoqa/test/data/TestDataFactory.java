package demoqa.test.data;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class TestDataFactory {

    private static final String FILE_PATH = "src/test/resources/json";

    public static <T> T fromFile(String jsonFileName, Class<T> clazz) throws FileNotFoundException {
        Reader reader = new FileReader(FILE_PATH + jsonFileName);
        Gson gson = new Gson();
        return gson.fromJson(reader, clazz);
    }

}
