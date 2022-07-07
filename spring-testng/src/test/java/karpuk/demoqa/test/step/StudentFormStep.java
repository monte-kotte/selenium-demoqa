package karpuk.demoqa.test.step;

import karpuk.demoqa.core.model.ResultStudent;
import karpuk.demoqa.core.model.Student;

public class StudentFormStep extends BaseStep {

    public void submitRequiredFields(Student student) {
        studentFormPage.enterFirstName(student.getFirstName());
        studentFormPage.enterLastName(student.getLastName());
        studentFormPage.selectGender(student.getGender());
        studentFormPage.enterMobileNumber(student.getMobile());
        studentFormPage.openDateOfBirthCalendar();
        calendarForm.selectDateOfBirth(student.getDateOfBirth());
        studentFormPage.submitForm();
    }

    public ResultStudent getResultStudent() {
        return ResultStudent.builder()
                .fullName(resultTable.getFullName())
                .gender(resultTable.getGender())
                .mobile(resultTable.getMobile())
                .dateOfBirth(resultTable.getDateOfBirth())
                .build();
    }

}
