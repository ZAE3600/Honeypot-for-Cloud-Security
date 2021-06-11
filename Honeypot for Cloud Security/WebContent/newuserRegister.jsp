<!DOCTYPE html>
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
<!-- <body class="templatemo-bg-gray"> -->
<body style="background-color: #808B96;">

<!-- Sidebar -->
<jsp:include page="menu.jsp"></jsp:include>

<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px;" >

<!-- Header -->
<div class="w3-opacity">
<span class="w3-button w3-xxlarge w3-white w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></span> 
<div class="w3-clear"></div>
<header class="w3-center w3-margin-bottom">
  <div class="container">
		<div class="col-md-12">		
		<h1 class="text-center margin-bottom-15" style="color: #1B4F72;font-size: 35px;font-family: Times New Roman;"><b>Registration Form</b></h1>	
		<%String status =  request.getParameter("status");
					if(status!=null)
					{%>
						<h2 style="color: red"> <% out.print(status); %></h2>
					<%}
					%>	
			<form class="form-horizontal templatemo-contact-form-2 templatemo-container" role="form" action="./RegisterServlet" method="post" style="background-color: white;">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">				          		          	
				           	<div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-user"></i>
				            		<input type="text" class="form-control" id="name" placeholder="Name" style="border-color: black;" name="name" required>
				            	</div>		            		            		            
				          	</div>              
				        </div>
				      <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-envelope"></i>
				            		<input type="email" class="form-control" id="email" placeholder="Email" name="email" style="border-color: black;" required>
				            	</div>
				          	</div>
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-lock"></i>
				            		<input type="password" class="form-control" id="password" placeholder="password" name="password" style="border-color: black;" required>
				            	</div>
				          	</div>
				        </div>
				        
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-mobile"></i>
				            		<input type="text" class="form-control" id="mobile" maxlength="10" pattern="[0-9]{10}" placeholder="mobile" title="Mobile Number should be in number" name="mobile" style="border-color: black;"  required>
				            	</div>
				          	</div>
				        </div>
				        
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class=""></i>
				            		<input type="date" class="form-control" id="date" placeholder="dob" name="dob" style="border-color: black;" required>
				            	</div>
				          	</div>
				        </div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-pencil-square-o"></i>
				            	<textarea rows="10" cols="50" class="form-control" id="address" placeholder="address" name="address" style="border-color: black;" required></textarea>
				            </div>
				          </div>
				        </div>
					</div>					
				</div>	        
		        <div class="form-group">
		          <div class="col-md-12">
		            <input type="submit" value="Register" class="btn btn-warning pull-right">		            
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
