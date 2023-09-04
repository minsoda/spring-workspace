<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html data-bs-theme="dark">
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <style>
      h1 {
        margin-top: 70px;
      }
      .form-group {
        margin: 20px 0;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>게시글 정보</h1>
      <form>
      <input type="hidden" name="no" value="${vo.no}">
        <div class="form-group">
          <label for="title">Title</label>
          <input type="text" name="title" id="title" readonly value="${vo.title}" class="form-control" />
        </div>
        <div class="form-group">
          <label for="content">Content</label>
          <textarea
            name="content"
            id="content"
            class="form-control"
            cols="30"
            rows="10"
            style="resize: none"
            readonly
          >${vo.content}</textarea>
        <!-- 두가지 방법이 있당 a 태그의 속성중에 download로 해도된당 <a href="/board/download?filename=${fn:replace(vo.url, '/upload/', '')}"><img src="${vo.url}"/></a>  --> 
        	<a href="${vo.url}" download><img src="${vo.url}"/></a>
        
        </div>
        <!-- textarea의 공백까지 포함이 되기 때문에  >${vo.content}</textarea> 붙여서 작성해야함 -->
        <div class="form-group">
          <label for="writer">Writer</label>
          <input type="text" readonly value="${vo.writer} "id="writer" name="writer" class="form-control" />
        </div>
        
        <!-- 쓰고자하는 변수명 var  로그인한 정보 가져오기.-->
        <!-- info와 wirter 비교했을시 일치했을때 수정 삭제 가능 -->
        <sec:authentication property="principal" var="info"/>
        <c:if test="${vo.writer eq info.username}">
        	<a class="btn btn-outline-warning" href="/board/update?no=${vo.no}">수정</a>
        	<a class="btn btn-outline-danger" href="/board/delete?no=${vo.no}">삭제</a>
        	<a href="/board/list" class="btn btn-outline-warning">목록</a>
      </c:if>
      </form>
    </div>
  </body>
</html>