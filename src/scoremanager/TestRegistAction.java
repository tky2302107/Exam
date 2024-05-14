package scoremanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestRegistAction {
    public void execute(String studentId, String subject, int score) {
        // データベース接続情報
        String url = "jdbc:h2:tcp://localhost/~/exam";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO test_scores (student_id, subject, score) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, studentId);
                statement.setString(2, subject);
                statement.setInt(3, score);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーハンドリングを行う
        }
    }
}

