<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
<c:param name="title">
		得点管理システム
</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報変更</h2>
				<form method="get" action="SubjectUpdateExecute.action">
					<div class="mx-3">
						<div class="mb-3">
							<label class="form-text-label" for="subject_cd">科目コード</label>
								<input class="border border-0 form-control" type="text" name="cd" id="subject_cd"
											value="${subject.cd}" readonly>
							<div class="mt-2 text-warning">${f1}</div>
						</div>
						<div class="mb-3">
							<label class="form-text-label mb-2"  for="subject_name">科目名</label>
							<input class="form-control" name="name" type="text" id="subject_name"value="${subject.name}"maxlength="20" required>
						</div>
						<div class="mb-3">
							<input class="btn btn-primary" type="submit" id="filter-button" value="変更">
						</div>
						<div><a href="SubjectList.action">戻る</a></div>
					</div>
				</form>
		</section>
	</c:param>
</c:import>