package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;
import tool.Action;


public class StudentUpdateExecuteAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		HttpSession session = req.getSession();
//		Teacher teacher = (Teacher)session.getAttribute("user");     
		
		String name = req.getParameter("no");
		String no = req.getParameter("name"); 
		String classNum = req.getParameter("class_num");
		String entYearStr = req.getParameter("ent_year");
		String isAttend = req.getParameter("is_attend");
		Boolean flg = null;
		Student student = new Student();
		StudentDao sDao = new StudentDao();
		
		student.setNo(no);
		student.setName(name);
		student.setentYear(Integer.parseInt(entYearStr));
		student.setClassNum(classNum);
		student.setAttend(Boolean.valueOf(isAttend));
//		student.setSchool(teacher.getSchool());
		flg = sDao.save(student);
		System.out.println(flg);
		
		req.getRequestDispatcher("").forward(req, res);
	}
}

