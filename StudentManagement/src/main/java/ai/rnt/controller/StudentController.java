package ai.rnt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ai.rnt.model.Student;
import ai.rnt.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	@Autowired
	StudentService studentservice;

	// get All students
	@GetMapping("/home")
	public ModelAndView getAllStudent() {
		ModelAndView mv = new ModelAndView("student");
		List<Student> students = studentservice.getAllStudents();
		mv.addObject("studentList", students);
		return mv;
	}

// get student by id
	@GetMapping("/{getstudentById}")
	public ModelAndView getStudentById(HttpServletRequest request) {
		long studentId = Long.parseLong((request.getParameter("studentId")));
		ModelAndView mv = new ModelAndView("student");
		Student student = studentservice.getStudentById(studentId);
		List<Student> students = Arrays.asList(student);
		mv.addObject("studentList", students);
		if (student == null) {
			mv.addObject("message", "ID not exist");
		}
		return mv;
	}

//	delete student
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	// @GetMapping("/delete")
	public String delete(HttpServletRequest request, RedirectAttributes redi) {
		String studentId = request.getParameter("studentId");
		Student delete = new Student();
		delete.setStudentId(Long.valueOf(studentId));
		boolean isStudentDeleted = studentservice.deleteStudent(delete);
		if (isStudentDeleted) {
			redi.addFlashAttribute("message", " Record deleted successfully");
			redi.addFlashAttribute("icon", "success");
		} else {
			redi.addFlashAttribute("error", "data is not deleted");
			redi.addFlashAttribute("icon", "error");
		}
		return "redirect:/home";
	}

//	// delete multiple student record.
	@RequestMapping(value = "/multipledelete", method = RequestMethod.GET)
	public String deleteMultipleStudents(HttpServletRequest request,
			@RequestParam(name = "deletemultiplestudent") List<Long> studentsIds, RedirectAttributes redi) {
		ModelAndView mv = new ModelAndView("student");
		boolean isStudentDeleted = studentservice.deleteMultipleStudents(studentsIds);
		if (isStudentDeleted) {
			redi.addFlashAttribute("message", " Selected records deleted successfully");
			redi.addFlashAttribute("icon", "success");
		} else {
			redi.addFlashAttribute("error", " Selected records not deleted");
			redi.addFlashAttribute("icon", "error");
		}

		mv.addObject("studentList", studentsIds);
		return "redirect:/home";
	}

	@GetMapping("/update")
	public ModelAndView updateStudent(@RequestParam(name = "studentId", required = false) Long studentId) {
		ModelAndView mv = new ModelAndView("update");
		Student student = studentservice.getStudentById(studentId);
		mv.addObject("student", student);
		return mv;
	}

	// Update Student
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute(name = "studentId") Long studentId, HttpServletRequest request,
			RedirectAttributes redi) {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("date_of_birth");
		String softwareSkills[] = request.getParameterValues("softwareSkills");
		StringJoiner sj = new StringJoiner(" , ");
		for (int i = 0; i < softwareSkills.length; i++) {
			sj.add(softwareSkills[i]);
		}
		Student update = new Student();
		update.setStudentId(studentId);
		update.setFirstName(firstName);
		update.setLastName(lastName);
		update.setEmail(email);
		update.setMobile(Long.valueOf(mobile));
		update.setGender(gender);
		update.setDateOfBirth(dateOfBirth);
		update.setSoftwareSkills(sj.toString());
		boolean isStudentUpdated = studentservice.updateStudent(update);
		if (isStudentUpdated) {
			redi.addFlashAttribute("message", " Record updated successfully");
			redi.addFlashAttribute("icon", "success");
		} else {
			redi.addFlashAttribute("error", "data is not updated");
			redi.addFlashAttribute("icon", "error");
		}
		return "redirect:/home";
	}

//	insert student
	@RequestMapping("/add")
	public String add(HttpServletRequest request, RedirectAttributes redi) {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("date_of_birth");
		String softwareSkills[] = request.getParameterValues("softwareSkills");
		StringJoiner sj = new StringJoiner(" , ");
		for (int i = 0; i < softwareSkills.length; i++) {
			sj.add(softwareSkills[i]);
		}
		Student add = new Student();
		add.setFirstName(firstName);
		add.setLastName(lastName);
		add.setEmail(email);
		add.setMobile(Long.valueOf(mobile));
		add.setGender(gender);
		add.setDateOfBirth(dateOfBirth);
		add.setSoftwareSkills(sj.toString());
		boolean isStudentAdded = studentservice.addStudent(add);
		if (isStudentAdded) {
			redi.addFlashAttribute("message", " Record inserted successfully");
			redi.addFlashAttribute("icon", "success");
		} else {
			redi.addFlashAttribute("error", "data is not inserted");
			redi.addFlashAttribute("icon", "error");
		}
		return "redirect:/home";
	}

	@RequestMapping("/addStudent")
	public String addStudentInfo() {
		return "addStudent";
	}

	@RequestMapping("/homepage")
	public String homepage() {
		return "redirect:/home";
	}
}