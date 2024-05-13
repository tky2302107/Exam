package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();

		SubjectDao sDao = new SubjectDao();

		Subject id = req.getParameter("delete");

		sDao.delete(id);
		req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);

		req.getRequestDispatcher("subject_delete.jsp").forward(req, res);

	}
}