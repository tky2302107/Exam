package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;

public class SubjectCreateAction extends HttpServlet{
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		req.setAttribute("cd","科目コードを入力してください");
		req.setAttribute("name","科目名を入力してください");

		String cd="";
		String name="";
		Subject subject = new Subject();
		SubjectDao sDao = new SubjectDao();
		Map<String,String> errors =new HashMap<>();

		cd = req.getParameter("cd");
		name = req.getParameter("name");

		if(cd.equals(null) || cd.equals("")){
			errors.put("cd", "このフィールドを入力してください");
			req.setAttribute("errors1", errors);
		}else if(cd.length()>=4 || cd.length()<=2){
			errors.put("cd", "科目コードは３文字にしてください");
			req.setAttribute("errors2", errors);
		}else if(name.equals(null) || cd.equals("")){
			errors.put("name", "このフィールドを入力してください");
			req.setAttribute("errors3", errors);
		}else{
			try{
				if(subject.getCd()==cd){
					errors.put("duplication", "学生番号が重複しています");
					System.out.println("e01");
					req.setAttribute("errors4", errors);
				}else{
					subject.setCd(cd);
					subject.setName(name);
					subject.setSchool(teacher.getSchool());
					sDao.save(subject);
					req.getRequestDispatcher("subject_create_done.jsp").forward(req, res);
				}
			}catch (NullPointerException e){
				subject.setCd(cd);
				subject.setName(name);
				subject.setSchool(teacher.getSchool());
				sDao.save(subject);
				req.getRequestDispatcher("subject_create_done.jsp").forward(req, res);
			}
		}
		req.setAttribute("cd", cd);
		req.setAttribute("name", name);

		req.getRequestDispatcher("subject_create.jsp").forward(req, res);
	}

}
