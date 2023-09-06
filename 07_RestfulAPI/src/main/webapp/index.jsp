<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
  </head>
  <body>
    <h1>휴대전화 목록</h1>
    <table border="1">
      <thead>
        <tr>
          <th>모델번호</th>
          <th>모델이름</th>
          <th>가격</th>
          <th>제조사명</th>
        </tr>
      </thead>
      <tbody id="list"></tbody>
    </table>

	<h1> 휴대전화 정보 </h1>
	<form id="phoneFrm">
		모델 번호 :  <input type="text" name="num" id="num"><br>
		모델 명 : <input type="text" name="model" id="model"><br>
		가격 : <input type="text" name="price" id="price"><br>
		제조사 : <select id="vcode" name="vcode">
			<option value="10">삼성</option>
			<option value="20">애플</option>
		</select>
		<br>
		<input type="button" value="추가하기" id="insert">
		<input type="button" value="수정하기" id="update">
		<input type="button" value="삭제하기" id="delete">
	</form>

    <script>
   
      function list() {
        $.ajax({
          url: "http://localhost:8080/api/phone", // 데이터를 가져올 경로 설정
          type: "get", // 데이터를 가져오는 방식
          success: function (data) { // 데이터를 가져왔을때 동작. 매개변수로 data 입력
            console.log(data);
			let html = '';

			for(let phone of data){
				html +=  
              "<tr>" + 
                  "<td class=num>" + phone.num + "</td>" 
                  + "<td>" + phone.model + "</td>" 
                  + "<td>" + phone.price + "</td>" 
                  + "<td>" + phone.company.vendor + "</td>" 
                  + "</tr>";
			}

           $("#list").append(html);  // append: 셀렉터 안에 요소를 추가
              	
		},
          error: function () {
            console.log("시스템 상 에러 발생!");
          },
        });
      }
      
      list(); //호출하기
      
      // 전체 조회
      $('#list').on('click', '.num', function(){
			console.log($(this).text()); // 클릭되는 모델번호의 값 확인.
    	  $.ajax({
    		  url: "http://localhost:8080/api/phone/" + $(this).text(),
    		  type : 'get',
    		  success:function(data){
    		
    			 console.log(data.model); // 클릭시 모델명 들어오는것 확인.
    			 
    			 $('#num').val(data.num);
    			 $('#model').val(data.model);
    			 $('#price').val(data.price);
    			 $('#vcode').val(data.vcode);
    			 $('#vendor').val(data.company.vendor);
    		  }
    	  });
      });
      
      // 추가
      $('#insert').on('click',function(){
    	  //json 방식으로 전달
    	  let phone = {
    			  num: $('#num').val(),
    			  model: $('#model').val(),
    			  price: $('#price').val(),
    			  vcode: $('#vcode').val()
    	  };
    	  
    	  $.ajax({
    		  url: "http://localhost:8080/api/phone",
    		  type : "post",
    		  data : JSON.stringify(phone),
    		  contentType: 'application/json',
    		  success : function(){
    			  $('#list').html(''); //비워줘야함
    			 list();
    		  }
    	  });
      });
      
      // 수정
      $('#update').on('click', function(){
    	
    	  //json 방식으로 전달
    	  let phone = {
    			  num: $('#num').val(),
    			  model: $('#model').val(),
    			  price: $('#price').val(),
    			  vcode: $('#vcode').val()
    	  };
    	  
    	  $.ajax({
    		  url: "http://localhost:8080/api/phone/",
    		  type : "put",
    		  data : JSON.stringify(phone),
    		  contentType: 'application/json',
    		  success : function(data){
    			
    		  }
    	  
      });
      });
      
   	 // 삭제
      $('#delete').on('click', function(){
    	  
    	  $.ajax({
    		  url: "http://localhost:8080/api/phone/" + $('#num').val(),
    		  type : 'delete',
    		  success:function(data){
    			  $('#list').html('');
    			  list();
    		 	$('#num').val("");
    		 	$('#model').val("");
    		 	$('#price').val("");
    		 	$('#vcode').val("");
    		 
    		  }
    	  });
    	  console.log( $('#num').val()); // 모델번호 확인 가능
      });
    </script>
  </body>
</html>
