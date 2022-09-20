package ai.rnt.service;

import java.util.List;
import ai.rnt.model.Student;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudentById(Long studentId);

	boolean updateStudent(Student student);

	boolean deleteStudent(Student student);

	boolean addStudent(Student student);

    boolean deleteMultipleStudents(List<Long>  studentsIds);
    
}
