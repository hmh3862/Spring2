package kr.green.mvc3.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Student implements Serializable {
	 
	private static final long serialVersionUID = -6716190283268146428L;

	@Size(min=3, max=30)
    private String firstName;
 
    @Size(min=3, max=30)
    private String lastName;
 
    @NotEmpty
    private String sex;
 
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Past 
    @NotNull
    private Date dob;
 
    @Email 
    @NotEmpty
    private String email;
 
    @NotEmpty
    private String section;
 
    @NotEmpty
    private String country;
 
    private boolean firstAttempt;
 
    @NotEmpty
    private List<String> subjects = new ArrayList<String>();
}