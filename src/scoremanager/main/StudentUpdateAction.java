package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
//import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		StudentDao sDao = new StudentDao();
		String no = null;
		no = req.getParameter("no");
		Student sdaoget;
		sdaoget = sDao.get(no);
		String gno = sdaoget.getNo();
		String gname = sdaoget.getName();
		ClassNumDao cn = new ClassNumDao();
		
		String gclassnum = sdaoget.getClassNum();
		int gentyear = sdaoget.getEntYear();
		School gschool = sdaoget.getSchool();
		int gschoolyear = sdaoget.getSchoolYear();
		List<Student> students = null;
		StudentDao cls = new StudentDao();
		
		
		students = cls.filter(teacher.getSchool(),gentyear, gclassnum, true);
		req.setAttribute("no", gno);
		req.setAttribute("name", gname);
		req.setAttribute("class_num_set", cn.filter(teacher.getSchool()));
		req.setAttribute("ent_year", gentyear);
		req.setAttribute("school", gschool);
		req.setAttribute("schoolYear", gschoolyear);
		req.setAttribute("students", students);
		System.out.println("(・_・)");
;		req.getRequestDispatcher("student_update.jsp").forward(req, res);
	}
}
