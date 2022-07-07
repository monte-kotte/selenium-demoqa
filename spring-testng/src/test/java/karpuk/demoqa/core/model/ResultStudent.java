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
public class ResultStudent {
    private String fullName;
    private String email;
    private Gender gender;
    private String mobile;
    private LocalDate dateOfBirth;
    private List<Hobby> hobbies;
    private String currentAddress;
}
