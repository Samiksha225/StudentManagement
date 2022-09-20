package ai.rnt.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ai.rnt.dao.StudentDao;
import ai.rnt.model.Student;
import ai.rnt.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public boolean updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public boolean deleteStudent(Student student) {
		return studentDao.deleteStudent(student);
	}

	@Override
	public boolean addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	@Override
	public boolean deleteMultipleStudents(List<Long> studentsIds) {
		return studentDao.deleteMultipleStudents(studentsIds);
	}
}
