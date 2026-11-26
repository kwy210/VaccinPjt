<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			
			<h1>REGISTED LIST</h1>
			
			<table>
				<thead>
					<tr>
						<th>NO</th>
						<th>NAME</th>
						<th>MAIL</th>
						<th>PHONE</th>
						<th>SS_NUMBER</th>
						<th>SS_NAME</th>
						<th>SS_ADDR</th>
						<th>SS_PHONE</th>
						<th>LOCATION_NO</th>
						<th>LOCATION_NAME</th>
						<th>LOCATION_ADDR</th>
						<th>LOCATION_MANAGER</th>
						<th>TYPE</th>
						<th>TYPE_NO</th>
						<th>TYPE_MANUF_COUNTRY</th>
						<th>TYPE_MANUF_DATE</th>
						<th>REG_DATE</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>NO</td>
						<td>NAME</td>
						<td>MAIL</td>
						<td>PHONE</td>
						<td>SS_NUMBER</td>
						<td>SS_NAME</td>
						<td>SS_ADDR</td>
						<td>SS_PHONE</td>
						<td>LOCATION_NO</td>
						<td>LOCATION_NAME</td>
						<td>LOCATION_ADDR</td>
						<td>LOCATION_MANAGER</td>
						<td>TYPE</td>
						<td>TYPE_NO</td>
						<td>TYPE_MANUF_COUNTRY</td>
						<td>TYPE_MANUF_DATE</td>
						<td>REG_DATE</td>
					</tr>
				</tbody>
			</table>

		</div>
	</section>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>