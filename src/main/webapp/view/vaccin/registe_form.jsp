<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp" />

<link href="./res/css/vaccin/vaccin.css" rel="stylesheet">

<jsp:include page="../include/js/vaccin.jsp" />

</head>
<body>

	<jsp:include page="../include/header.jsp" />

	<jsp:include page="../include/nav.jsp" />

	<section>
	
		<div class="section_wrap">
	
		<h1>REGISTE FORM</h1>
		
		
		
		<form
		action="<%= request.getContextPath()%>/injection_registe_confirm.vac"
		method = "POST"
		name = "registe_form">
		
		<input class="basic_input" type = "text" name = "fvp_name" placeholder = "input name">
		<br>
		 <select class="basic_select" name="ss_number">
		 	<option value="">-------선택-------</option>
			<option value="720520-1018547">720520-1******</option>
			<option value="710210-2084561">710210-2******</option>
		 	<option value="941230-1075214">941230-1******</option>
		 	<option value="650215-2050128">650215-2******</option>
			<option value="800710-1025698">800710-1******</option>
		 </select>
		 <br>
		 <input class="basic_input" type="email" name="fvp_mail" placeholder="input mail"> 
		 <br>
		 <input class="basic_input" type="text" name="fvp_phone" placeholder="input phone"> 
		 <br>
		 <select class="basic_select" name="fv_location_no" >
		 <option value="">-------선택-------</option>
		 	<option value="1001">A접종처</option>
		 	<option value="1002">B접종처</option>
		 	<option value="1003">C접종처</option>
		 	<option value="1004">D접종처</option>
		 	<option value="1005">E접종처</option>
		 </select>
		 <br>
		 <select class="basic_select" name="fv_type">
		 <option value="">-------선택-------</option>
		 	<option value="A">A</option>
		 	<option value="B">B</option>
		 	<option value="C">C</option>
		 	<option value="D">D</option>
		 	<option value="E">E</option>
		 </select>
		 <br>
		 <input class="basic_button" type="button" value="REGISTE" onclick="registeForm();">
		 <input class="basic_button" type="reset" value="RESET">
		 
		</form>
		
		</div>
	</section>
	

	<jsp:include page="../include/footer.jsp" />

</body>
</html>