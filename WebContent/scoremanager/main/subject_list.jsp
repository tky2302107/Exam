<<<<<<< HEAD
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
		<h2 class="h3 mb-3 fw-norma bg-opacity-10 py-2 px-4">科目管理</h2>
		<div class="my-2 text-end px-4">
			<a href ="SubjectCreate.action">新規登録</a>
		</div>
		<c:choose>
			<c:when test="${subject.size()>0 }">
				<table class="table table-hover">
					<tr>
						<th>科目コード</th>
						<th>科目名</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach var="subject" items="${subjects}">
						<tr>
							<td>${subject.cd}</td>
							<td>${subject.name}</td>
							<td><a href="SubjectUpdate.action?no=${subject.no}">変更</a></td>
							<td><a href="SubjectDelete.action?no=${subject.no}">削除</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<div>科目情報が存在しませんでした</div>
			</c:otherwise>
			</c:choose>
		</section>
	</c:param>
</c:import>
=======
<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">得点管理システム - 科目管理</c:param>
</c:import>

<section style="text-align: center;">
    <h2>科目管理</h2>
    <p><a href="subject_create.jsp">新規登録</a></p>
    <!-- ここに科目一覧を表示 -->
</section>

<c:import url="/common/footer.jsp" />
r.jsp" />
=======
>>>>>>> branch 'master' of https://github.com/tky2302107/Exam.git
>>>>>>> branch 'master' of https://github.com/tky2302107/Exam.git
