package bean;

import java.io.Serializable;

public class TestListSubject implements Serializable{
	private int entYear;
	private String studentNo;
	private String studentName;
	private String classNum;
//	private Map<integer,integer> points = new HashMap<>();

	public int getEntYear(){
		return entYear;
	}
	public void setEntYear(int entYear){
		this.entYear = entYear;
	}
	public String getStudentNo(){
		return studentNo;
	}
	public void setStudentNo(String studentNo){
		this.studentNo = studentNo;
	}
	public String getStudentName(){
		return studentName;
	}
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	public String getClassNum(){
		return classNum;
	}
	public void setClassNum(String classNum){
		this.classNum = classNum;
	}
}
