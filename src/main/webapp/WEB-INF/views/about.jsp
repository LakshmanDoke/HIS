
<html>
<head>
<style type="text/css">
html {
	scroll-behavior: smooth;
}
</style>
<script>
	function myFunction() {
		window.scrollTo(0, 600);
	}
</script>

</head>
<body onload="myFunction()">
	<jsp:include page="header.jsp"></jsp:include>

	<!--about-->
	<section id="about" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-4 col-xs-12">
					<div class="section-title">
						<h2 class="head-title lg-line">
							The Medilap <br>Ultimate Dream
						</h2>
						<hr class="botm-line">
						<p class="sec-para">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit, sed do eiusmod tempor incididunt ut labore et
							dolore magna aliqua..</p>
						<a href="" style="color: #0cb8b6; padding-top: 10px;">Know
							more..</a>
					</div>
				</div>
				<div class="col-md-9 col-sm-8 col-xs-12">
					<div style="visibility: visible;"
						class="col-sm-9 more-features-box">
						<div class="more-features-box-text">
							<div class="more-features-box-text-icon">
								<i class="fa fa-angle-right" aria-hidden="true"></i>
							</div>
							<div class="more-features-box-text-description">
								<h3>It's something important you want to know.</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad
									minim veniam, quis nostrud.</p>
							</div>
						</div>
						<div class="more-features-box-text">
							<div class="more-features-box-text-icon">
								<i class="fa fa-angle-right" aria-hidden="true"></i>
							</div>
							<div class="more-features-box-text-description">
								<h3>It's something important you want to know.</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad
									minim veniam, quis nostrud.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ about-->
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
