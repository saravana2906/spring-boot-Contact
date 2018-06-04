<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Sigin Form</title>
<style>
.error
{
color: red;
}
</style>
</head>
<body>
<form:form action="process_login" modelAttribute="signin">

<h3>Sign In</h3>
<div class="error">${error}</div>
<form:input path="userName"/><form:errors path="userName" cssClass="error" /><br>
<form:password path="password" /><form:errors path="password" cssClass="error" /><br>
<input type="submit" value="submit"/>
</form:form>

</body>
</html>