<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">
        得点管理システム
    </c:param>
    <c:param name="scripts"></c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">成績参照</h2>
            <form method="get" action="TestListSubjectExecute.action">
                <div class="border mx-3 mb-3 rounded p-3">
                    <div class="row align-items-center">
                        <div class="col-2">
                            <label class="form-label" for="ent-year-select">入学年度</label>
                            <select class="form-select" id="ent-year-select" name="entYear">
                                <option value="">----------</option>
                                <!-- データベースや変数から入学年度の選択肢を動的に生成する処理を挿入 -->
                            </select>
                        </div>
                        <div class="col-2">
                            <label class="form-label" for="class-select">クラス</label>
                            <select class="form-select" id="class-select" name="class">
                                <option value="">----------</option>
                                <!-- データベースや変数からクラスの選択肢を動的に生成する処理を挿入 -->
                            </select>
                        </div>
                        <div class="col-4">
                            <label class="form-label" for="subject-select">科目</label>
                            <select class="form-select" id="subject-select" name="subject">
                                <option value="">--------------------------</option>
                                <!-- データベースや変数から科目の選択肢を動的に生成する処理を挿入 -->
                            </select>
                        </div>
                        <div class="col-1"></div> <!-- 余白 -->
                        <div class="col-3">
                            <button type="submit" class="btn btn-secondary">検索</button>
                        </div>
                    </div>
                    <hr style="border-style: dashed;">
                    <div class="row align-items-center">
                        <div class="col-5">
                            <input type="text" class="form-control" id="student-no" name="studentNo" placeholder="学生番号を入力してください">
                        </div>
                        <div class="col-1"></div> <!-- 余白 -->
                        <div class="col-3">
                            <button type="submit" class="btn btn-secondary">検索</button>
                        </div>
                    </div>
                </div>
            </form>
            <c:if test="${not empty error}">
                <div class="alert alert-warning mx-3" role="alert">
                    入学年度とクラスと科目を選択してください
                </div>
            </c:if>
            <c:if test="${not empty students}">
                <!-- 成績情報がある場合の表示 -->
            </c:if>
            <c:if test="${empty students && not empty error}">
                <div class="alert alert-warning mx-3" role="alert">
                    学生情報が存在しませんでした
                </div>
            </c:if>
            <div class="text-start text-muted mb-3 mx-3">
                <p style="color: aqua;">科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>
            </div>
        </section>
    </c:param>
</c:import>
