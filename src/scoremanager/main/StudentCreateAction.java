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
import tool.Action;

public class StudentCreateAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {// ユーザーデータを取得＆セレクトボックス用のクラスデータを取得		
			HttpSession session = req.getSession();
			Teacher teacher = (Teacher)session.getAttribute("user");
			
			req.setAttribute("entYear", 0);
			req.setAttribute("classNum", null);
			req.setAttribute("no", "学生番号を入力してください");
			req.setAttribute("name", "氏名を入力してください");
			
			String entYearStr="";
			String classNum="";
			String no="";
			String name="";
			Integer entYear = 0;
			List<Student> students = null;
			LocalDate todaysDate = LocalDate.now();
			int year = todaysDate.getYear();
			ClassNumDao cNumDao = new ClassNumDao();
			Map<String,String> errors =new HashMap<>();
			
			entYearStr = req.getParameter("ent_year");
			classNum = req.getParameter("class_num");
			no = req.getParameter("no");
			name = req.getParameter("name");
			
			if (entYearStr != null){
				entYear = Integer.parseInt(entYearStr);
			}else{
				entYear = 0;
			}
			
			int chk = 0;
			List<String> list = cNumDao.filter(teacher.getSchool());// クラスの一覧
				if (entYear == 0 ){
					if (chk > 0){
						errors.put("entYear", "入学年度を選択してください");
						req.setAttribute("errors1", errors);
					}else{
						chk += 1;
					}
				}else if (no.equals(null)|| no.equals("")){ 
					errors.put("no", "このフィールドを入力してください");
					req.setAttribute("errors2", errors);
				}else if (name.equals(null) || name.equals("")){
					errors.put("name", "このフィールドを入力してください");
					req.setAttribute("errors3", errors);
				}else if (classNum == "" || classNum.equals(null) || classNum.equals("0")){
					errors.put("classNum", "このフィールドを入力してください");
					req.setAttribute("errors4", errors);
				}else{
					Map<String,String> data = new HashMap<>();
					data.put("no", no);
					data.put("name", name);
					data.put("classNum", classNum);
					data.put("entYear", String.valueOf(entYear));
					
					req.getRequestDispatcher("StudentCreateExecute.action").forward(req, res);
					
					return;
				}
			// 年設定プルダウン
			if (entYearStr != null){
				entYear = Integer.parseInt(entYearStr);
			}
			List<Integer> entYearSet = new ArrayList<>();
			for (int i = year -10 ; i<year+1 ; i++ ){
				entYearSet.add(i);
			}
			
			req.setAttribute("ent_year", entYear);
			req.setAttribute("no", no);
			req.setAttribute("name", name);
			req.setAttribute("class_num", classNum);
			
			req.setAttribute("students", students);
			req.setAttribute("class_num_set", list);
			req.setAttribute("ent_year_set", entYearSet);
			
			req.getRequestDispatcher("student_create.jsp").forward(req, res);
	}
}