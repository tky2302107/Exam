<%-- 学生情報登録	JSP --%>
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
				<form method="get" action="SubjectCreateExecute.action">
					<div class="mx-3">
						<div class="mb-3">
							<label class="form-text-lavel" for="subject_cd">科目コード</label>
							<input class="form-control" name="cd" type="text"
									placeholder="科目コードを入力してください" value="${cd}"
										maxlength="3" id="subject_cd" required />
							<c:if test="${not empty errors}">
								<p class="mt-2 text-warning">${errors.get("f1")}</p>
							</c:if>
						</div>
						<div class="mb-3">
							<label class="form-text-label mb-2" for="subject_name">科目名</label>
							<input class="form-control" name="name" type="text" id="subject_name"
									placeholder="科目名を入力してください" value="${name}"
										maxlength="20" required />
						</div>
						<div class="mb-3">
							<input type="submit" class="btn btn-primary" value="登録">
						</div>
						<div><a href="SubjectList.action">戻る</a></div>
					</div>
				</form>
		</section>
	</c:param>
</c:import>