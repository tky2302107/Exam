package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class ClassNumDao extends Dao{

	public List<String> filter(School schoolname)  throws Exception{
			// 学校インスタンスを初期化
			List<String> list = new ArrayList<>();
			
//			School school = new School();
			// データベースへのコネクションを確率
			Connection connection = getConnection();
			// プリペアードステートメント
			PreparedStatement statement = null;

			try {
				// プリペアードステートメントにSQL文をセット
				statement = connection.prepareStatement("SELECT class_num FROM CLASS_NUM  where school_cd = ? ");
				// プリペアードステートメントに学校コードをバインド
				statement.setString(1, schoolname.getCd());
				// プリペアードステートメントを実行
				ResultSet rSet = statement.executeQuery();

//				if (rSet.next()) {
				while(rSet.next()){
					list.add(rSet.getString("CLASS_NUM"));	
				}

//				} else {
//					// 存在しない場合
//					// nullをセット
//					list = null;
//				}
			} catch (Exception e) {
				throw e;
			} finally {
				// プリペアードステートメントを閉じる
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException sqle) {
						throw sqle;
					}
				}
				// コネクションを閉じる
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException sqle) {
						throw sqle;
					}
				}
			}
			return list;
		}


}
