
package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.SubjectDao;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		String no = req.getParameter("f4");
		String f = req.getParameter("f");
		TestListStudentDao TLSD = new TestListStudentDao();
		Student Student = new Student();
		Student.setNo(no);
		List<TestListStudent> result = TLSD.filter(Student);
		List<ArrayList> A = new ArrayList<>();
		
		
		
		List<Subject> subjects = null;
		SubjectDao SubDao = new SubjectDao();
		subjects = SubDao.filter(teacher.getSchool());
        req.setAttribute("subjects", subjects);
		req.setAttribute("subject", A);
		req.setAttribute("student", result);
		req.setAttribute("f4", no);
		req.setAttribute("student_name", "ajkbvd");
		req.setAttribute("f", f);
		System.out.println("result: "+result);
		req.getRequestDispatcher("test_list_student.jsp").forward(req, res);;
	}
	

}
