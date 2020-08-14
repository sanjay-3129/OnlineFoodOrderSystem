<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="description" content=" Your only food destination" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="robots" content="index,follow" />
<title>Think Food | Customer view</title>
<link rel="icon" href="./icons/fork.svg" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Pattaya&family=Poppins:wght@400;500&display=swap"
	rel="stylesheet" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >


<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style1.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>


<script>
$('.carousel').carousel()




</script>

<script>
$('.carousel').carousel()

	
</script>


</head>
<body>
	<header class="main-head">
		<nav>
			<h1 id="logo">Think Food</h1>
			<ul>
				<li><a href="<%=request.getContextPath()%>/adminsignup.jsp" class="btn btn-primary">Admin Signup</a></li>
				<li><a href="<%=request.getContextPath()%>/customersignup.jsp" class="btn btn-primary">Customer Signup</a></li>
			</ul>
		</nav>
	</header>

<div class="bd-example">
  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="<%=request.getContextPath()%>/img/land4.jpg" class="d-block w-100"  alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Food is Everything!!!</h5>
          <p>There is no sincere love than love of food.</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="<%=request.getContextPath()%>/img/land2.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>I'm not drooling, you are!</h5>
          <p>People who love to eat Are Always The Best People.</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="<%=request.getContextPath()%>/img/land3.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>Carbs might be my soulmate.</h5>
          <p>How can you sleep when your favourite food is dating with us?</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>




	<footer>

		<div class="footer-wrapper">
			<h4>ThinkFood &copy; 2020</h4>
			<ul>
				<li><a href="#" title="twitter-social-media"><img
						src="./icons/twitter.svg" alt="twitter-social-media" /></a></li>
				<li><a href="#" title="youtube-social-media"><img
						src="./icons/youtube.svg" alt="youtube-social-media" /></a></li>
				<li><a href="#" title="instagram-social-media"><img
						src="./icons/instagram.svg" alt="instagram-socialmedia" /></a></li>
			</ul>
		</div>
	</footer>

</body>
</html>