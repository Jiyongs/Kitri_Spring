<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/template/header.jsp" %>

 <script type="text/javascript">

 $(document).ready(function() {

	 memberList('', ''); // 처음 로딩될 때, 검색 내용 초기화
	 
	 // id=searchBtn 버튼의 클릭 이벤트 지정
	$("#searchBtn").click(function () {
		var key = $("#key").val();
		var word = $("#word").val();
		
		$("#word").val(''); //검색내용 초기화
		
		memberList(key, word);
	});
	 
 });
 
 function memberList(key, word) {
	 
	 $("#mlist").empty();
	 
	 $.ajax({
			url:"${root}/admin/memberlist.kitri",
			type:"get",	
			dataType:"json",
			data: {"key" : key, "word" : word},  //#key : document.getElementId / .key : document.getElementClass
			timeout : 30000,
			cache:false,
			success:function(json){	// 성공  (AdminController에게 XML을 정상적으로 받았을 경우!)
				
				var list = json.memberlist;
				var len = list.length;
								
				for(var i = 0; i < len; i++) {
				
					var id = list[i].id;
					var name = list[i].name;
					var email = list[i].emailId + "@" + list[i].emailDomain;
					var tel = list[i].tel1 + " - " + list[i].tel2 + " - " + list[i].tel3;
					var address = list[i].zipcode + " " + list[i].address;
					var joindate = list[i].joindate;
					
					// **jquery 특징 - 체이닝**
					// : $("<td>").html(title). ... .으로 연결해서 계속 사용 가능
					
					var tr = $("<tr>").attr("class", "table-active");     //<tr></tr>생성.속성세팅
					var td1 = $("<td>").html(id);  //<td></td>생성.html로id값넣기
					var td2 = $("<td>").html(name);
					var td3 = $("<td>").html(email);
					var td4 = $("<td>").html(tel);
					var td5 = $("<td>").html(address);
					var td6 = $("<td>").html(joindate);
	
					tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6); //<tr>안에 <td>들이 다 들어감
					$("#mlist").append(tr); //id=mlist인 요소안에 tr넣기
				}
			}
			
		});
 }
 
 </script>
    
<div class="table-responsive-lg">
  <h2>회원목록</h2>
  <table class="table">
  	<tr>
  		<td>
  			<form class="form-inline" action="">
			  <select class="form-control" id="key" name="key">
					<option value="id">아이디</option>
					<option value="tel3">전화번호 뒷자리</option>
					<option value="address">주소</option>
				</select>
			  <input type="text" class="form-control" id="word" name="word">
			  <button type="button" id="searchBtn" class="btn btn-primary">검색</button>
			</form>
  		</td>
  	</tr>
  </table>
  <table class="table">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>주소</th>
        <th>가입일</th>
      </tr>
    </thead>
    <tbody id="mlist"></tbody>
  </table>
</div>

<%@ include file = "/WEB-INF/views/template/footer.jsp" %>