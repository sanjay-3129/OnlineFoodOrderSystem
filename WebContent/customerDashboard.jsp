<%@ page import="com.foodorder.models.Menu,java.util.List"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script>
function getResult(itemID, itemPRICE){
	var itemId = itemID;
	var itemPrice = parseFloat(itemPRICE);
	var totalPrice = document.getElementById("totalPrice").innerHTML;  //0
	var totalItemPrice = parseFloat(totalPrice);
	console.log(itemPrice);
	console.log(totalPrice);
	if(itemId !== null){
		if(typeof totalItemPrice === 'number'){
			totalItemPrice = totalItemPrice + itemPrice;
		}	
	}
	document.getElementById("totalPrice").innerHTML = totalItemPrice;
	document.getElementById("totalBillAmount").value = totalItemPrice;
	console.log(totalItemPrice);
}
</script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/assests/js/cart.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Pattaya&family=Poppins:wght@400;500&display=swap"
	rel="stylesheet" />
</head>

<body>
	<header class="main-head" style="margin-bottom: 100px;">
		<nav>
			<h1 id="logo" style="color: white;">Think Food</h1>
			<ul>

				<li><a href="<%=request.getContextPath()%>/home.jsp"
					class="btn btn-primary">Log out</a></li>
			</ul>
		</nav>
	</header>


	<!-- cardss -->
		<section id="listings" class="py-4">
			<div class="container">
				<div class="row">

					<!-- Listing 1 -->
					<%
						List<Menu> myItems = (List<Menu>) request.getAttribute("itemList");
						if (myItems.size() > 0) {
						for (Menu menu : myItems) {
					%>
					<div class="col-md-6 col-lg-4 mb-4">
						<div class="card listing-preview">
							<img class="card-img-top"
								src="<%=request.getContextPath()%>/img/foods/<%=menu.getItemImgPath()%>"
								alt="<%=menu.getItemImgPath()%>"
								style="height: 300px; width: 400px">
							<div class="card-img-overlay">
								<h2>
									<span class="badge badge-secondary text-white" id="itemPrice"><%=menu.getItemPrice()%></span>
								</h2>
							</div>
							<div class="card-body">
								<div class="listing-heading text-center">
									<h4 class="text-primary"><%=menu.getItemName()%></h4>
									<p>
										<i class="fas fa-map-marker text-secondary" id="itemId"><%=menu.getItemId()%></i>
									</p>
								</div>
								<hr>
								<div class="row py-2 text-secondary">
									<div class="col-6">
										<i class="fas fa-th-large"></i>Type:
										<%=menu.getItemType()%>
									</div>
									<div class="col-6">
										<i class="fas fa-car"></i> Ratings: * * * *
									</div>
								</div>

								<hr>
								<div class="row py-2 text-secondary">
									<div class="col-12">
										<main class="cd-main container margin-top-xxl">
											<div class="text-component text-center">

												<p class="flex flex-wrap flex-center flex-gap-xxs">
													<a href="#0" class="cd-add-to-cart js-cd-add-to-cart"
														onclick="getResult(<%=menu.getItemId()%>, <%=menu.getItemPrice()%>)">Add
														To Cart</a>
												</p>
											</div>
										</main>
									</div>
								</div>
								<div class="row text-secondary pb-2">
									<div class="col-6"></div>
								</div>

							</div>
						</div>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
		</section>

	<form action="<%=request.getContextPath()%>/customer/saveOrder" method="get">
		<div
			style="font-size: 3rem; text-align: center; margin-bottom: 100px; margin-top: 50px;">
			<span>Total Price: Rs. </span><span id="totalPrice">0.0</span>&nbsp;&nbsp;&nbsp;<input type="submit" value="Place Order" class="btn btn-dark" />
			<input type="hidden" name="totalBillAmount" id="totalBillAmount" /> <br>
		</div>
	</form>

</body>
</html>