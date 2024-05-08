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
		<h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4" style="background-color:#f0f1f2;">学生情報登録</h2>
		<form method="get">
			<div class = "row border mx-3 mb-3 py-2 align-items-center rounded" id = "filter">
				<div >
					<label class="form-label" for="student-f1-select">入学年度</label>
					<select class="form-select" id = "student-ent_year-select" name="ent_year"required>
						<option value="0">--------</option>
						<c:forEach var="year" items="${ent_year_set}">
							<%-- 現在のyearと選択されていたent_yearが一致していた場合にselectedを追記 --%>
							<option value="${year}" <c:if test="${year==ent_year}">selected</c:if>>${year}</option>
						</c:forEach>
					</select>
					<div class="mt-2 text-warning">${errors1.get("entYear")}</div>
				</div>
				<div >
					<label class="form-label" for="student-f2-select">学生番号</label>
					<Input class="form-control" name="no"value="${no}"maxlength="10"required placeholder="学生番号を入力してください"></Input>
					<%-- <div class="mt-2 text-warning">${errors2.get("no")}</div> --%>
					<div class="mt-2 text-warning">${errors5.get("duplication")}</div>
				</div>
				<div >
					<label class="form-label" for="student-f2-select">氏名</label>
					<Input class="form-control" name="name"value="${name}"maxlength="30"required placeholder="氏名を入力してください"></Input>
					<%-- <div class="mt-2 text-warning">${errors3.get("name")}</div> --%>
				</div>
				<div >
					<label class="form-label" for="student-f3-select">クラス</label>
					<select class="form-select" id= "student-class_num-select" name="class_num"required>
						<option value="0">--------<option>
						<c:forEach var="num" items="${class_num_set}">
							<%-- 現在のnumと選択されていたclass_numが一致していた場合にselectedを追記 --%>
							<option value="${num}" <c:if test="${num==class_num}">selected</c:if>>${num}</option>
						</c:forEach>
					</select>
					<%-- <div class="mt-2 text-warning">${errors4.get("classNum")}</div> --%>
				</div>
				<br>
				<div>
<<<<<<< HEAD
					<button class="btn btn-secondary" id="filter-button" name="end" >登録して終了</button>
=======
					<br>
					<button class="btn btn-secondary" id="filter-button" name="end" style="background-color:#0d6efd;">変更</button>
>>>>>>> branch 'master' of https://github.com/tky2302107/Exam.git
				</div>
				<br>
				<div><a href="./menu.jsp">戻る</a></div>
			</div>
		</form>
		</section>
	</c:param>
</c:import>