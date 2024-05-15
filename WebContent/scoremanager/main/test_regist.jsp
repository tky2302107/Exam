<%-- 学生一覧JSP --%>
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
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
				<form method="get" action="TestRegist.action">
					<div class="row border mx-3 mb-1 py-2 align-items-center rounded" id="filter">
						<div class="col-10">
							<table class="table table-borderless table-sm">
								<tr class="">
									<th class="col-2 fw-normal">入学年度</th>
									<th class="col-2 fw-normal">クラス</th>
									<th class="col-4 fw-normal">科目</th>
									<th class="col-2 fw-normal">回数</th>
								</tr>
								<tr>
									<td class="">
										<select class="form-select" id="student-f1-select" name="f1">
											<option value="0">--------</option>
											<c:forEach var="year" items="${ent_year_set }">
												<%-- 現在のyearと選択されていたf1が一致した場合selectedを追記 --%>
												<option value="${year}" <c:if test="${year == f1}"> selected </c:if>>${year}</option>
											</c:forEach>
										</select>
									</td>
									<td class="">
										<select class="form-select" id="student-f2-select" name="f2">
											<option value="0">--------</option>
											<c:forEach var="num" items="${class_num_set}">
												<%-- 現在のyearと選択されていたf2が一致した場合selectedを追記 --%>
												<option value="${num}" <c:if test="${num == f2}"> selected</c:if>>${num}</option>
											</c:forEach>
										</select>
									</td>
									<td class="">
										<select class="form-select" id="student-f3-select" name="f3">
											<option value="0">--------</option>
											<c:forEach var="subject" items="${subjects}">
												<%-- 現在のyearと選択されていたf3が一致した場合selectedを追記 --%>
												<option value="${subject.cd}" <c:if test="${subject.cd == f3}" > selected</c:if>>${subject.name}</option>
											</c:forEach>
										</select>
									</td>
									<td class="">
										<select class="form-select" id="student-f4-select" name="f4">
											<option value="0">--------</option>
											<c:forEach var="num" items="${num_set}">
												<%-- 現在のyearと選択されていたf4が一致した場合selectedを追記 --%>
												<option value="${num}" <c:if test="${num == f4}">selected</c:if>>${num}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
							</table>
						</div>
						<div class="col-2 text-center">
							<button class="btn btn-secondary" id="filter-button">検索</button>
						</div>
						<div class="mt-2 text-warning">${error}</div>
					</div>
				</form>
		</section>
		<script>
				function validateInput(input) {
				    var value = input.value.trim(); // 入力値から前後の空白を除去する
				    var message = input.nextElementSibling; // メッセージを表示するための兄弟要素を取得する

				    if ((value === "") || (!isNaN(parseInt(value)) && parseInt(value) >= 0 && parseInt(value) <= 100)) {
				        message.textContent = ""; // 入力が空白または0～100の範囲内の場合はメッセージをクリアする
				    } else {
				        message.textContent = "0～100の範囲で入力してください"; // それ以外の場合はエラーメッセージを表示する
				    }
				}
		</script>
		
		<c:choose>
			<c:when test="${subject.size()>0 }">
				<div>科目：{subject_name}</div>
				<div>検索結果：${subject.size() }件</div>
				<table class="table table-hover">
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>学生番号</th>
						<th>氏名</th>
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
							<td><input name="point_${学生番号}"></td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
					<input type="submit" value="登録して終了" class="btn btn-secondary">
			</c:when>
			<c:otherwise>
				<div>成績情報が存在しませんでした</div>
			</c:otherwise>			
		</c:choose>
		
	</c:param>
</c:import>