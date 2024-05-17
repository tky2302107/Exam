package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import bean.TestListSubject;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestListSubjectDao;
import tool.Action;

public class TestListSubjectExecuteAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {// ユーザーデータを取得＆セレクトボックス用のクラスデータを取得

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
//		
//		School School = new School();
//        
        
//        Subject Subject = new Subject();
        int entYear = Integer.parseInt(req.getParameter("f1"));
        String classNum = req.getParameter("f2");
        String subject = req.getParameter("f3");
        String f = req.getParameter("f");
        
        TestListSubjectDao TLSD = new TestListSubjectDao();
        SubjectDao SubDao = new SubjectDao();
		
        
        
		Subject subject0 = SubDao.get(subject, teacher.getSchool());
		List<TestListSubject> subject_result = TLSD.filter(entYear, classNum, subject0, teacher.getSchool());
        
        
        List<Subject> subject_set = null;
		subject_set = SubDao.filter(teacher.getSchool());
		
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		ClassNumDao cDao = new ClassNumDao();
		List<String> class_num_list = null;
		class_num_list = cDao.filter(teacher.getSchool());
		List<Integer> entYearSet = new ArrayList<>();
		for (int i = year - 10; i < year + 11; i++){
			entYearSet.add(i);
		}
		try{
			for (TestListSubject r : subject_result){
				System.out.println(":"+r.getStudentName()+":");
				if ((r.getStudentName().equals("")) || (r.getStudentName()==null) || (r.getStudentName().length()==0)){
					req.setAttribute("error", "truesj");
					req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
				}
				
			}
			req.setAttribute("subject_result", subject_result);
	        req.setAttribute("f1", entYear);
	        req.setAttribute("f2", classNum);
	        req.setAttribute("f3", subject);
	        req.setAttribute("subject_name", subject0.getName());
	        req.setAttribute("f", f);
			req.setAttribute("class_num_set", class_num_list); //選択項目
			req.setAttribute("ent_year_set", entYearSet);
			req.setAttribute("subject_set", subject_set);
		}catch(Exception e){
			req.setAttribute("error", "truesj");
			req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
		}
        req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
    }
}

