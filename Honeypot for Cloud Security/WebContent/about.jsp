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
<jsp:include page="menu.jsp"></jsp:include>

<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px;" >

<!-- Header -->
<div class="w3-opacity">
<span class="w3-button w3-xxlarge w3-white w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></span> 
<div class="w3-clear"></div>
<header class="w3-center w3-margin-bottom">
  <h1><b style="color: green;font-size: 100%;">About Project</b></h1>
  <div class="container">
		<div class="col-md-12">		
				<div class="row">
					<div class="col-md-12">
						<font color="white" style="font-size: 25px; font-family: Times New Roman; margin-left: 10%; margin-right: 10%;"> With the rapid increase in the number of users, there
is a rise in issues related to hardware failure, web hosting, space
and memory allocation of data, which is directly or indirectly
leading to the loss of data. With the objective of providing services
that are reliable, fast and low in cost, we turn to cloud-computing
practices. With a tremendous development in this technology,
there is ever increasing chance of its security being compromised
by malicious users. A way to divert malicious traffic away from
systems is by using Honeypot. It is a colossal strategy that has
shown signs of improvement in security of systems. Keeping in
mind the various legal issues one may face while deploying
Honeypot on third-party cloud vendor servers, the concept of
Honeypot is implemented in a file-sharing application which is
deployed on cloud server. This paper discusses the detection
attacks in a cloud-based environment as well as the use of
Honeypot for its security, thereby proposing a new technique to do
the same</font>
					</div>
				</div>
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
