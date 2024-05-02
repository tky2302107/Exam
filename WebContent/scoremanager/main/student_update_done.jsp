<%-- 学生登録JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../../common/base.jsp">
	<c:param name = "title">
		得点管理システム
	</c:param>
	<c:param name = "scriipts">	</c:param>
	<c:param name = "content">
		<section class="mo-4">
		<h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4" style="background-color:#f0f1f2;">学生情報変更</h2>
			<div style="background-color:#8cc3a9;" align=center> 
				<p>変更が完了しました</p>
			</div>
			<br>
			<br>
			<br>
			<br>
			<%@ page import="javax.servlet.http.HttpSession"%>
			<%@ page  import="bean.Teacher" %>
			<% HttpSession sessionjsp = request.getSession();%>
			<% Teacher teacher = (Teacher)sessionjsp.getAttribute("user");%>
			<% request.setAttribute("", teacher); %>
			<div><a href="StudentList.action">学生一覧</a></div><!-- ./student_list.jsp -->
		</section>
	</c:param>
</c:import>