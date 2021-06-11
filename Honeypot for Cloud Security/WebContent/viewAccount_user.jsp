<!DOCTYPE html>
<%@page import="com.honeypot.project.dao.ViewDAO"%>
<%@page import="com.honeypot.project.bean.Bean"%>
<%@page import="java.util.ArrayList"%>
<html>
<title>welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-social.css" rel="stylesheet" type="text/css">	
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
<style>
body,h1 {font-family: "Montserrat", sans-serif}
img {margin-bottom: -7px}
.w3-row-padding img {margin-bottom: 12px}
</style>
<body class="templatemo-bg-image-1">

<%
HttpSession ses = request.getSession();
int uid = (Integer)ses.getAttribute("uid");
ArrayList<Bean> al = new ViewDAO().userViewAccountDetails(uid); %>

<jsp:include page="userMenu.jsp"></jsp:include>

<div class="w3-content" style="max-width:1500px;" >
<!-- Header -->
<div class="w3-opacity">
<span class="w3-button w3-xxlarge w3-white w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></span> 
<div class="w3-clear"></div>
<header class="w3-center w3-margin-bottom">
  <div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-login-form-2" role="form" action="./UpdateAccountDetailsServlet_User" method="post">
				<div class="row">
					<div class="">
				        <div class="form-group">
				          <div class="col-md-12">		   
				    <%if(!al.isEmpty()){ %>
					<h1 style="color: white; margin-top: 5%;"><b>Account Details</b></h1>      
					<%String status =  request.getParameter("status");
					if(status!=null)
					{%>
						<h2 style="color: red"> <% out.print(status); %></h2>
					<%}
					%>	  
				            <div class="templatemo-input-icon-container">
				             <%for(Bean b:al){ %>
				            <table align="center">
              				<tr align="center">
              				<th style="color: white; font-family: Times New Roman; padding: 20px;">Uid</th>
              				<td style="color: white; font-family: Times New Roman; padding: 20px;"><%=b.getUid() %></td>
              				</tr>
              				<tr align="center">
              				<th style="color: white; font-family: Times New Roman; padding: 20px;">UserName</th>
              				<td style="color: white; font-family: Times New Roman; padding: 20px;"><input type="text" value="<%=b.getUname()%>" name="uname" style="background-color: transparent;border: none;text-align: center;" required></td>
              				</tr>
              				<tr align="center">
              				<th style="color: white; font-family: Times New Roman; padding: 20px;">Email</th>
              				<td style="color: white; font-family: Times New Roman; padding: 20px;"><%=b.getEmail()%></td>
              				</tr>
              				<tr align="center">
              				<th style="color: white; font-family: Times New Roman; padding: 20px;">Mobile</th>
              				<td style="color: white; font-family: Times New Roman; padding: 20px;"><input type="text" value="<%=b.getMobile() %>" style="background-color: transparent;border: none;text-align: center;" name="mobile" maxlength="10" pattern="[0-9]{10}" required></td>
              				</tr>
              				<tr align="center">
              				<th style="color: white; font-family: Times New Roman; padding: 20px;">location</th>
              				<td style="color: white; font-family: Times New Roman; padding: 20px;"><input type="text" value="<%=b.getAddress() %>" name="location" style="background-color: transparent;border: none; text-align: center;" required></td>
              				</tr>
              				<tr align="center">
              				<td colspan="1" style="color: white; font-family: Times New Roman; padding: 20px;"><input type="submit" value="Update" class="btn btn-warning pull-right"></td>
              				</tr>
              				</table>
              				<%} %>
              				<%} %>
				            </div>		            		            		            
				          </div>              
				        </div>
					</div>
				</div>				 	
		      </form>		      		      
		</div>
	</div>
  
</header>
</div>
 </div>
<script>
// Toggle grid padding
function myFunction() {
  var x = document.getElementById("myGrid");
  if (x.className === "w3-row") {
    x.className = "w3-row-padding";
  } else { 
    x.className = x.className.replace("w3-row-padding", "w3-row");
  }
}

// Open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.width = "100%";
  document.getElementById("mySidebar").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}
</script>

</body>
</html>
