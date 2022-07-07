package karpuk.demoqa.test.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import karpuk.demoqa.core.model.Student;

import java.io.File;
import java.io.IOException;

public class TestDataFactory {

    public static Student createStudent(StudentTemplate template) throws IOException {
        return fromFile(template.getFilePath(), Student.class);
    }

    private static <T> T fromFile(String fileName, Class<T> clazz) throws IOException {
        return new ObjectMapper().registerModule(new JavaTimeModule()).readValue(new File(fileName), clazz);
    }

}
