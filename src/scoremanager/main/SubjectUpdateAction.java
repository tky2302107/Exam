package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();

		Subject name = req.getParameter("name");
		SubjectDao sDao = new SubjectDao();

		sDao.save(name);
		req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);


		req.getRequestDispatcher("subject_update.jsp").forward(req, res);
	}
}
