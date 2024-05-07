package scoremanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Test;

public class TestListSubjectExecuteAction {
    public List<Test> execute(String subject) {
        List<Test> testList = new ArrayList<>();
        // データベース接続情報
        String url = "jdbc:h2:tcp://localhost/~/exam";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM test_scores WHERE subject = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, subject);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String studentId = resultSet.getString("student_id");
                        int score = resultSet.getInt("score");
                        Test test = new Test(studentId, subject, score);
                        testList.add(test);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
        }
        return testList;
    }
}


