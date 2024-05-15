package scoremanager.main;

import java.util.ArrayList;
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

public class TestRegistAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {
		Util util = new Util();
		util.setEntYearSet(req);
		util.setNumSet(req);
		util.setClassNumSet(req);
		util.setSubjects(req);
		if (req.getParameter("f1") == null || req.getParameter("f2") == null
				|| req.getParameter("f3") == null || req.getParameter("f4") == null) {
			req.getRequestDispatcher("test_regist.jsp").forward(req, res);
		}
		setRequestData(req, res);
		return;
	}

	private void setRequestData(HttpServletRequest req,HttpServletResponse res) throws Exception{
		Util util = new Util();
		Teacher teacher = util.getUser(req);
		int entYear = 0;
		String classNum = null;
		String subject_cd = null;
		int num = 0;
		Subject subject = new Subject();
		SubjectDao subjectDao = new SubjectDao();
		entYear = Integer.parseInt(req.getParameter("f1"));
		classNum = req.getParameter("f2");
		subject_cd = req.getParameter("f3");
		num = Integer.parseInt(req.getParameter("f4"));
		req.setAttribute("f1", entYear);
		req.setAttribute("f2", classNum);
		req.setAttribute("f3", subject_cd);
		req.setAttribute("f4", num);
		if(entYear != 0 && classNum != null && subject_cd != null && num != 0){
			StudentDao sDao = new StudentDao();
			TestDao tDao = new TestDao();
			List<Test> list = new ArrayList<>();
			subject = subjectDao.get(subject_cd, teacher.getSchool());
			list = tDao.filter(entYear,classNum,subject,num,teacher.getSchool());
			req.setAttribute("subject_name", subject.getName());
			req.setAttribute("req", "update");
			req.setAttribute("student_list", list);
			List<Student> list2 = new ArrayList<Student>();
			list2 = sDao.filter(teacher.getSchool(),entYear,classNum,true);
			if(list == null){
				req.setAttribute("student_list", list2);
				req.getRequestDispatcher("test_regist_create.jsp").forward(req, res);;
				return;
			}else{
				if (list.size() < list2.size()) {
					for(Test t : list){
						req.setAttribute("point_" + t.getStudent().getNo(),t.getPoint());
					}
					req.setAttribute("student_list", list2);
					req.getRequestDispatcher("test_regist_create.jsp").forward(req, res);
					return;
				}else{
				req.getRequestDispatcher("test_regist_update.jsp").forward(req, res);
				return;
				}
			}

		}else{
			req.setAttribute("error", "入学年度とクラスと科目と回数を選択してください。");
			req.getRequestDispatcher("test_regist.jsp").forward(req, res);
		}
	}

}