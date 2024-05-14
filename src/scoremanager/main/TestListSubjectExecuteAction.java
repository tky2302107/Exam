package scoremanager.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import bean.Test;

public class TestListSubjectExecuteAction {
	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws Exception {// ユーザーデータを取得＆セレクトボックス用のクラスデータを取得

    	Subject subject = new Subject();
        List<Test> testList = new ArrayList<>();
        // データベース接続情報
        String url = "jdbc:h2:tcp://localhost/~/exam";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM test_scores WHERE subject = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, subject.getName());
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String studentId = resultSet.getString("student_id");
                        int score = resultSet.getInt("score");
                        Test test = new Test(studentId, subject.getName(), score);
                        testList.add(test);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
        }
//        return testList;
        req.setAttribute("subject", subject);
        req.getRequestDispatcher("test_list_student.jsp").forward(req, res);
    }
}


