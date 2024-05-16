
package scoremanager.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.StudentDao;
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
		StudentDao StDao = new StudentDao();
		Student number = StDao.get(no);
		Map<String,String> errors =new HashMap<>();
		
		List<Subject> subjects = null;
		SubjectDao SubDao = new SubjectDao();
		subjects = SubDao.filter(teacher.getSchool());
        req.setAttribute("subjects", subjects);
		req.setAttribute("subject", A);
		
		System.out.println("result: "+result);
		req.setAttribute("result", result);
		
		req.setAttribute("f4", no);
		req.setAttribute("error", "false");
//		try{
			req.setAttribute("student_name", number.getName());
			req.setAttribute("student_no", number.getNo());
			req.setAttribute("student_class", number.getClass());
	//		req.setAttribute("student_no", number.getNo());
	//		req.setAttribute("student_no", number.getNo());
			req.setAttribute("f", f);
			req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
//		}catch(Exception e){
//			req.setAttribute("error", "true");
//			req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
//		}
	}
	

}
