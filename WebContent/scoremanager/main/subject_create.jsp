<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">得点管理システム - 科目情報登録</c:param>
</c:import>

<section>
    <h2>科目情報登録</h2>
    <form method="post" action="subject_create_done.jsp">
        <label for="subjectCode">科目コード</label>
        <input type="text" id="subjectCode" name="subjectCode" placeholder="科目コードを入力してください">
        <label for="subjectName">科目名</label>
        <input type="text" id="subjectName" name="subjectName" placeholder="科目名を入力してください">
        <!-- エラーメッセージ表示 -->
        <button type="submit">登録</button>
        <a href="subject_list.jsp">戻る</a>
    </form>
</section>
