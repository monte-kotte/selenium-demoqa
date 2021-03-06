package karpuk.demoqa.core.model;

import karpuk.demoqa.core.model.enums.Gender;
import karpuk.demoqa.core.model.enums.Hobby;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String firstName; // required field to submit form
    private String lastName; // required field to submit form
    private String email;
    private Gender gender; // required field to submit form
    private String mobile; // required field to submit form
    private LocalDate dateOfBirth; // required field to submit form
    private List<Hobby> hobbies;
    private String currentAddress;
}
