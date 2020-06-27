<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


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
	<style>
		* {
			box-sizing: border-box;
		}

		body {
			font: 16px Arial;
		}

		/*the container must be positioned relative:*/
		.autocomplete {
			position: relative;
			display: inline-block;
		}

		input {
			border: 1px solid transparent;
			background-color: #f1f1f1;
			padding: 10px;
			font-size: 16px;
		}

		input[type=text] {
			background-color: #f1f1f1;
			width: 100%;
		}

		input[type=submit] {
			background-color: DodgerBlue;
			color: #fff;
			cursor: pointer;
		}

		.autocomplete-items {
			position: absolute;
			border: 1px solid #d4d4d4;
			border-bottom: none;
			border-top: none;
			z-index: 99;
			/*position the autocomplete items to be the same width as the container:*/
			top: 100%;
			left: 0;
			right: 0;
		}

		.autocomplete-items div {
			padding: 10px;
			cursor: pointer;
			background-color: #fff;
			border-bottom: 1px solid #d4d4d4;
		}

		/*when hovering an item:*/
		.autocomplete-items div:hover {
			background-color: #e9e9e9;
		}

		/*when navigating through the items using the arrow keys:*/
		.autocomplete-active {
			background-color: DodgerBlue !important;
			color: #ffffff;
		}
	</style>

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
					<li><a href="HomeS">Home</a></li>
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
<section class="banner-area relative">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div
				class="row fullscreen align-items-center justify-content-between">
			<div class="col-lg-6 col-md-6 banner-left">
				<h6 class="text-white">Away from monotonous life</h6>
				<h1 class="text-white">Magical Travel</h1>
				<p class="text-white">Make your choice and get your ticket!</p>
				<a href="#flight" class="primary-btn text-uppercase">Get
					Started</a>
			</div>
			<div class="col-lg-4 col-md-6 banner-right" style="margin-top: 80px;">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active"
											id="flight-tab" data-toggle="tab" href="#flight" role="tab"
											aria-controls="flight" aria-selected="true">Flights</a></li>
					<li class="nav-item"><a class="nav-link" id="hotel-tab"
											data-toggle="tab" href="#hotel" role="tab" aria-controls="hotel"
											aria-selected="false">Hotels</a></li>
					<li class="nav-item"><a class="nav-link" id="car-tab"
											data-toggle="tab" href="#car" role="tab" aria-controls="car"
											aria-selected="false">Cars</a></li>
					<li class="nav-item"><a class="nav-link" id="package-tab"
											data-toggle="tab" href="#package" role="tab"
											aria-controls="package" aria-selected="false">Package</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="flight" role="tabpanel"
						 aria-labelledby="flight-tab">
						<form method="Post" action="FlightS" class="form-wrap">
							<div class="autocomplete" style="width: 300px;">
								<input type="text" id="From" class="form-control" name="From"
									   placeholder="From " onfocus="this.placeholder = ''"
									   onblur="this.placeholder = 'From '">
							</div>


							<div class="autocomplete" style="width: 300px;">
								<input type="text" id="To" class="form-control" name="To"
									   placeholder="To " onfocus="this.placeholder = ''"
									   onblur="this.placeholder = 'To '">
							</div>
							<input type="text" class="form-control" name="source"
								   value="Flight" style="display: none;"> <input
								type="date" id="date" class="form-control" name="date"
								placeholder="date (jj/mm/aaaa)" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'date (jj/mm/aaaa)'" required> <input
								type="number" id="adults" min="1" max="20" class="form-control"
								name="adults" placeholder="Adults "
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Adults '" required> <input
								type="number" id="child" min="0" max="8" class="form-control"
								name="child" placeholder="Child "
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Child '" required>
							<select class="form-control" name="Classe" id="Classe" required>
								<option value="" disabled selected>Classe</option>
								<option value="0">Economic</option>
								<option value="1">Business</option>
							</select> <input
								type="date" id="Returndate" class="form-control"
								name="Returndate" placeholder="return date "
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'return date '"
								style="display: none;">
							<select class="form-control" name="SelectFlightOption" id="SelectFlightOption" style="display: none;">
								<option value="" disabled selected>Option</option>
								<option value="price">price</option>
								<option value="popularity">popularity</option>
								<option value="recommended">recommended</option>
							</select>
							<label for="myCheckFlight">Options</label>
							<input type="checkbox" id="myCheckFlight" onclick="DisplayOptions('myCheckFlight')" style="display: inline;">
							<label for="myCheck">Return</label>
							<input type="checkbox" id="myCheck" onclick="DisplayReturnDate()"  style="display: inline;">
							<p>
								<input type="submit" href="FlightS" class="genric-btn primary"
									   value="Get Flights" ><br />
							</p>
						</form>
					</div>
					<div class="tab-pane fade" id="hotel" role="tabpanel"
						 aria-labelledby="hotel-tab">
						<form method="Post" action="HotelS" class="form-wrap">
							<div class="autocomplete" style="width: 300px;">
								<input type="text" id="City" class="form-control" name="City"
									   placeholder="City " onfocus="this.placeholder = ''"
									   onblur="this.placeholder = 'City '">
							</div>
							<input type="text" class="form-control" name="source"
								   value="Hotel" style="display: none;"> <input
								type="date" id="CheckIn" class="form-control" name="CheckIn"
								placeholder="CheckIn (jj/mm/aaaa)" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'CheckIn (jj/mm/aaaa)'" required> <input
								type="text" id="Nights" class="form-control" name="Nights" min="1" max="30"
								placeholder="Nights " onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Nights '" required> <input
								type="number"  min="1" max="20" class="form-control"
								name="adults" placeholder="Adults "
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Adults '" required> <input
								type="number" min="0" max="9" class="form-control"
								name="child" placeholder="Child "
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Child '" required> <input
								type="number" id="Romm" class="form-control" name="Room" miin="1" max="3"
								placeholder="Room" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Room '" required>
							<select class="form-control" name="SelectHotelOption" id="SelectHotelOption" style="display: none;">
								<option value="" disabled selected>Option</option>
								<option value="price">price</option>
								<option value="popularity">popularity</option>
								<option value="recommended">recommended</option>
							</select>
							<label for="myCheckHotel">Options</label>
							<input type="checkbox" id="myCheckHotel" onclick="DisplayOptions('myCheckHotel')">
							<p>
								<input type="submit" class="genric-btn primary"
									   value="Get Hotels" ><br />
							</p>
						</form>
					</div>
					<div class="tab-pane fade" id="car" role="tabpanel"
						 aria-labelledby="car-tab">
						<form method="Post" action="CarS" class="form-wrap">
							<div class="autocomplete" style="width: 300px;">
								<input type="text"  class="form-control" name="City"
									   placeholder="City " onfocus="this.placeholder = ''"
									   onblur="this.placeholder = 'City '">
							</div>
							<label for="CheckIn">cars in</label>
							<input type="date" class="form-control" id="today"
								   name="CheckIn" placeholder="CheckIn (jj/mm/aaaa)"
								   onfocus="this.placeholder = ''"
								   onblur="this.placeholder = 'CheckIn (jj/mm/aaaa)'" required>
							<label for="CheckOut">cars out</label>
							<input
								type="date" id="CheckOut" class="form-control" name="CheckOut"
								placeholder="CheckOut (jj/mm/aaaa)" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'CheckOut (jj/mm/aaaa)'" required>
							<p>
								<input type="submit" href="CarS" class="genric-btn primary"
									   value="Get Cars" ><br />
							</p>
						</form>
					</div>
					<div class="tab-pane fade" id="package" role="tabpanel"
						 aria-labelledby="package-tab">
						<form method="Post" action="PackageS" class="form-wrap">
							<div class="autocomplete" style="width: 300px;">
								<input type="text" id="Fromm" class="form-control" name="Fromm"
									   placeholder="From " onfocus="this.placeholder = ''"
									   onblur="this.placeholder = 'From '">
							</div>
							<div class="autocomplete" style="width: 300px;">
								<input type="text" id="Too" class="form-control" name="Too"
									   placeholder="To " onfocus="this.placeholder = ''"
									   onblur="this.placeholder = 'To '">
							</div>
							<input type="date"  class="form-control"
								   name="CheckIn" placeholder="CheckIn (jj/mm/aaaa)"
								   onfocus="this.placeholder = ''"
								   onblur="this.placeholder = 'CheckIn (jj/mm/aaaa)'" required>
							<label for="CheckOutCar">cars out</label> <input
								type="date" id="CheckOutCar" class="form-control"
								name="CheckOutCar" placeholder="CheckOut Car (jj/mm/aaaa)"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'CheckOut Car (jj/mm/aaaa)'" required> <input
								type="text"  class="form-control" name="Adults" min="1" max="20"
								placeholder="Adults " onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Adults '" required> <input
								type="text" id="Children" class="form-control" name="Children" min="0" max="9"
								placeholder="Children " onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Children '" required>
							<select class="form-control" name="FlightClass" id="FlightClass">
								<option value="" disabled selected>Classe</option>
								<option value="0">Economic</option>
								<option value="1">Business</option>
							</select> <input
								type="text"  class="form-control" name="Nights"
								placeholder="Nights " onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Nights '" required> <input
								type="text" id="Room" class="form-control" name="Room" min="1" max="3"
								placeholder="Room " onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Room '" required>
							<select class="form-control" name="SelectPackageOption" id="SelectPackageOption" style="display: none;">
								<option value="" disabled selected>Option</option>
								<option value="price">price</option>
								<option value="popularity">popularity</option>
								<option value="recommended">recommended</option>
							</select>
							<label for="myCheckPackage">Options</label>
							<input type="checkbox" id="myCheckPackage" onclick="DisplayOptions('myCheckPackage')">
							<p>
								<input type="submit" href="PackageS" class="genric-btn primary"
									   value="Get Pack" ><br />
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->



<!-- Start other-issue Area -->
<section class="other-issue-area section-gap">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="menu-content pb-70 col-lg-9">
				<div class="title text-center">
					<h1 class="mb-10">Four rules to take before you travel</h1>
					<p>We all live in an age that belongs to the young at heart.
						Life that is.</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-3 col-md-6">
				<div class="single-other-issue">
					<div class="thumb">
						<img class="img-fluid" src="img/o1.jpg" alt="">
					</div>
					<a href="#">
						<h4>Rent a Car</h4>
					</a>

				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="single-other-issue">
					<div class="thumb">
						<img class="img-fluid" src="img/o2.jpg" alt="">
					</div>
					<a href="#">
						<h4>Discover new places</h4>
					</a>

				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="single-other-issue">
					<div class="thumb">
						<img class="img-fluid" src="img/o3.jpg" alt="">
					</div>
					<a href="#">
						<h4>Enjoy your time</h4>
					</a>

				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="single-other-issue">
					<div class="thumb">
						<img class="img-fluid" src="img/o4.jpg" alt="">
					</div>
					<a href="#">
						<h4>Eat healthy food</h4>
					</a>

				</div>
			</div>
		</div>
	</div>
</section>
<!-- End other-issue Area -->


<!-- Start testimonial Area -->
<section class="testimonial-area section-gap">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="menu-content pb-70 col-lg-8">
				<div class="title text-center">
					<h1 class="mb-10">Testimonial from our Team</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="active-testimonial">
				<div class="single-testimonial item d-flex flex-row">
					<div class="thumb">
						<img class="img-fluid" src="img/picsaoudi.jpg" alt="">
					</div>
					<div class="desc">
						<p>Do you want to be even more successful? Learn to love
							learning and growth.</p>
						<h4>SAOUDI Mehdi</h4>

					</div>
				</div>
				<div class="single-testimonial item d-flex flex-row">
					<div class="thumb">
						<img class="img-fluid" src="img/pictennia.jpg" alt="">
					</div>
					<div class="desc">
						<p>The more effort you put into improving your skills, the
							bigger the payoff you.</p>
						<h4>TENNIA Youssef</h4>

					</div>
				</div>


			</div>
		</div>
	</div>
</section>
<!-- End testimonial Area -->

<!-- Start home-about Area -->
<section class="home-about-area">
	<div class="container-fluid">
		<div class="row align-items-center justify-content-end">
			<div class="col-lg-6 col-md-12 home-about-left">
				<h1>
					Did not find your Package? <br> Feel free to contact us. <br>
				</h1>
				<a href="ContactS" class="primary-btn text-uppercase">Contact
					Us</a>
			</div>
			<div class="col-lg-6 col-md-12 home-about-right no-padding">
				<img class="img-fluid" src="img/about-img.jpg" alt="">
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
					<p>We facilitate the way of working, hurry up and get your
						ticket!!</p>
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

		<div
				class="row footer-bottom d-flex justify-content-between align-items-center">
			<p class="col-lg-8 col-sm-12 footer-text m-0">
				Copyright &copy;
				<script>
					document.write(new Date().getFullYear());
				</script>
				All rights reserved SAOUDI & TENNIA ></p>
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
<script type="text/javascript">
	//dak myInput how Id dyal input li atkhdm 3lih
	var inputBox = document.getElementById('From');
	var inputBoxx = document.getElementById('To');
	var inputBoxxx = document.getElementById('City');
	var inputBox_ = document.getElementById('Fromm');
	var inputBox__ = document.getElementById('Too');

	inputBox_.onkeyup = function() {
		var url = 'https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=';
		url = url.concat(inputBox_.value);
		var tab = [];
		mymethod(url);

	}
	inputBox__.onkeyup = function() {
		var url = 'https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=';
		url = url.concat(inputBox__.value);
		var tab = [];
		mymethod(url);

	}
	inputBox.onkeyup = function() {
		var url = 'https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=';
		url = url.concat(inputBox.value);
		var tab = [];
		mymethod(url);

	}
	inputBoxx.onkeyup = function() {
		var url = 'https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=';
		url = url.concat(inputBoxx.value);
		var tab = [];
		mymethod(url);

	}
	inputBoxxx.onkeyup = function() {
		var url = 'https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text=';
		url = url.concat(inputBoxxx.value);
		var tab = [];
		mymethod(url);

	}
</script>
<script>
	function mymethod(url) {
		var settings = {
			"async" : true,
			"crossDomain" : true,
			"url" : url,
			"method" : "GET",
			"headers" : {
				"x-rapidapi-host" : "cometari-airportsfinder-v1.p.rapidapi.com",
				"x-rapidapi-key" : "ce77bfacafmshc587b77938e05c9p17b0a9jsn067bc6318ab4",
				'Content-Type' : 'application/json'
			}
		}
		var arr = [];
		var ar = [];
		$.ajax(settings).done(function(response) {
			var flights_number = response.length;
			for (let i = 0; i < flights_number; i++) {
				//Hadi atkon essentiellemnt f Hotels (City)
				arr[i] = response[i]["city"];
				ar[i] = response[i]["city"];
				//HADO li lt7t aykono hir f flight.jsp
				arr[i] = arr[i].concat(" ");
				arr[i] = response[i]["name"];
				arr[i] = arr[i].concat(" (");
				arr[i] = arr[i].concat(response[i]["code"]);
				arr[i] = arr[i].concat(")");
				alert(arr[i]);
			}
			autocomplete(document.getElementById("From"), arr);
			autocomplete(document.getElementById("Fromm"), arr);
			autocomplete(document.getElementById("To"), arr);
			autocomplete(document.getElementById("Too"), arr);
			autocomplete(document.getElementById("City"), ar);
		});

	}
</script>

<script>
	function autocomplete(inp, arr) {
		/*the autocomplete function takes two arguments,
        the text field element and an array of possible autocompleted values:*/
		var currentFocus;
		/*execute a function when someone writes in the text field:*/
		inp
				.addEventListener(
						"input",
						function(e) {
							var a, b, i, val = this.value;
							/*close any already open lists of autocompleted values*/
							closeAllLists();
							if (!val) {
								return false;
							}
							currentFocus = -1;
							/*create a DIV element that will contain the items (values):*/
							a = document.createElement("DIV");
							a.setAttribute("id", this.id
									+ "autocomplete-list");
							a.setAttribute("class", "autocomplete-items");
							/*append the DIV element as a child of the autocomplete container:*/
							this.parentNode.appendChild(a);
							/*for each item in the array...*/
							//hada l valeur tat7km biha ch7al l max dyal les elements itl3o f auto-complete
							var k = 8;
							for (i = 0; i < arr.length; i++) {
								/*check if the item starts with the same letters as the text field value:*/
								if (arr[i].substr(0, val.length)
												.toUpperCase() == val.toUpperCase()
										&& k != 0) {
									k = k - 1;
									/*create a DIV element for each matching element:*/
									b = document.createElement("DIV");
									/*make the matching letters bold:*/
									b.innerHTML = "<strong>"
											+ arr[i].substr(0, val.length)
											+ "</strong>";
									b.innerHTML += arr[i]
											.substr(val.length);
									/*insert a input field that will hold the current array item's value:*/
									b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
									/*execute a function when someone clicks on the item value (DIV element):*/
									b
											.addEventListener(
													"click",
													function(e) {
														/*insert the value for the autocomplete text field:*/
														inp.value = this
																.getElementsByTagName("input")[0].value;
														/*close the list of autocompleted values,
                                                        (or any other open lists of autocompleted values:*/
														closeAllLists();
													});
									a.appendChild(b);
								}
							}
						});
		/*execute a function presses a key on the keyboard:*/
		inp.addEventListener("keydown", function(e) {
			var x = document.getElementById(this.id + "autocomplete-list");
			if (x)
				x = x.getElementsByTagName("div");
			if (e.keyCode == 40) {
				/*If the arrow DOWN key is pressed,
                increase the currentFocus variable:*/
				currentFocus++;
				/*and and make the current item more visible:*/
				addActive(x);
			} else if (e.keyCode == 38) { //up
				/*If the arrow UP key is pressed,
                decrease the currentFocus variable:*/
				currentFocus--;
				/*and and make the current item more visible:*/
				addActive(x);
			} else if (e.keyCode == 13) {
				/*If the ENTER key is pressed, prevent the form from being submitted,*/
				e.preventDefault();
				if (currentFocus > -1) {
					/*and simulate a click on the "active" item:*/
					if (x)
						x[currentFocus].click();
				}
			}
		});
		function addActive(x) {
			/*a function to classify an item as "active":*/
			if (!x)
				return false;
			/*start by removing the "active" class on all items:*/
			removeActive(x);
			if (currentFocus >= x.length)
				currentFocus = 0;
			if (currentFocus < 0)
				currentFocus = (x.length - 1);
			/*add class "autocomplete-active":*/
			x[currentFocus].classList.add("autocomplete-active");
		}
		function removeActive(x) {
			/*a function to remove the "active" class from all autocomplete items:*/
			for (var i = 0; i < x.length; i++) {
				x[i].classList.remove("autocomplete-active");
			}
		}
		function closeAllLists(elmnt) {
			/*close all autocomplete lists in the document,
            except the one passed as an argument:*/
			var x = document.getElementsByClassName("autocomplete-items");
			for (var i = 0; i < x.length; i++) {
				if (elmnt != x[i] && elmnt != inp) {
					x[i].parentNode.removeChild(x[i]);
				}
			}
		}
		/*execute a function when someone clicks in the document:*/
		document.addEventListener("click", function(e) {
			closeAllLists(e.target);
		});
	}
</script>
<script>
	function DisplayReturnDate() {
		var checkBox = document.getElementById("myCheck");
		var text = document.getElementById("Returndate");
		if (checkBox.checked == true) {
			text.style.display = "block";
		} else {
			text.style.display = "none";
		}
	}
</script>
<script>
	function DisplayOptions(id) {
		var checkBox = document.getElementById(id);
		var id_selection;
		if(id == 'myCheckFlight') id_selection = "SelectFlightOption";
		if(id == 'myCheckHotel') id_selection = "SelectHotelOption";
		if(id == 'myCheckPackage') id_selection = "SelectPackageOption";
		var text = document.getElementById(id_selection);
		if (checkBox.checked == true) {
			text.style.display = "block";
		} else {
			text.style.display = "none";
		}
	}
</script>
</body>
</html>