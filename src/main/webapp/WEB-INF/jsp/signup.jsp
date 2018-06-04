<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Signup Form</title>
<style>
.error
{
color: red;
}
</style>
</head>
<body>
<form:form action="process_signup" modelAttribute="signup">
<form:errors path="" cssClass="error" />
<h3>Sign Up Form</h3>
  
 User name: <form:input path="username" id="username" /><form:errors path="username" cssClass="error" /><br>
 
  Email id: <form:input path="emailid" id="emailid" /><form:errors path="emailid" cssClass="error" /><br>
  Phone No: <form:input path="phoneno" id="phone" /><form:errors path="phoneno" cssClass="error" /><br>
  Password: <form:input path="password" id="password" /><form:errors path="password" cssClass="error" /><br>
  Confirm Password: <form:input path="confirmpassword" id="confirmpassword" /><form:errors path="confirmpassword" cssClass="error" />
  <input type="submit" value="submit"/>
</form:form> 
</body>
</html>