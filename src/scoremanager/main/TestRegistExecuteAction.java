package scoremanager.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int entYear = 0;
		String classNum = null;
		String subject_cd = null;
		int num = 0;
		Subject subject = new Subject();
		SubjectDao subjectDao = new SubjectDao();
		StudentDao studentDao =new StudentDao();
		TestDao tDao = new TestDao();
		entYear = Integer.parseInt(req.getParameter("f1"));
		classNum = req.getParameter("f2");
		subject_cd = req.getParameter("f3");
		num = Integer.parseInt(req.getParameter("f4"));
		req.setAttribute("f1", entYear);
		req.setAttribute("f2", classNum);
		req.setAttribute("f3", subject_cd);
		req.setAttribute("f4", num);
		
		List<String> ret = (List<String>) req.getAttribute("ret");
		/*List<String> list = Arrays.asList( "-1" , "2", "3", "4", "5" );*/
		 
        List<Integer> newret = new ArrayList<>();
        for (String s : ret) {
            newret.add(Integer.parseInt(s));
        }
        Map<String,Integer> PointFinlist = new HashMap<>();
        int rr;
        for (rr=0;rr<ret.size();rr++){
        	
        	PointFinlist.put(ret.get(rr),Integer.parseInt(req.getParameter("point_"+ret.get(rr))));
        }
		
		
		List<Test> test_result = new ArrayList<>();
		test_result = tDao.filter(entYear,classNum,subject,num,teacher.getSchool());
		int i;
		List<Test> test_resultfin = null;
		for (i=0;i<test_result.size();i++){
			Test one = test_result.get(i);
			for (Integer r:newret){
//				if(test_result.get(i).getNo()==PointFinlist.){
//					PointFinlist.get(test_result.get(i).getNo());
				one.setPoint(PointFinlist.get(test_result.get(i).getNo()));
//				}
				System.out.print("\n"+one);
				
			}
			test_resultfin.add(one);
			System.out.print("\n"+test_resultfin+"\n");
		}
		tDao.save(test_result);
		
		
		/*if(entYear != 0 && classNum != null && subject_cd != null && num != 0){
			
			
			

			
			subject = subjectDao.get(subject_cd, teacher.getSchool());
			test_result = tDao.filter(entYear,classNum,subject,num,teacher.getSchool());
			List<Student> student_data = studentDao.filter(teacher.getSchool(), entYear, classNum,true);
			List<String> no_tf = new ArrayList<>();
			List<Integer> point = new ArrayList<>();
			Map<Integer, String> mapret = new HashMap<>();
			int cntt=0;
			for (Test t : test_result){
				no_tf.add(t.getStudent().getNo());
				point.add(t.getPoint());
				
				
			}
			System.out.println("mapret"+mapret);
			List<String> list = new ArrayList<>();
			for (Test test : test_result){
				list.add(String.valueOf(test_result.get(0).getNo()));
			}
	        //Mapの宣言
	        Map<String, String> map = new HashMap<>();
	        int cnt=0;
	        for(Test t : test_result) {
	            // MapにListのキーと値を追加
	            map.put(test_result.get(cnt).getStudent().getNo(), String.valueOf(test_result.get(cnt).getPoint()));
	            cnt++;
	        }
			req.setAttribute("student_list", student_data);
			req.setAttribute("test_result", test_result);
			req.setAttribute("subject_name", subject.getName());
			req.setAttribute("no_tf", no_tf);
			req.setAttribute("pointlist", point);
			req.setAttribute("newpointlist", map);
			req.getRequestDispatcher("test_regist.jsp").forward(req, res);
*/			
		req.getRequestDispatcher("test_regist_done.jsp").forward(req, res);
		
	}
}
/*Util util = new Util();
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
testDao.save(list);*/