package karpuk.demoqa.test.step;

import karpuk.demoqa.core.model.Student;

public class StudentFormStep extends BaseStep {

    public void submitRequiredFields(Student student) {
        studentFormPage.enterFirstName(student.getFirstName());
        studentFormPage.enterLastName(student.getLastName());
        studentFormPage.selectGender(student.getGender());
        studentFormPage.enterMobileNumber(student.getMobile());
        studentFormPage.enterDateOfBirth(student.getDateOfBirth());
        studentFormPage.submitForm();
    }

}
