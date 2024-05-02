<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">
        得点管理システム
    </c:param>
    <c:param name="scripts"></c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
            <c:if test="${success}">
                <div class="alert alert-success" role="alert">
                    登録が完了しました
                </div>
            </c:if>
            <form method="get">
                <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                    <div class="col-2">
                        <label class="form-label" for="ent-year-select">入学年度</label>
                        <select class="form-select" id="ent-year-select" name="entYear">
                            <option value="">--------</option>
                            <!-- データベースや変数から入学年度の選択肢を動的に生成する処理を挿入 -->
                        </select>
                    </div>
                    <div class="col-2">
                        <label class="form-label" for="class-select">クラス</label>
                        <select class="form-select" id="class-select" name="class">
                            <option value="">--------</option>
                            <!-- データベースや変数からクラスの選択肢を動的に生成する処理を挿入 -->
                        </select>
                    </div>
                    <div class="col-3">
                        <label class="form-label" for="subject-select">科目</label>
                        <select class="form-select" id="subject-select" name="subject">
                            <option value="">--------</option>
                            <!-- データベースや変数から科目の選択肢を動的に生成する処理を挿入 -->
                        </select>
                    </div>
                    <div class="col-2">
                        <label class="form-label" for="times-select">回数</label>
                        <select class="form-select" id="times-select" name="times">
                            <option value="">--------</option>
                            <c:forEach var="i" begin="1" end="10">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-2 text-center">
                        <button class="btn btn-secondary" id="search-button">検索</button>
                    </div>
                </div>
            </form>
            <c:choose>
                <c:when test="${not empty students}">
                    <div>検索結果 :${students.size()}件</div>
                    <table class="table table-hover">
                        <tr>
                            <th>学生番号</th>
                            <th>氏名</th>
                            <th>得点</th>
                            <th>回数</th>
                            <!-- 追加のカラムをここに追加 -->
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.studentNumber}</td>
                                <td>${student.name}</td>
                                <td>
                                    <input type="number" class="form-control" name="score" value="${student.score}"
                                           <c:if test="${student.score < 0 || student.score > 100}">style="color: yellow;"</c:if>>
                                </td>
                                <td>${student.times}</td>
                                <!-- 追加のカラムに対応するデータをここに追加 -->
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="text-end">
                        <button class="btn btn-primary">保存して終了</button>
                    </div>
                </c:when>
            </c:choose>
        </section>
    </c:param>
</c:import>

