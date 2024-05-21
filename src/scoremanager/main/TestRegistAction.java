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
		StudentDao studentDao =new StudentDao();
		entYear = Integer.parseInt(req.getParameter("f1"));
		classNum = req.getParameter("f2");
		subject_cd = req.getParameter("f3");
		num = Integer.parseInt(req.getParameter("f4"));
		req.setAttribute("f1", entYear);
		req.setAttribute("f2", classNum);
		req.setAttribute("f3", subject_cd);
		req.setAttribute("f4", num);
		if(entYear != 0 && classNum != null && subject_cd != null && num != 0){
			TestDao tDao = new TestDao();
			List<Test> test_result = new ArrayList<>();
			subject = subjectDao.get(subject_cd, teacher.getSchool());
			test_result = tDao.filter(entYear,classNum,subject,num,teacher.getSchool());
			List<Student> student_data = studentDao.filter(teacher.getSchool(), entYear, classNum,true);
			/*List<String> cnlist = new ArrayList<>();
			List<Integer> eylist = new ArrayList<>();
			List<String> nalist = new ArrayList<>();
			List<String> nolist = new ArrayList<>();
			List<String> sclist = new ArrayList<>();
			List<String> sylist = new ArrayList<>();*/
			/*Map<String ,Integer> map = new HashMap<>();
			for (Test t : test_result){
				map.put(t.getNo(), t.getPoint());
				
			}*/
//			System.out.println(map);
			
			List<String> no_tf = new ArrayList<>();
			List<Integer> point = new ArrayList<>();
			for (Test t : test_result){
				no_tf.add(t.getStudent().getNo());
				
				point.add(t.getPoint());

			}
			System.out.println("Point:"+point);
			/*for (Student s :student_data){
				cnlist.add(s.getClassNum());
				eylist.add(s.getEntYear());
				nalist.add(s.getName());
				nolist.add(s.getNo());
				sclist.add(String.valueOf(s.getSchool()));
				sylist.add(String.valueOf(s.getSchoolYear()));
			}*/
			
			
			req.setAttribute("student_list", student_data);
			req.setAttribute("test_result", test_result);
			req.setAttribute("subject_name", subject.getName());
//			System.out.println(test_result);
			req.setAttribute("no_tf", no_tf);
			req.setAttribute("pointlist", point);
//			req.setAttribute("student_list", student_list);
//			req.setAttribute("student_list", student_list);
//			req.setAttribute("student_list", student_list);
			req.getRequestDispatcher("test_regist.jsp").forward(req, res);;
			
//			Student students = new Student();
			
//			students.setClassNum("");
//			students.setEntYear(entYear);
//			students.setName(list.get);
//			students.setNo(no);
			
//			req.setAttribute("subject_name", subject.getName());
//			req.setAttribute("req", "update");
//			req.setAttribute("test_result", test_result);
//			/*req.setAttribute("student_list", test_result);*/
//			List<Student> student_list = new ArrayList<Student>();
//			student_list = sDao.filter(teacher.getSchool(),entYear,classNum,true);
//			if(test_result == null){
//				req.setAttribute("student_list", student_list);
//				req.getRequestDispatcher("test_regist.jsp").forward(req, res);;
//				return;
//			}else{
//				if (test_result.size() < student_list.size()) {
//					for(Test t : test_result){
//						req.setAttribute("point_" + t.getStudent().getNo(),t.getPoint());
//					}
//					req.setAttribute("student_list", student_list);
//					req.getRequestDispatcher("test_regist.jsp").forward(req, res);
//					return;
//				}else{
//				req.getRequestDispatcher("test_regist.jsp").forward(req, res);
//				return;
//				}
//			}

		}else{
			req.setAttribute("error", "入学年度とクラスと科目と回数を選択してください。");
			req.getRequestDispatcher("test_regist.jsp").forward(req, res);
		}
	}

}