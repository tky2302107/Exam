package scoremanager;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import bean.Teacher;
//import dao.TeacherDao;

public class LogoutAction {
//@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		セッションからユーザーデータを削除するプログラムを追加したい
//		
//		
			//ローカル変数の宣言 1
//			String url = "";
//			String id = "";
//			String password = "";
//			TeacherDao teacherDao = new TeacherDao();
//			Teacher teacher = null;

			//リクエストパラメータ―の取得 2
//			id = req.getParameter("id");// 教員ID
//			password = req.getParameter("password");//パスワード

			//DBからデータ取得 3
//			teacher = teacherDao.login(id, password);//教員データ取得

			//ビジネスロジック 4
			//DBへデータ保存 5
			//レスポンス値をセット 6
			//フォワード 7
			//条件で手順4~7の内容が分岐
//			if (teacher != null) {// 認証成功の場合
//				 セッション情報を取得
			
//			HttpSession session = req.getSession(true);
//
//			session.invalidate();// ←セッション破棄
			
			HttpSession session = req.getSession(true);
			if(session != null){
				session.invalidate();
			}
			//リダイレクト
//			req.getRequestDispatcher("login.jsp").forward(req, res);
//			res.sendRedirect("login.jsp");
			
	        RequestDispatcher dispatcher =  req.getRequestDispatcher("scoremanager/login.jsp");
	        dispatcher.forward(req, res);

//			} else {
//				// 認証失敗の場合
//				// エラーメッセージをセット
//				List<String> errors = new ArrayList<>();
//				errors.add("IDまたはパスワードが確認できませんでした");
//				req.setAttribute("errors", errors);
//				// 入力された教員IDをセット
//				req.setAttribute("id", id);
//
//				//フォワード
//				url = "login.jsp";
//				req.getRequestDispatcher("error.jsp").forward(req, res);
//			}

//			req.getRequestDispatcher(url).forward(req, res);
		}
		
		
	}
//}

