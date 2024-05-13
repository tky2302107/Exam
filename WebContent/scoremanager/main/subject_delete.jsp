<%-- ログアウトJSP --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報削除</h2>
			<p>「」を削除してもよろしいですか</p>
			<div>
			<button type="submit" style="background-color: red; color: white; border-radius: 10px; outline: none;">削除</button>
			</div>
			<a href="SubjectList.action">戻る</a>
		</section>
	</c:param>
</c:import>