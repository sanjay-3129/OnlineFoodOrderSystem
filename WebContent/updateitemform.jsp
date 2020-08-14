<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="description" content=" Your only food destination" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="robots" content="index,follow" />
<title>Think Food | Order Online</title>
<link rel="icon" href="./icons/fork.svg" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />

<link
	href="https://fonts.googleapis.com/css2?family=Pattaya&family=Poppins:wght@400;500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
	<header class="main-head">
		<nav>
			<h1 id="logo">Think Food</h1>
			<ul>
				<li><a href="./adminDashboard.jsp">Home</a></li>
				<li><a href="#About">About</a></li>
				<li><a href="#ItemListing">Item Listing</a></li>
			</ul>
		</nav>
	</header>
	<div class="jumbotron jumbotron-fluid " >
	<form action="<%=request.getContextPath()%>/admin/itemUpdation" method="get">
		
			<div class="container ">
				<div class="form-group row">
					<label for="itemId" class="col-sm-2 col-form-label">Item Id</label>
					<div class="col-sm-5">
					<%
						if(request.getAttribute("itemId") != null){
					%>
						<input type="text" class="form-control" id="itemId" name="itemId"
							placeholder="Item Id" value="<%=request.getAttribute("itemId")%>" readonly="readonly" >
					<%
						}
					%>
					</div>
					
				</div>

				<div class="form-group row">
					<label for="itemName" class="col-sm-2 col-form-label">Item
						Name</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="itemName" name="itemName"
							placeholder="Item Name" required>
					</div>
				</div>

				<fieldset class="form-group">
					<div class="row">
						<label for="itemtype" class="col-sm-2 col-form-label">Item
							Type</label>
						<div class="col-sm-7">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="itemType"
									id="itemType1" value="veg" checked> <label
									class="col-sm-2 col-form-label" for="itemType1"> Veg </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="itemType"
									id="itemType2" value="nonveg"> <label
									class="col-sm-2 col-form-label" for="itemType2"> Non
									Veg </label>
							</div>


						</div>
					</div>

				</fieldset>
				<div class="form-group row">
					<label for="itemPrice" class="col-sm-2 col-form-label">Item
						Price</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="itemPrice" name="itemPrice" 
							placeholder="Item Price" required>
					</div>
				</div>
				<div class="form-group row">
					<label for="itemImg" class="col-sm-2 col-form-label">Item
						Image </label>
					<div class="form-group-sm col-sm-10">
						<input type="file" style="font-size: 1rem"
							placeholder="Upload your file" id="itemImg" name="itemPath">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" class="btn btn-primary">Update Item</button>
					</div>
				</div>
			</div>
		<footer>

      <div class="footer-wrapper">
        <h4>ThinkFood &copy; 2020</h4>
        <ul>
          <li>
            <a href="#" title="twitter-social-media"><img src="<%=request.getContextPath()%>/icons/twitter.svg" alt="twitter-social-media" /></a>
          </li>
          <li>
            <a href="#" title="youtube-social-media"><img src="<%=request.getContextPath()%>/icons/youtube.svg" alt="youtube-social-media" /></a>
          </li>
          <li>
            <a href="#" title="instagram-social-media"><img src="<%=request.getContextPath()%>/icons/instagram.svg" alt="instagram-socialmedia" /></a>
          </li>
        </ul>
      </div>
    </footer>
	</form>

</div>




</body>
</html>