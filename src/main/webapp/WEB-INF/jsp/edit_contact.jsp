<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Contact</title>
<style>
body {
    width: 100%;
}
fieldset {
position: block ;
  height: 50%;
  width: 50%;
  background: #ffffff;

  margin-left: 300px;
  margin-top: 100px;
  text-align: center;
}
fieldset input {
  text-align: center;
  margin: 10px 10px 10px 10px;
  }
   #content
  {
  position: block ;
  text-align: center;
  margin-top: 10px;
  } 
  #btn-grp
  {
  text-align: center;
  margin: 10px 10px 10px 50px;
  }
</style>
<script>
function addRow()
{
	var x=document.getElementById('phonebook');
	var x1=document.getElementById('dummy');
	x.setAttribute('style',"display: block;");
    var new_row = x1.rows[0].cloneNode(true);
    
 var inp1 = new_row.cells[0].getElementsByTagName('input')[0];
 inp1.value = '';
 var inp2 = new_row.cells[1].getElementsByTagName('button')[0];
 inp2.innerHTML="-1";
 inp2.onclick = function() { deleteRow(inp2); };
 x.appendChild( new_row );
	
	}
	
	function deleteRow(row)
	{
		var i = row.parentNode.parentNode.rowIndex;
		var x=document.getElementById('phonebook');
		  document.getElementById('phonebook').deleteRow(i);
		  if(x.rows.length==1)
		  {
		  x.setAttribute('style',"display: none;");
		  }
		
	}
	function submitform()
	{
		var x=document.getElementById('update_contact');
		var tab=document.getElementById('phonebook');
		for(var i=1;i<tab.rows.length;i++)
			{
			var row=tab.rows[i];
			console.log("iteration :"+i)
			var inp1 = row.cells[0].getElementsByTagName('input')[0];
			inp1.name="phonenumber["+(i-1)+"]";
			}
			console.log("hi");
		x.submit();
	//	window.close();
	}
	
	function updatephone(action)
	{
	 var update_phone=document.getElementById('update_phone_form');
	 
	 if(action.innerHTML.indexOf('delete')>-1)
	 {
	 update_phone.setAttribute('action','delete_phone');
	 }
	 else if(action.innerHTML.indexOf('update')>-1)
	 {
	 update_phone.setAttribute('action','update_phone');
	 }
	 else{
	 console.log('No action');
	 }
 var form_phoneid=update_phone.getElementsByTagName('input')[1];
 var form_phoneno=update_phone.getElementsByTagName('input')[2];
	var radios = document.getElementsByName('phone_id');
	var count=0;

for (var i = 0, length = radios.length; i < length; i++)
{

 if (radios[i].checked)
 {
  // do whatever you want with the checked radio
  count=i;
  console.log(radios[i].value);
  form_phoneid.setAttribute('value',radios[i].value);

  // only one radio can be logically checked, don't check the rest
  break;
 }
 }
 console.log('waiting 1');
 
 var tab=document.getElementById('presentbook');
	var tmp=tab.rows[count].cells[1].getElementsByTagName('input')[0];
	form_phoneno.setAttribute('value',tmp.value);
console.log('waiting');
update_phone.submit();
	}
</script>
</head>
<body>

<form id="update_phone_form" method="post">
<input type="hidden" name="contactid" value="${con.name}" />
<input type="hidden" name="phoneid" />
<input type="hidden" name="phoneno" />
</form>
<table style="display: none;"id="dummy">
  <tr>
   <td><input type="text" name="phonenumber" id="name" /></td>
   <td><button type="button" onclick="deleteRow(this);return false;" value="-1">-1</button></td>
   </tr>
  </table>
<form action="update_contact" id="update_contact">
<input type="hidden" name="contactid" value="${con.contactId}"> />
<input type="hidden" name="contact.contactid" value="${con.contactId}" />
 <fieldset>
  <legend>Update Contact</legend>
  <div id="content">
  Contact Name: <input type="text" name="contact.name" id="name" value="${con.name}" /><br>
  Email id: <input type="text" name="contact.emailid" id="emailid" value="${con.emailId }"  /><br>
  Phone No:
<button onclick="updatephone(this);return false;" name="delete">delete</button> 
<button onclick="updatephone(this);return false;" name="update">update</button>
  <table id="presentbook">
<c:forEach items="${phList}" var="phone">
<tr>
  <td><input type="radio" name="phone_id" value="${phone.phoneID}" /></td>
  <td><input type="text" name="phone_number" value="${phone.phoneNo}" /></td>
  </tr>
</c:forEach>
  </table>
  <button onclick="addRow();return false;">Add PhoneNO</button>
   <table style="display: none;" id="phonebook">
   <tr>
   <th>Phone NUmber</th>
   <th>option</th>
   </tr>
   </table>
  
  <div id="btn-grp">
  <button type="button" onclick="submitform();return false;"  value="Add Contact" >Add Contact</button>
      </div>
</div>
 </fieldset>
</form>
</body>
</html>