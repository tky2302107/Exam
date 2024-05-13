package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class TestListAction extends Action{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		
		Teacher teacher = (Teacher)session.getAttribute("user");
		
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		ClassNumDao cNumDao = new ClassNumDao();
		SubjectDao SubDao = new SubjectDao();
		
		
		List<String> list = cNumDao.filter(teacher.getSchool());//クラスの一覧
		List<Subject> list2 = SubDao.filter(teacher.getSchool());
		
		
		List<Integer> entYearSet = new ArrayList<>();
		for (int i = year -10 ; i<year+1 ; i++ ){
			entYearSet.add(i);
		}
		
		req.setAttribute("num", list);
		req.setAttribute("subject.cd", list2);
		req.setAttribute("year", entYearSet);
		
		
		req.getRequestDispatcher("test_list.jsp").forward(req, res);
	}
}



