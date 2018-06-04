<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Contacts</title>
<script>
function selectRow(x) {
	   // alert("Row index is: " + x.rowIndex);
	    var con=x.getElementsByTagName('input')[0];
	    console.log("Value of hidden :"+ con.getAttribute('value'));
	    
	    var con_id=document.getElementById('contactid');
	    con_id.setAttribute('value',con.getAttribute('value'));
	    console.log(con_id.getAttribute('value'));
	  //  document.getElementById("edit_contact").submit();
	}
	
	function submitAction( button) 
	{
		var txt=button.innerHTML;
		var form=document.getElementById("multiform");
		if(txt.indexOf("Update")>-1)
			{
			form.setAttribute('action','edit_contact');
			form.submit();
			}
		else if(txt.indexOf("Delete")>-1)
			{
			form.setAttribute('action','delete_contact');
			form.submit();
			}
		else
			{
			console.log("Not Valid input");
			}
		console.log(txt);
	
	}

</script>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
	
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}


#contents {
    text-align:center; // needed if you expect IE 5
	
}

.centered {
    margin:100px auto; // this sets left/right margin to auto and
                     // centers the element
}
a:hover
{
 text-decoration: underline;
font-color: blue;
}
</style>
</head>
<body>
<div id="contents">
<form  id="multiform">
<input type="hidden" name="contactid" id="contactid" value="">
</form>
<button type="button" onclick="submitAction(this)" value="update">Update</button>
<button type="button" onclick="submitAction(this)" value="delete">Delete</button>
<table class="centered">
<tr>
<th>contact name</th>
<th>Email Id</th>
<th>Phone Number</th>
</tr>

    <c:forEach items="${clist}" var="con">
    
    <tr onclick="selectRow(this)">
<input type="hidden" name="id" value= ${con.key } />
<td rowspan= ${fn:length(con.value.phList)} ><input type="hidden" name="contact_id" value= ${con.key} /> ${con.value.name}</td>
<td rowspan= ${fn:length(con.value.phList)}> ${con.value.emailId}</td>
<c:forEach items="${con.value.phList}" var="phone" varStatus="loop">

<c:if test="${!loop.last}">
<td>${phone}</td>
</tr>
</c:if>
<c:if test="${loop.last}">
<tr>
<td>${phone}</td>
</tr>
</c:if>
</c:forEach>

  </c:forEach>

</table>

<a href="home">Back</a>
</div>
</body>
</html>