<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tn"%>
<html lang="en" class="">
<head>
<meta charset="UTF-8">

<style class="cp-pen-styles">@import url(https://fonts.googleapis.com/css?family=Roboto:300);</style>

<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css" href="css/runPagestyle.css">

</head>
<body>
<div class="login-page">
	<div class="form">
		<form:form modelAttribute="user" method="POST" action="/LacitTaskManager/reg.html" class="register-form">	
			<c:if test="${not empty email}">
				<div class="alert alert-danger">${email}</div>
			</c:if>	
      		<form:input path="real_name" placeholder="name" />
      		<form:input path="email" placeholder="email address"/>
      		<form:input path="password" placeholder="password"/>
      		<input type="submit" id="reg" value="Create">
      		<p class="message">Already registered? <a href="#">Sign In</a></p>
    	</form:form>
	

		<c:url value="/j_security_check" var="href" />
		<form action="${href}" method="POST" id="loginForm" class="login-form">		
				<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<div class="alert alert-danger"> ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
  			<c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
		</c:if>
			<input type="text"	class="form-control" id="email" name="j_username" value="" placeholder="Email">
			<input type="password" class="form-control" id="passwd" name="j_password" value="" placeholder="password">
			<input type="submit" id="login" value="Login" >
			<p class="message">Not registered? <a href="#">Create an account</a></p>
		</form>
	</div>
</div>
<script src='https://static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js'></script>
<script src='js/jquery.min.js'></script>
<script >$('.message a').click(function () {
   $('form').animate({ height: "toggle", opacity: "toggle" }, "slow");
});
</script>
<script >
</body>
</html>