package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentDeleteAction extends Action{

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
		int ent_year = sdaoget.getEntYear();
		School school = sdaoget.getSchool();
		int schoolYear = sdaoget.getSchoolYear();
		List<Student> students = null;
		StudentDao cls = new StudentDao();
		
		
		students = cls.filter(teacher.getSchool(),ent_year, gclassnum, true);
		req.setAttribute("gno", String.valueOf(gno));
		req.setAttribute("name", gname);
		req.setAttribute("class_num_set", cn.filter(teacher.getSchool()));
		req.setAttribute("ent_year", String.valueOf(ent_year));
		req.setAttribute("school", school);
		req.setAttribute("schoolYear", schoolYear);
		req.setAttribute("students", students);
		req.setAttribute("no", String.valueOf(gno));
		req.setAttribute("ent_year", String.valueOf(ent_year));
		req.getRequestDispatcher("student_delete.jsp").forward(req, res);		
	}
	

}
