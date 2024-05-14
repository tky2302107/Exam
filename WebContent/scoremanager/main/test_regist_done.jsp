<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">
        得点管理システム
    </c:param>
    <c:param name="scripts"></c:param>
    <c:param name="content">
        <section class="me-4">
            <div class="header-container">
                <h2 class="h3 mb-3 fw-normal bg-success bg-opacity-50 py-2 px-5" style="text-align: center;">登録が完了しました。</h2>
            </div>
            <div class="text-center mb-4">
                <a href="test_regist.jsp" class="btn btn-primary">戻る</a>
                <a href="test_list.jsp" class="btn btn-secondary">成績参照</a>
            </div>
        </section>
    </c:param>
</c:import>
