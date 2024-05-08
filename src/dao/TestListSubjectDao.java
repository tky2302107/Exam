package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import bean.School;
import bean.TestListSubject;


public class TestListSubjectDao extends Dao{
	private String baseSql = ""
			+ "select st.ent_year, t.class_num, t.student_no, st.name, t.no, t.point "
			+ "from test as t "
			+ "join student as st on t.student_no = st.no and t.class_num = st.class_num "
			+ "where st.ent_year = ? "
			+ "and t.class_num = ? "
			+ "and t.subject_cd = ?";

	private List<TestListSubject> postfilter(ResultSet rSet)throws Exception{
		List<TestListSubject> list = new ArrayList<>();
		try{
			while(rSet.next()){
				TestListSubject tSubject = new TestListSubject();
				Map<Integer, Integer> point = new HashMap<>();
				tSubject.setEntYear(rSet.getInt("ent_year"));
				tSubject.setStudentNo(rSet.getString("student_no"));
				tSubject.setStudentName(rSet.getString("name"));
				tSubject.setClassNum(rSet.getString("class_num"));
				tSubject.setPoints(point);
				tSubject.putPoit(rSet.getInt("no"), rSet.getInt("point"));
				list.add(tSubject);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<TestListSubject> filter(int entYear,String classNum,
			Subject subject, School school)throws Exception{
		List<TestListSubject> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try{
			statement = connection.prepareStatement(
					baseSql);
			statement.setInt(1, entYear);
			statement.setString(2, classNum);
			statement.setString(3, subject.getCd());
			rSet = statement.executeQuery();
			list = postfilter(rSet);
		}catch (Exception e) {
			throw e;
		}finally {
			// プリペアードステートメントを閉じる
			if (statement !=null) {
				try{
					statement.close();
				}catch (SQLException sqle){
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null){
				try{
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return list;
	}
}

