package ai.rnt.model;

public class Student {
	private String multipleDelete;
	private Long studentId;
	private String firstName;
	private String lastName;
	private String email;
	private Long mobile;
	private String gender;
	private String dateOfBirth;
	private String softwareSkills;

	public Student() {
		super();
	}

	public Student(String multipleDelete,Long studentId, String firstName, String lastName, String email, Long mobile, String gender,
			String dateOfBirth,String softwareSkills) {
		super();
		this.multipleDelete = multipleDelete;
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.softwareSkills = softwareSkills;
	}


	public String getMultipleDelete() {
		return multipleDelete;
	}

	public void setMultipleDelete(String multipleDelete) {
		this.multipleDelete = multipleDelete;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSoftwareSkills() {
		return softwareSkills;
	}

	public void setSoftwareSkills(String softwareSkills) {
		this.softwareSkills = softwareSkills;
	}

	@Override
	public String toString() {
		return "Student [multipleDelete=" + multipleDelete + ", studentId=" + studentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", mobile=" + mobile + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", softwareSkills=" + softwareSkills + "]";
	}

	
}