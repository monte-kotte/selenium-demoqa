package karpuk.demoqa.test;

import karpuk.demoqa.core.model.ResultStudent;
import karpuk.demoqa.core.model.Student;
import karpuk.demoqa.test.base.SpringAwareTestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static karpuk.demoqa.test.data.StudentTemplate.STUDENT_REQUIRED_FIELDS_ONLY;
import static karpuk.demoqa.test.data.TestDataFactory.createStudent;

public class StudentFormTest extends SpringAwareTestBase {

    @BeforeMethod
    void openTestedForm() {
        baseStep.openPage(values.getBaseUrl());
        appHomePage.openFormsPage();
        studentFormPage.open();
    }

    @Test
    void submitRequiredFieldsOnlyTest() throws Exception {
        Student student = createStudent(STUDENT_REQUIRED_FIELDS_ONLY);
        studentFormStep.submitRequiredFields(student);
        ResultStudent actualStudent = studentFormStep.getResultStudent();

        softAssert.assertThat(actualStudent.getFullName())
                .startsWith(student.getFirstName())
                .endsWith(student.getLastName());
        softAssert.assertThat(actualStudent)
                .usingRecursiveComparison()
                .comparingOnlyFields("gender", "mobile", "dateOfBirth")
                .isEqualTo(student);
        softAssert.assertAll();
    }

}
