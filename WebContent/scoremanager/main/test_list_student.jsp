<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../../common/base.jsp">
	<c:param name = "title">
		得点管理システム
	</c:param>
	<c:param name = "scriipts">	</c:param>
	<c:param name = "content">
		<section class="me-4">
		<h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4" style="background-color:#f0f1f2;">成績参照（科目）</h2>
		<form method="get" action="TestListSubjectExecute.action">
			<div class = "row border mx-3 mb-3 py-2 align-items-center rounded" id = "filter">
				<div class="col-4" style="width:15%;">科目情報</div>
				<div class="col-4" style="width:15%;">
					<label class="form-label" for="student-f1-select">入学年度</label>
					<select class="form-select" id = "student-f1-select" name="f1">
						<option value="0">--------</option>
						<c:forEach var="year" items="${ent_year_set}">
							<%-- 現在のyearと選択されていたf1が一致していた場合にselectedを追記 --%>
							<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-4" style="width:15%;">
					<label class="form-label"  for="student-f2-select">クラス</label>
					<select class="form-select"  id="student-f3-select"  name="f2">
						<option value="0">--------<option>
						<c:forEach var="num" items="${class_num_set}">
							<%-- 現在のnumと選択されていたf2が一致していた場合にselectedを追記 --%>
							<option value="${num}"<c:if test="${num==f2}">selected</c:if>>${num}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-4" style="width:30%;">
					<label class="form-label"  for="student-f2-select">科目</label>
					<select class="form-select"  id="student-f3-select"  name="f3">
						<option value="0">--------<option>
						<%-- <c:forEach var="num" items="${subjects}"> --%>
							<%-- <%-- 現在のnumと選択されていたf2が一致していた場合にselectedを追記 --%>
						<%@page import="bean.Subject, java.util.List" %>
						<% List<Subject> list=(List<Subject>)request.getAttribute("subjects");%>
							<%for (Subject s : list){ %>
								<option value="<%=s.getName()%>"><%=s.getName()%></option>
						<%}%>
							<%-- <option value="${subject.cd}"<c:if test="${subject_name==f3}">selected</c:if>>${subject_name}</option> --%>
						<%-- </c:forEach> --%>
					</select>
					
				</div>
				<div class="col-4" style="width:20%;">
					<button class="btn btn-secondary" id="filter-button" onClick="TestListSubjectExecute.action">検索</button>
				</div>
				<div>
					<Input value="${sj}" name="f" hidden></Input>
				</div>
			
			<div class="mt-2 text-warning">${errors.get("subjectError")}</div>
			</div>
			</form>
			<form method="get" action="TestListStudentExecute.action">
			<div class = "row border mx-3 mb-3 py-2 align-items-center rounded" id = "filter">
				<div class="col-4" style="width:15%;">学生情報</div>
				<div class="col-4" style="width:30%;">
					<label class="form-label" for="student-f1-select">学生情報</label>
					<Input value="${f4}" name="f4" class="form-control" placeholder="学生番号を入力してください"required></Input>
				</div>
				<div class="col-4" style="width:20%;">
					<button class="btn btn-secondary" id="filter-button" onClick="TestListStudentExecute.action">検索</button>
				</div>
				<div>
					<Input value="${st}" name="f" hidden></Input>
				</div>
				
			</div>
		</form>
		<!-- <p style="color:#18cbff;">科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p> -->
		
		<c:choose>
			<c:when test="${subject.size()>0 }">
				<c:when test='${student.f="sj"}'>
					<div>科目：{subject_name}</div>
					<div>検索結果：${subject.size() }件</div>
					<table class="table table-hover">
						<tr>
							<th>入学年度</th>
							<th>クラス</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>1回</th>
							<th>2回</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach var="student" items="${students}">
							<tr>
								<td>${student.entYear}</td>
								<td>${student.classNum}</td>
								<td>${student.no}</td>
								<td>${student.Name}</td>
								<td>${once}</td>
								<td>${twice}</td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<div>氏名：${student_name}(${student_no})</div>
					<div>検索結果：${student.size() }件</div>
					<table class="table table-hover">
						<tr>
							<th>科目名</th>
							<th>科目コード</th>
							<th>回数</th>
							<th>点数</th>
							<th></th>
							<th></th>
						</tr>
					<c:forEach var="student" items="${students}">
						<tr>
							<td>${student.entYear}</td>
							<td>${student.classNum}</td>
							<td>${student.no}</td>
							<td>${student.Name}</td>
							<td><input name="point_${学生番号}">${point}</input></td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
					</table>
				</c:otherwise>
			</c:when>
			<c:otherwise>
				<div>学生情報が存在しませんでした</div>
			</c:otherwise>
		</c:choose>
		</section>		
	</c:param>
</c:import>
