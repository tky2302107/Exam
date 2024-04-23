<%-- ログアウトJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
		得点管理システム
	</c:param>

<%-- 	<c:param name="scripts">
		<script type="text/javascript">
			$(function() {
				// 「パスワードを表示」が変更された時の処理
				$('#password-display').change(function() {
					if ($(this).prop('checked')) {
						// チェックが入っている場合
						// パスワード入力欄をテキストにする
						$('#password-input').attr('type', 'text');
					} else {
						// チェックが外れている場合
						// パスワード入力欄をパスワードにする
						$('#password-input').attr('type', 'password');
					}
				});
			});
		</script>
	</c:param> --%>

	<c:param name="content">
		<section class="w-75 text-center m-auto border pb-3">
			<form action = "LoginExecute.action" method="post">
				<div id="wrap_box">
					<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2">ログアウト</h2>
					<p class="text-center">ログアウトしました</p>
					<br>
					<a href="login.jsp">ログイン</a>
				</div>
			</form>
		</section>
	</c:param>
</c:import>