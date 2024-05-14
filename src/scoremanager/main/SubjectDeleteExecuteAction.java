package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
import tool.Util;

public class SubjectDeleteExecuteAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res)throws Exception {

		Util util = new Util();
		Teacher teacher = util.getUser(req);
		School school = new School();
		school = teacher.getSchool();
		String cd = req.getParameter("cd");
		SubjectDao sDao = new SubjectDao();
		Subject subject = sDao.get(cd, school);
		sDao.delete(subject);

		req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);
	}

}