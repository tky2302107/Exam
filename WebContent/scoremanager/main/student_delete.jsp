<%-- 学生登録JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../../common/base.jsp">
	<c:param name = "title">
		得点管理システム
	</c:param>
	<c:param name = "scripts">	</c:param>
	<c:param name = "content">
		<section class="mo-4">
		<h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4" style="background-color:#f0f1f2;">学生情報削除</h2>
		<form action="StudentDeleteExecute.action">
			<div class = "row border mx-3 mb-3 py-2 align-items-center rounded" id = "filter">
				<div>
					<label class="form-label" for="student-f2-select">入学年度</label>
					<Input readonly value="${ent_year}"name="ent_year" class="form-control"></Input>
					
					<%-- <%=request.setParameter("",request.getAttribute("ent_year")) %> --%>
					
				</div>
				<div>
					<label class="form-label" for="student-f2-select">学生番号</label>
					<Input readonly value="${no}" name="no" class="form-control"></Input>
					
				</div>
				<div>
					<label class="form-label" for="student-f2-select">氏名</label>
					<Input class="form-control" name="name"value="${name}"maxlength="30"required readonly></Input>
					
					<%-- <div class="mt-2 text-warning">${errors3.get("name")}</div> --%>
				</div>
				<%-- <div>
					<label class="form-label" for="student-f2-select">クラス</label>
					<Input class="form-control" name="name"value="${class}"maxlength="30"required readonly></Input>
				</div> --%>
				
				<div>
					<br>
					<input type="submit" value="削除" class="btn btn-secondary">
				</div>
				<br>
				<div><a href="./menu.jsp">戻る</a></div>
			</div>
		</form>
		</section>
	</c:param>
</c:import>