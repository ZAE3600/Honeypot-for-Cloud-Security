<!DOCTYPE html>
<%@page import="com.honeypot.project.bean.Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.honeypot.project.dao.ViewDAO"%>
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
<body class="templatemo-bg-gray">
<%
ArrayList<Bean> al = new ViewDAO().attackerViewUnusedIpAddress();

%>

<jsp:include page="attackerMenu.jsp"></jsp:include>

<div class="w3-content" style="max-width:1500px;" >

<!-- Header -->
<div class="w3-opacity">
<span class="w3-button w3-xxlarge w3-white w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></span> 
<div class="w3-clear"></div>
<header class="w3-center w3-margin-bottom">
  <div class="container">
		<div class="col-md-12">		
		<h1 class="text-center margin-bottom-15">Un used IP Address</h1>	
			<form class="form-horizontal templatemo-contact-form-2 templatemo-container" role="form" action="./DownloadFileWHServlet_attacker" method="post">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">				          		          	
				           	<div class="col-sm-12">
				           	 <%String status =  request.getParameter("status");
					if(status!=null)
					{%>
						<h2 style="color: red"> <% out.print(status); %></h2>
					<%}
					%>	     
					<%if(al.isEmpty()){ %>
					<h1 style="color: black; margin-top: 5%;"><b>UnUsedIpaddress are Not Available</b></h1>
					<%} %>  	
				    <%if(!al.isEmpty()){ %>
				            	<div class="templatemo-input-icon-container">
				            	<input type="hidden" name="withoutHoneyPot" value="withoutHoneyPot">
				            		<i class="fa fa-envelope"></i>
				            		<select class="form-control" name="ipaddress" required>
				            		<option value="">Select Ipaddress</option>
				            		<%for(Bean b:al){ %>
				            		<option value="<%=b.getIpaddress() %>"><%=b.getIpaddress()%></option>
				            		<%} %>
				            		</select>
				            	</div>		            		            		            
				          	</div>              
				        </div>
				        
					</div>
				</div>	        
		        <div class="form-group">
		          <div class="col-md-12">
		            <input type="submit" value="Attack" class="btn btn-warning pull-right">		            
		          </div>
		          <%} %>
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
