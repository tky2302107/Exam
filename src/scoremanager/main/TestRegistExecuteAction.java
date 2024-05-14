package scoremanager.main;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;
import tool.Util;

public class TestRegistExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Util util = new Util();
		Teacher teacher = util.getUser(req);
		Enumeration<String> paramlist = req.getParameterNames();
		List<Test> list = new ArrayList<>();
		int no = Integer.parseInt(req.getParameter("f4"));
		TestDao testDao = new TestDao();
		String cd = req.getParameter("f3");
		Subject subject = new Subject();
		SubjectDao subjectDao = new SubjectDao();
		StudentDao studentDao = new StudentDao();
		subject = subjectDao.get(cd, teacher.getSchool());
		String classNum = req.getParameter("f2");
		while(paramlist.hasMoreElements()){
			String name = paramlist.nextElement();
			if(name.startsWith("point_")){
				String student_cd = name.substring(6);
				try{
					Test test = new Test();
					Student student = new Student();
					student = studentDao.get(student_cd);
					test.setStudent(student);
					test.setSubject(subject);
					test.setSchool(teacher.getSchool());
					test.setNo(no);
					test.setPoint(Integer.parseInt(req.getParameter("point_"+student_cd)));
					test.setClassNum(classNum);
					list.add(test);
				}catch(Exception e){
					throw e;
				}
			}
		}
		testDao.save(list);
		req.getRequestDispatcher("test_regist_done.jsp").forward(req, res);
	}

}