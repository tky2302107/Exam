package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;
import tool.Util;

public class SubjectUpdateAction extends Action{

	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception {

		String cd = "";
		cd = req.getParameter("cd");
		Subject subject = new Subject();
		SubjectDao sDao = new SubjectDao();
		Util util = new Util();
		Teacher teacher = util.getUser(req);

		subject = sDao.get(cd, teacher.getSchool());

		req.setAttribute("subject", subject);

		req.getRequestDispatcher("subject_update.jsp").forward(req, res);

	}

}