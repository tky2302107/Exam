package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		String cd = "";
		String name = "";
		SubjectDao sDao = new SubjectDao();
		Map<String, String> errors = new HashMap<>();

		cd = req.getParameter("cd");
		name = req.getParameter("name");

		if (cd.length() != 3){
			errors.put("f1", "科目コードは3文字で入力してください");
			req.setAttribute("errors", errors);
			req.setAttribute("cd", cd);
			req.setAttribute("name", name);
			req.getRequestDispatcher("subject_create.jsp").forward(req, res);
			return;
		}else{
		try{
			Subject subject = new Subject();
			subject.setCd(cd);
			subject.setName(name);
			subject.setSchool(teacher.getSchool());
			Subject subject2 = new Subject();
			subject2 = sDao.get(cd, teacher.getSchool());
			if(subject2 != null){
				errors.put("f1", "科目コードが重複しています。");
				req.setAttribute("errors", errors);
				req.setAttribute("cd", cd);
				req.setAttribute("name", name);
				req.getRequestDispatcher("subject_create.jsp").forward(req, res);
				return;
			}
			sDao.save(subject);
		}catch (Exception e) {
			throw e;
		}
		req.getRequestDispatcher("subject_create_done.jsp").forward(req, res);
		}
	}
}