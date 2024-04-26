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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報変更</h2>
			<label>科目コード</label>
			<br>
			<label>科目名</label>
			<Input class="form-control" name="no"value="${name}"maxlength="10"required placeholder="科目名を入力してください"></Input>
			<div>
			<button type="submit" style="background-color: blue; color: white; border-radius: 10px; outline: none;">変更</button>
			</div>
			<a href="SubjectList.action">戻る</a>
		</section>
	</c:param>
</c:import>