<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
	<!DOCTYPE html>
	<html lang="zxx" class="no-js">
	<head>
		<!-- Mobile Specific Meta -->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Favicon-->
		<link rel="shortcut icon" href="img/fav.png">
		<!-- Author Meta -->
		<meta name="author" content="colorlib">
		<!-- Meta Description -->
		<meta name="description" content="">
		<!-- Meta Keyword -->
		<meta name="keywords" content="">
		<!-- meta character set -->
		<meta charset="UTF-8">
		<!-- Site Title -->
		<title>Travel</title>

		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
			<!--
			CSS
			============================================= -->
			<link rel="stylesheet" href="css/linearicons.css">
			<link rel="stylesheet" href="css/font-awesome.min.css">
			<link rel="stylesheet" href="css/bootstrap.css">
			<link rel="stylesheet" href="css/magnific-popup.css">
			<link rel="stylesheet" href="css/jquery-ui.css">				
			<link rel="stylesheet" href="css/nice-select.css">							
			<link rel="stylesheet" href="css/animate.min.css">
			<link rel="stylesheet" href="css/owl.carousel.css">				
			<link rel="stylesheet" href="css/main.css">
		</head>
		<body>	
			<header id="header">
				<div class="header-top">
					<div class="container">
			  		<div class="row align-items-center">
			  			<div class="col-lg-6 col-sm-6 col-6 header-top-left">
			  				<ul>
			  					<li><a href="#">Visit Us</a></li>
			  					<li><a href="#">Buy Tickets</a></li>
			  				</ul>			
			  			</div>
			  			
			  		</div>			  					
					</div>
				</div>
				<div class="container main-menu">
					<div class="row align-items-center justify-content-between d-flex">
				      <div id="logo">
				        <a href="Home"><img src="img/logo.png" alt="" title="" /></a>
				      </div>
				      <nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="Home">Home</a></li>
						<li><a href="AboutUsS">About</a></li>
						<li><a href="ConvertMoneyS">ConvertMoney</a></li>
						<li><a href="ContactS">Contact</a></li>
					</ul>
				</nav>
				<!-- #nav-menu-container -->				      		  
					</div>
				</div>
			</header><!-- #header -->
			<!-- start banner Area -->
	<section class="about-banner relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Get your currency exchange</h1>
					<p class="text-white link-nav">
						<a href="Home">Home To</a> 
						<a href="ConvertMoneyS"> ConvertMoney</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->


			<!-- Start Sample Area -->
	<div class="whole-wrap">
		<div class="container">
			<div class="section-top-border">
						<h3 class="mb-30">Currency exchange</h3>
						<div class="row">
							<div class="col-lg-12">
								<blockquote class="generic-blockquote">
Foreign exchange is the conversion of one currency into another at a specific rate known as the foreign exchange rate. The conversion rates for almost all currencies are constantly floating as they are driven by the market forces of supply and demand.								</blockquote>
							</div>
						</div>
					</div>
			<!-- End Sample Area -->
			<div class="section-top-border">
						<div class="row">
							<div class="col-lg-8 col-md-8">
								<h3 class="mb-30">Get your exchange</h3>
						<form method="Post" action="ConvertMoneyS">
									<div class="mt-10">
										<input type="text" id="Value" name="Value" placeholder="Value" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Value'" required class="single-input">
									</div>
									<div class="input-group-icon mt-10">
										<div class="form-select" id="default-select" >
											<select id="from" name="from">
											<option value="" disabled selected hidden>From</option>
											
											<c:forEach items="${list}" var="item" varStatus="i">
												<option value="${list[i.index]}">${item}</option>
											</c:forEach>
											</select>
											
										</div>
									</div>
							<div class="input-group-icon mt-10">
										<div class="form-select" id="default-select">
												<select id="to" name="to">
											<option value="" disabled selected hidden>To</option>
											<c:forEach items="${list}" var="item" varStatus="i">
												<option value="${list[i.index]}">${item}</option>
											</c:forEach>
											</select>
										</div>
									</div>
									
									<input type="submit" class="genric-btn primary" value="GetCurrency" style="float:Center;"><br/>
								
									
									
									<h3>Result : ${result}</h3>
									
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		
			<!-- start footer Area -->
	<footer class="footer-area section-gap">
		<div class="container">

			<div class="row">
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>About Agency</h6>
						<p>The world has become so fast, Check our latest offers.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Navigation Links</h6>
						<div class="row">
							<div class="col">
								<ul>
											<li><a href="Home">Home</a></li>
											<li><a href="AboutUsS">AboutUs</a></li>
											
										</ul>
									</div>
									
									<div class="col">
								<ul>
											<li><a href="ContactS">Contact</a></li>
											<li><a href="ConvertMoneyS">ConvertMoney</a></li>
										</ul>
									</div>
									
						</div>
					</div>
				</div>
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Newsletter</h6>
						<p>									For business professionals caught between high OEM price and graphic output.</p>
						<div id="mc_embed_signup">
							<form target="_blank"
								action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
								method="get" class="subscription relative">
								<div class="input-group d-flex flex-row">
									<input name="EMAIL" placeholder="Email Address"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Email Address '" required=""
										type="email">
									<button class="btn bb-btn">
										<span class="lnr lnr-location"></span>
									</button>
								</div>
								<div class="mt-10 info"></div>
							</form>
						</div>
					</div>
				</div>

			</div>

			<div
				class="row footer-bottom d-flex justify-content-between align-items-center">
				<p class="col-lg-8 col-sm-12 footer-text m-0">
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved SAOUDI & TENNIA
				</p>
				
			</div>
		</div>
	</footer>
	<!-- End footer Area -->
			<script>
			function myFunction() {
				  var x = document.getElementById("results");
				  if (x.style.display === "none") {
				    x.style.display = "block";
				  } else {
				    x.style.display = "none";
				  }
				}
			</script>
			<script src="js/vendor/jquery-2.2.4.min.js"></script>
			<script src="js/popper.min.js"></script>
			<script src="js/vendor/bootstrap.min.js"></script>			
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>		
 			<script src="js/jquery-ui.js"></script>					
  			<script src="js/easing.min.js"></script>			
			<script src="js/hoverIntent.js"></script>
			<script src="js/superfish.min.js"></script>	
			<script src="js/jquery.ajaxchimp.min.js"></script>
			<script src="js/jquery.magnific-popup.min.js"></script>						
			<script src="js/jquery.nice-select.min.js"></script>					
			<script src="js/owl.carousel.min.js"></script>							
			<script src="js/mail-script.js"></script>	
			<script src="js/main.js"></script>	
		</body>
	</html>