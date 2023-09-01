<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
         <a class="btn btn-outline-warning" href="/board/update?no=${vo.no}">수정</a>
        <a href="/board/delete?no=${vo.no}" class="btn btn-outline-danger" >삭제</a>
        <a href="/board/list" class="btn btn-outline-warning">목록</a>
      </form>
    </div>
  </body>
</html>