
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
	<!--testimonial-->
	<section id="testimonial" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="ser-title">see what patients are saying?</h2>
					<hr class="botm-line">
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="testi-details">
						<!-- Paragraph -->
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
					<div class="testi-info">
						<!-- User Image -->
						<a href="#"><img src="/resources/img/thumb.png" alt=""
							class="img-responsive"></a>
						<!-- User Name -->
						<h3>
							Alex<span>Texas</span>
						</h3>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="testi-details">
						<!-- Paragraph -->
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
					<div class="testi-info">
						<!-- User Image -->
						<a href="#"><img src="/resources/img/thumb.png" alt=""
							class="img-responsive"></a>
						<!-- User Name -->
						<h3>
							Alex<span>Texas</span>
						</h3>
					</div>
				</div>
				<div class="col-md-4 col-sm-4">
					<div class="testi-details">
						<!-- Paragraph -->
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
					<div class="testi-info">
						<!-- User Image -->
						<a href="#"><img src="/resources/img/thumb.png" alt=""
							class="img-responsive"></a>
						<!-- User Name -->
						<h3>
							Alex<span>Texas</span>
						</h3>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/ testimonial-->
	<jsp:include page="footer.jsp"></jsp:include>