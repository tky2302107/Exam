package scoremanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Test;

public class TestListAction {
    public List<Test> execute() {
        List<Test> testList = new ArrayList<>();
        // データベース接続情報
        String url = "jdbc:h2:tcp://localhost/~/exam";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM test_scores";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String studentId = resultSet.getString("student_id");
                    String subject = resultSet.getString("subject");
                    int score = resultSet.getInt("score");
                    Test test = new Test(studentId, subject, score);
                    testList.add(test);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
        }
        return testList;
    }
}
