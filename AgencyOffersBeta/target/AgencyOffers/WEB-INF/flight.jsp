<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
	rel="stylesheet">
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
					<a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
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
	</header>
	<!-- #header -->

	<!-- start banner Area -->
	<section class="about-banner relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Flights</h1>
					<p class="text-white link-nav">
						<a href="HomeS">Home </a> <span>To</span> <a href="#">
							Flights</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

	<!-- Start destinations Area -->
	<section class="destinations-area section-gap">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="menu-content pb-40 col-lg-8">
					<div class="title text-center">
						<h1 class="mb-10">Popular flights</h1>
						<p>Take your flights with good prices</p>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${flights}" var="item">

					<div class="col-lg-4">
						<div class="single-destinations">
							<div>
								<img src="${item.company_logo}" alt="">
							</div>
							<div class="details">
								<h4 class="d-flex justify-content-between">
									<span>${item.company_name}</span>
								</h4>
								<h6>${item.origine}${!empty item.return_flight_departure_hour? '&#8644;':	'&#10140;'}${item.destination}</h6>
								<p>aller : ${item.flight_departure_hour}--
									${item.stops_number==0 ? ' direct flight ':''}
									${item.stops_number==1 ? ' one stop ' : ''}
									${item.stops_number==2 ? ' two stops ' : ''} --
									${item.flight_arrived_hour}</p>
								<c:if test="${!empty item.return_flight_departure_hour}">
									<p>return : ${item.return_flight_departure_hour} --
										${item.second_stops_number==0 ? ' direct flight ':''}
										${item.second_stops_number==1 ? ' one stop ' : ''}
										${item.second_stops_number==2 ? ' two stops ' : ''} --
										${item.return_flight_arrived_hour}</p>
								</c:if>
								<ul class="package-list">
									<li class="d-flex justify-content-between align-items-center">
										<span>aller duree</span> <span>${item.flight_duration}</span>
									</li>
									<c:if test="${!empty item.return_flight_departure_hour}">
										<li class="d-flex justify-content-between align-items-center">
											<span>return duree</span> <span>${item.second_flight_duration}</span>
										</li>
									</c:if>
									<li class="d-flex justify-content-between align-items-center">
										<span>classe</span> <span>${item.flight_class==0? 'Economic':''}
											${item.flight_class==1? 'Business Class':''}</span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span>adults</span> <span>${item.adults_number}</span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span>children</span> <span>${item.children_age_number}</span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span>Price</span> <a href="#" class="price-btn">${item.price}</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<form method="Get" action="FlightS">
					<input type="submit" class="genric-btn primary" value="Show More">
			</form>
		</div>
	</section>
	<!-- End destinations Area -->


	<!-- Start home-about Area -->
	<section class="home-about-area">
		<div class="container-fluid">
			<div class="row align-items-center justify-content-end">
				<div class="col-lg-6 col-md-12 home-about-left">
					<h1>
						Did not find your Package? <br> Feel free to ask us.
					</h1>
			
											<a href="ContactS" class="primary-btn text-uppercase">Contact Us</a>

				</div>
				<div class="col-lg-6 col-md-12 home-about-right no-padding">
					<img class="img-fluid" src="img/hotels/about-img.jpg" alt="">
				</div>
			</div>
		</div>
	</section>
	<!-- End home-about Area -->

	<!-- start footer Area -->
	<footer class="footer-area section-gap">
		<div class="container">

			<div class="row">
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
								<h6>About Agency</h6>
								<p>We facilitate the way of working, hurry up and get your ticket!!</p>
							</div>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Navigation Links</h6>
						<div class="row">
									<div class="col">
										<ul>
											<li><a href="Home">Home</a></li>
											<li><a href="AboutUsS">About</a></li>
											
										</ul>
									</div>
									<div class="col">
										<ul>
											<li><a href="ConvertMoneyS">ConvertMoney</a></li>
											<li><a href="ContactS">Contact</a></li>
										</ul>
									</div>
																		
								</div>							
					</div>
				</div>
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Newsletter</h6>
						<p>For business professionals caught between high OEM price
							and mediocre print and graphic output.</p>
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

	
						<p class="col-lg-8 col-sm-12 footer-text m-0">
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved SAOUDI & TENNIA ></i>

					</div>
		</div>
	</footer>
	<!-- End footer Area -->


	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
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
	<script type="text/javascript" src="./jquery-3.4.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
</body>
</html>