package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;
//@WebServlet(urlPatterns={"scoremanager.main/StudentCreateExecuteAction"})
public class StudentCreateExecuteAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		Map<String,String> errors =new HashMap<>();
		StudentDao sDao = new StudentDao();
		Student student = new Student();
		
		
		String no = req.getParameter("execute_no");
		String name = req.getParameter("execute_name");
		String classNum = req.getParameter("execute_classNum");
		int entYear = Integer.parseInt(req.getParameter("execute_entYear"));
		
		
//		if (entYearStr != null){
//			entYear = Integer.parseInt(entYearStr);
//		}else{
//			entYear = 0;
//		}
		
		int chk = 0;
		if (entYear == 0 ){// || entYearStr == null
			if (chk > 0){
				System.out.println("if");
				errors.put("entYear", "入学年度を選択してください");
				System.out.println("Aroot:"+entYear);
				System.out.println("ENT"+req.getParameter("entYear"));
				req.setAttribute("errors1", errors);
			}else{
				chk += 1;
				System.out.println(chk);
			}
		}else if(sDao.get(no)==null){
			System.out.println("e00");
			student.setNo(no);
			student.setName(name);
			student.setentYear(entYear);
			student.setClassNum(classNum);
			student.setAttend(true);
			student.setSchool(teacher.getSchool());
			sDao.save(student);
			req.getRequestDispatcher("student_create_done.jsp").forward(req, res);
			
		}else{
			errors.put("duplication", "学生番号が重複しています");
			System.out.println("e01");
			req.setAttribute("errors5", errors);
		}
//		req.getRequestDispatcher("StudentCreateAction.java").forward(req, res);
		
	}
}
