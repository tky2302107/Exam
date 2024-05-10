package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		ClassNumDao cn = new ClassNumDao();
		
		String entYearStr = req.getParameter("ent_year");
		String name = req.getParameter("name");
		String no = req.getParameter("no"); 
		String classNum = req.getParameter("class_num");
		String isAttend = req.getParameter("is_attend");
		Student student = new Student();
		StudentDao sDao = new StudentDao();
		
		if (classNum.equals("0") || classNum.equals("") || classNum==null){
			req.setAttribute("ent_year", entYearStr);
			req.setAttribute("no", no);
			req.setAttribute("name", name);
			req.setAttribute("class_num_set", cn.filter(teacher.getSchool()));
			req.getRequestDispatcher("student_update.jsp").forward(req, res);
		}
		
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
		student.setEntYear(Integer.parseInt(entYearStr));
		student.setClassNum(classNum);
		student.setAttend(isAttend1);
		sDao.save(student);
		
		req.getRequestDispatcher("student_update_done.jsp").forward(req, res);
	}
}

