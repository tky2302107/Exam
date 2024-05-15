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
		<h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4" style="background-color:#f0f1f2;">学生情報変更</h2>
		<form action="StudentUpdateExecute.action">
			<div class = "row border mx-3 mb-3 py-2 align-items-center rounded" id = "filter">
				<div>
					<label class="form-label" for="student-f1-select">入学年度</label>
					<br>
					<p>　<Input readonly value="${ent_year}"name="ent_year" class="border border-0" style="left:10px;"hidden/>${ent_year}</p>
					<p></p>
					<%-- <%=request.setParameter("",request.getAttribute("ent_year")) %> --%>
					
				</div>
				<div>
				<%-- <% System.out.println(request.getParameter("class_num_set")); %>
				<% System.out.println(request.getParameter("class_num")); %>
				<% System.out.println(request.getParameter("num")); %> --%>
					<label class="form-label" for="student-f2-select">学生番号</label>
					<br>
					<p>　<Input readonly value="${no}" name="no" class="border border-0"hidden/>${no}</p>
					<p></p>
				</div>
				<div>
					<label class="form-label" for="student-f3-select">氏名</label>
					<Input class="form-control" name="name"value="${name}"maxlength="30"required placeholder="氏名を入力してください"></Input>
					
					<%-- <div class="mt-2 text-warning">${errors3.get("name")}</div> --%>
				</div>
				<div>
					<label class="form-label" for="student-f4-select">クラス</label>
					<select class="form-select" id= "student-class_num-select" name="class_num"required>
						<option value="0">--------<option>
						<c:forEach var="num" items="${class_num_set}">
							<%-- 現在のnumと選択されていたclass_numが一致していた場合にselectedを追記 --%>
							<option value="${num}" <c:if test="${num==class_num}">selected</c:if>>${num}</option>
						</c:forEach>
					</select>
					<%-- <div class="mt-2 text-warning">${errors4.get("classNum")}</div> --%>
				</div>
				<div>
					<label class="form-label" >在学中</label>
					<input type="checkbox" name="is_attend" ></input>
				</div>
				
				<div>
					<br>
					<input type="submit" value="変更" class="btn btn-secondary" style="background-color:#0d6efd;">
				</div>
				<br>
				<div><a href="./menu.jsp">戻る</a></div>
			</div>
		</form>
		</section>
	</c:param>
</c:import>