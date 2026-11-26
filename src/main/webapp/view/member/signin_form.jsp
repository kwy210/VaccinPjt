<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp" />

<link href="./res/css/member/member.css" rel="stylesheet" type="text/css">

<jsp:include page="../include/js/member.jsp" />

</head>
<body>

	<jsp:include page="../include/header.jsp" />

	<jsp:include page="../include/nav.jsp" />

	<section >
	<div class="section_wrap">
	
		<h1>SIGNIN FORM</h1>
		
		<form 
		action="<%=request.getContextPath()%>/signin_confirm.mem"
		 method="POST" 
		 name="signin_form">
		
		<input class="basic_input" type="text" name="admin_id" placeholder="Input admin ID">
				<br>
				<input class="basic_input" type="password" name="admin_pw" placeholder="Input new admin PW">
				<br>
			<input class="basic_button" type="button"value="SIGN IN" onclick="signinForm();">
				<input class="basic_button" type="reset" value="RESET">
			</form>
		
		
		
	</div>
	</section>

	<jsp:include page="../include/footer.jsp" />

</body>
</html>