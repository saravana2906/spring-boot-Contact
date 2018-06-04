<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
<style>
.error
{
color: red;
}
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
    // deep clone the targeted row
 var new_row = x.rows[1].cloneNode(true);
    // get the total number of rows
 var len = x.rows.length;
    // set the innerHTML of the first row 
// new_row.cells[0].innerHTML = len;

    // grab the input from the first cell and update its ID and value
 var inp1 = new_row.cells[0].getElementsByTagName('input')[0];
 inp1.id += len;
 inp1.value = '';

    // grab the input from the first cell and update its ID and value
 var inp2 = new_row.cells[1].getElementsByTagName('button')[0];
 inp2.id += len;
// inp2.value = '-1';
 inp2.innerHTML="-1";
 inp2.onclick = function() { deleteRow(inp2); };

    // append the new row to the table
 x.appendChild( new_row );
	
	}
	
	function deleteRow(row)
	{
		var i = row.parentNode.parentNode.rowIndex;
		  document.getElementById('phonebook').deleteRow(i);
		
	}
	function submitform()
	{
		var x=document.getElementById('contactform');
		var tab=document.getElementById('phonebook');
		for(var i=1;i<tab.rows.length;i++)
			{
			var row=tab.rows[i];
			console.log("iteration :"+i)
			var inp1 = row.cells[0].getElementsByTagName('input')[0];
			inp1.name="phonenumber["+(i-1)+"]";
			inp1.id="phonenumber["+(i-1)+"]";
			}
		x.submit();
	//	window.close();
	}
</script>
</head>
<body>
<form action="process_addcontact" id="contactform" method="post">
 <fieldset>
  <legend>Add Contact</legend>
  <p class="error">${error}</p>
  <div id="content">
  Contact Name: <input type="text" name="name" id="name" /><br>
  Email id: <input type="text" name="emailid" id="emailid" /><br>
  Phone No: 
   <table id="phonebook">
   <tr>
   <th>Phone NUmber</th>
   <th>option</th>
   </tr>
     <tr>
        <td><input type="text" name="phonenumber[0]" id="phonenumber[0]" /></td>
   <td><button type="button" onclick="addRow()" value="+1" > +1</button></td>
   </tr>
    <tr>
   <td><input type="text" name="phonenumber[1]" id="phonenumber[0]" /></td>
   <td><button type="button" onclick="deleteRow(this)" value="-1">-1</button></td>
   </tr>
   
  </table>
  
  <div id="btn-grp">
  <button type="button" onclick="submitform()"  value="Add Contact" >Add Contact</button>
      </div>
</div>
 </fieldset>
</form>
</body>
</html>