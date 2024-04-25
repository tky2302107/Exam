package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
//import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		HttpSession session = req.getSession();
//		Teacher teacher = (Teacher)session.getAttribute("user");
		StudentDao sDao = new StudentDao();
		String no = null;
		no = req.getParameter("no");
		Student sdaoget;
		sdaoget = sDao.get(no);
		String gno = sdaoget.getNo();
		String gname = sdaoget.getName();
		String gclassnum = sdaoget.getClassNum();
		int gentyear = sdaoget.getEntYear();
		School gschool = sdaoget.getSchool();
		int gschooyear = sdaoget.getSchoolYear();
		
		
		
	}

}
