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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>
			<label class="form-label" for="subject-f2-select">科目コード</label>
			<Input class="form-control" name="no"value="${cd}"maxlength="10"required placeholder="科目コードを入力してください"></Input>
			<label class="form-label" for="subject-f2-select">科目名</label>
			<Input class="form-control" name="no"value="${name}"maxlength="10"required placeholder="科目名を入力してください"></Input>
			<div>
			<button type="submit" style="background-color: blue; color: white; border-radius: 10px; outline: none;">登録</button>
			</div>
			<div><a href="./menu.jsp">戻る</a></div>
		</section>
	</c:param>
</c:import>