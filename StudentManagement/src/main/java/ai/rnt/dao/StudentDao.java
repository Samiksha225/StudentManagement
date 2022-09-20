package ai.rnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import ai.rnt.dbconnect.DbConnection;
import ai.rnt.model.Student;

@Repository
public class StudentDao {
	// get All students
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		StringBuffer query = new StringBuffer();
		query.append(" select student_id, first_name, last_name, email, mobile, gender, date_of_birth, softwareSkills");
		query.append(" from student");
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(query.toString());) {
			try (ResultSet rs = prepareStatement.executeQuery();) {
				while (rs.next()) {
					student = new Student();
					student.setStudentId(rs.getLong("student_id"));
					student.setFirstName(rs.getString("first_name"));
					student.setLastName(rs.getString("last_name"));
					student.setEmail(rs.getString("email"));
					student.setMobile(rs.getLong("mobile"));
					student.setGender(rs.getString("gender"));
					student.setDateOfBirth(rs.getString("date_of_birth"));
					student.setSoftwareSkills(rs.getString("softwareSkills"));
					students.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

//	get students by id
	public Student getStudentById(Long studentId) {
		Student student = null;
		StringBuffer query = new StringBuffer();
		query.append(" select student_id, first_name, last_name, email, mobile, gender, date_of_birth, softwareSkills");
		query.append(" from student");
		query.append(" where student_id = ?");
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(query.toString());) {
			prepareStatement.setLong(1, studentId);
			try (ResultSet rs = prepareStatement.executeQuery();) {
				while (rs.next()) {
					student = new Student();
					student.setStudentId(rs.getLong("student_id"));
					student.setFirstName(rs.getString("first_name"));
					student.setLastName(rs.getString("last_name"));
					student.setEmail(rs.getString("email"));
					student.setMobile(rs.getLong("mobile"));
					student.setGender(rs.getString("gender"));
					student.setDateOfBirth(rs.getString("date_of_birth"));
					student.setSoftwareSkills(rs.getString("softwareSkills"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

//	delete student
	public boolean deleteStudent(Student delete) {
		boolean result = false;
		StringBuffer query = new StringBuffer();
		query.append(" delete from student where student_id=?");
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(query.toString());) {
			prepareStatement.setLong(1, delete.getStudentId());
			int count = prepareStatement.executeUpdate();
			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
		
//delete multiple student record.
    public boolean deleteMultipleStudents(List<Long>  studentsIds) {
        boolean result=false;
        StringBuilder query = new StringBuilder();
        String asstringstudentsIds = studentsIds.toString();
          asstringstudentsIds = asstringstudentsIds.replaceAll("[\\[\\]]", "");
        query.append("delete from student where student_id IN(" + asstringstudentsIds + ")");
        //List<Student> students = new ArrayList<Student>();
        try (Connection connection = DbConnection.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(query.toString());
            int count = prepareStatement.executeUpdate();
            if (count > 0) {
                result = true;
            }
    }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
}

//Update student
	public boolean updateStudent(Student update) {
		boolean result = false;
		StringBuilder query = new StringBuilder();
		query.append("update student set first_name=?, last_name=?, email=?, mobile=?, gender=?, date_of_birth=?, softwareSkills=? ");
		query.append(" where student_id=?");
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query.toString());) {
			int index = 1;
			preparedStatement.setString(index++, update.getFirstName());
			preparedStatement.setString(index++, update.getLastName());
			preparedStatement.setString(index++, update.getEmail());
			preparedStatement.setLong(index++, update.getMobile());
			preparedStatement.setString(index++, update.getGender());
			preparedStatement.setString(index++, update.getDateOfBirth());
			preparedStatement.setString(index++, update.getSoftwareSkills());
			preparedStatement.setLong(index++, update.getStudentId());
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

//	 Add Student.
	public boolean addStudent(Student add) {
		boolean result = false;
		StringBuilder query = new StringBuilder();
		query.append(" INSERT INTO STUDENT ");
		query.append("(first_name, last_name, email, mobile, gender, date_of_birth, softwareSkills) ");
		query.append("VALUES(?, ?, ?, ?, ?, ?, ?) ");
		try (Connection connection = DbConnection.getConnection()) {
			PreparedStatement prepareStatement = connection.prepareStatement(query.toString());
			int index = 1;
			prepareStatement.setString(index++, add.getFirstName());
			prepareStatement.setString(index++, add.getLastName());
			prepareStatement.setString(index++, add.getEmail());
			prepareStatement.setLong(index++, add.getMobile());
			prepareStatement.setString(index++, add.getGender());
			prepareStatement.setString(index++, add.getDateOfBirth());
			prepareStatement.setString(index++, add.getSoftwareSkills());
			int count = prepareStatement.executeUpdate();
			if (count > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}