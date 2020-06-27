<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
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
	</header>
	<!-- #header -->

	<!-- start banner Area -->
	<section class="about-banner relative">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">Hotels</h1>
					<p class="text-white link-nav">
						<a href="Home">Home To</a> <a href="HotelS"> Hotels</a>
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
						<h1 class="mb-10">Popular Destinations</h1>
						<p>We all live in an age that belongs to the young at heart.
							Life that is becoming extremely fast, day to.</p>
					</div>
				</div>
			</div>
			<div class="row" id="MyDiv">
				<c:forEach items="${hotel}" var="item">

					<div class="col-lg-4">
						<div class="single-destinations">
							<div class="thumb">
								<img src="${item.image_link}" resize="true" height="360px"
									width="280px" alt="">
							</div>
							<div class="details">
								<h5 class="d-flex justify-content-between">${item.name}</h5>

								<div class="star">
									<span>${item.classe}</span> stars
								</div>

								<p>
									<span>${item.reviews_number}</span> Reviews
								</p>
								<ul class="package-list">

									<li class="d-flex justify-content-between align-items-center">
										<span>Wi-fi</span> <span>${item.wifi?'Yes':'No'}</span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span>Swimming Pool</span> <span>${item.pool?'Yes':'No'}</span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span>Restaurant</span> <span>${item.restaurant?'Yes':'No'}</span>
									</li>
									<li class="d-flex justify-content-between align-items-center">
										<span>Price per night</span> <a href="#" class="price-btn">${item.price_per_night}</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<form method="Get" action="HotelS">
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
						Did not find your Package? <br> Feel free to ask us. <br>
					</h1>
					<a href="#" class="primary-btn text-uppercase">request custom
						price</a>
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
						<p>For business professionals caught between high OEM price
							and graphic output.</p>
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

	<script type="text/javascript">
		function refresh() {
			//Refresh page implementation here
			location.reload(true);
		}
	</script>
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
</body>
</html>