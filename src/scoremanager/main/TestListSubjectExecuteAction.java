package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.TestListSubject;
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
        School school = null;
		List<TestListSubject> Subject1 = TLSD.filter(entYear, classNum, subject0, school);
        System.out.println(Subject1);
        
        
        req.setAttribute("subject", Subject1);
        req.setAttribute("f1", entYear);
        req.setAttribute("f2", classNum);
        req.setAttribute("f3", subject);
        req.setAttribute("f", f);
        List<Subject> subjects = null;
		subjects = SubDao.filter(teacher.getSchool());
        req.setAttribute("subjects", subjects);
        req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
    }
}

