<!DOCTYPE html>
<html>
<title>welcome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
body,h1 {font-family: "Montserrat", sans-serif}
img {margin-bottom: -7px}
.w3-row-padding img {margin-bottom: 12px}
</style>
<body style="background-image: url('images/cloud security.jpg'); background-size: cover; background-attachment: fixed;">

<!-- Sidebar -->
<jsp:include page="userMenu.jsp"></jsp:include>

<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px;" >

<!-- Header -->
<div class="w3-opacity">
<span class="w3-button w3-xxlarge w3-white w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></span> 
<div class="w3-clear"></div>
<header class="w3-center w3-margin-bottom" style="margin-top: 10%;">
  <%String status =  request.getParameter("status");
					if(status!=null)
					{%>
					<h1><b style="color: green;font-size: 200%;"><% out.print(status); %></b></h1>
					<%}
					%>
  
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
