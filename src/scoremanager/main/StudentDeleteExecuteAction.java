package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import tool.Action;

public class StudentDeleteExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		StudentDao sDao = new StudentDao();
		String no = null;
		no = req.getParameter("no");
		Boolean chk = sDao.del(no);
		if (chk == true){
			req.getRequestDispatcher("student_delete_done.jsp").forward(req, res);
		}		
	}
	

}
