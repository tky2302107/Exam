package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String entYearStr = req.getParameter("ent_year");
		String name = req.getParameter("name");
		String no = req.getParameter("no"); 
		String classNum = req.getParameter("class_num");
		String isAttend = req.getParameter("is_attend");
		Student student = new Student();
		StudentDao sDao = new StudentDao();

		boolean isAttend1 = false;
		if (isAttend == null){
			isAttend1 = false;
		}else if (isAttend.equals("on")){
			isAttend1 = true;
		}else{
			isAttend1 = false;
		}
		
		student.setNo(no);
		student.setName(name);
		student.setentYear(Integer.parseInt(entYearStr));
		student.setClassNum(classNum);
		student.setAttend(isAttend1);
		sDao.save(student);
		
		req.getRequestDispatcher("student_update_done.jsp").forward(req, res);
	}
}

