package karpuk.demoqa.test.data;

public enum StudentTemplate {

    STUDENT_REQUIRED_FIELDS_ONLY("/student-required-fields-only.json"),
    STUDENT_ALL_FIELDS("/student-all-fields.json");

    public final String filePath;

    StudentTemplate(String filePath) {
        this.filePath = "src/test/resources/json" + filePath;
    }

    public String getFilePath() {
        return filePath;
    }

}
