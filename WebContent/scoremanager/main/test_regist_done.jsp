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
			<h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4" style="background-color:#f0f1f2;">成績管理</h2>
			<div style="background-color:#8cc3a9;" align=center>
				<p>登録が完了しました</p>
			</div>
			&nbsp;
			&nbsp;
			&nbsp;
			&nbsp;
			<div style='float:left;'>
				<a href="TestRegist.action">戻る</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="TestList.action">成績参照</a>
			</div>
			
		</section>
	</c:param>
</c:import>