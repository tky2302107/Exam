package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;
//@WebServlet(urlPatterns={"scoremanager.main/StudentCreateExecuteAction"})
public class StudentCreateExecuteAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		System.out.println("SCEA");
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		Map<String,String> errors =new HashMap<>();
		StudentDao sDao = new StudentDao();
		Student student = new Student();
		
		
		String no = req.getParameter("no");
		String name = req.getParameter("name");
		String classNum = req.getParameter("class_num");
		int entYear = Integer.parseInt(req.getParameter("ent_year"));
		
		
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
			req.setAttribute("eee", "eee");
			req.setAttribute("errors5", errors);
			req.setAttribute("no", no);
			req.setAttribute("name", name);
			req.setAttribute("class_num", classNum);
			req.setAttribute("ent_year", entYear);
			
			ClassNumDao cNumDao = new ClassNumDao();
			List<String> list = cNumDao.filter(teacher.getSchool());//　クラスの一覧
			req.setAttribute("class_num_set", list);
			
			List<Integer> entYearSet = new ArrayList<>();
			LocalDate todaysDate = LocalDate.now();
			int year = todaysDate.getYear();
			for (int i = year -10 ; i<year+1 ; i++ ){
				entYearSet.add(i);
			}
			req.setAttribute("ent_year_set", entYearSet);
			req.getRequestDispatcher("student_create.jsp").forward(req, res);// StudentCreate.action
		}
//		req.getRequestDispatcher("StudentCreate.action").forward(req, res);
		
	}
}
