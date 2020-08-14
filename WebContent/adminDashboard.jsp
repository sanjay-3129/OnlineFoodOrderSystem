<%@ page import="com.foodorder.models.Menu,java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" TYPE="text/css">

<link
	href="https://fonts.googleapis.com/css2?family=Pattaya&family=Poppins:wght@400;500&display=swap"
	rel="stylesheet" />
<style>
body {
font-size: 2.5rem;
}
</style>

<script type="text/javascript">
	function deleteItem(){
		var conf = confirm("For sure, You want Delete!!!");
		if(conf == true){
			return true;
		} 
		return false;
	}
	
	function updateItem(){
		var conf = confirm("You can update by Pressing OK!!!");
		if(conf == true){
			return true;
		} 
		return false;
	}
	
</script>

</head>
<body>
	<header class="main-head">
		<nav>
			<h1 id="logo">Think Food</h1>
			<ul>
				<li><a href="<%=request.getContextPath()%>/admin/home">Home</a></li>
				<li><a href="#About">About</a></li>
				<li><a href="<%=request.getContextPath()%>/home.jsp" class="btn btn-primary">Logout</a></li>
			</ul>
		</nav>
	</header>

	<section id="dashboard" class="dashboard">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h5>Welcome <%=session.getAttribute("name") %>, Here are the List of food Items</h5>

				
						<form action="<%=request.getContextPath()%>/admin/dashboard/search" class="form-inline p-4 justify-content-center">
							<input class="form-control mr-sm-2" type="search"
								placeholder="Item Name" aria-label="Search" name="searchItem">
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit" onclick="return itemSearch()" >Search</button>
						</form>
					
					
					<table class="table w-150">
						<thead>
							<tr>
								<th scope="col">Item Id</th>
								<th scope="col">Item Name</th>
								<th scope="col">Item Price</th>
								<th scope="col">
									<div class="btn-group dropdown">
										<button type="button"
											class="btn btn-secondary dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">Item Type</button>
										<div class="dropdown-menu">
											<a class="dropdown-item" href="#">Veg</a> 
											<a class="dropdown-item" href="#">Non Veg</a>

										</div>
									</div>
								</th>
								<th scope="col">Actions <a href="<%=request.getContextPath()%>/additemform.jsp"
									class="btn btn-primary">Add Items</a></th>

							</tr>
						</thead>
						<tbody>
							<tr>
							<% 
								List<Menu> myItems = (List<Menu>) request.getAttribute("itemList");
								if(myItems.size() > 0){
									for(Menu menu : myItems) { 
							%>
								<td><%=menu.getItemId()%></td>
								<td><%=menu.getItemName()%></td>
								<td><%=menu.getItemPrice()%></td>
								<td><%=menu.getItemType()%></td>
								<td><a class="btn btn-warning" href="<%=request.getContextPath()%>/admin/update?itemId=<%=menu.getItemId()%>" onclick="return updateItem()" >Update</a> 
								<a class="btn btn-danger" href="<%=request.getContextPath()%>/admin/delete?itemId=<%=menu.getItemId()%>" onclick="return deleteItem()" >Delete</a></td>
							</tr>
							<%
									}
								}
								else{ 
									if(session.getAttribute("items").equals("full")){
							%>	
										<p style="font-size: 24px;color: #333333;margin:100px;">No Menu Items Added. Click the add items button to add new menu items!!!</p>		
							<%	
									}
									else{
							%>
										<p style="font-size: 24px;color: #333333;margin:100px;">The items you are searching is not available. Try again!!!</p>
							<%					
									}
								}
							%>
							<!-- <tr>
								<td>2</td>
								<td>Ice cream</td>
								<td>120.00</td>
								<td>veg</td>
								<td><a class="btn btn-warning" href="#">Update</a> <a
									class="btn btn-danger" href="#">Delete</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td>Ice cream</td>
								<td>120.00</td>
								<td>veg</td>
								<td><a class="btn btn-warning" href="#">Update</a> <a
									class="btn btn-danger" href="#">Delete</a></td>
							</tr> -->
						</tbody>
					</table>



				</div>
			</div>
			<nav aria-label="Page navigation">
				<ul class="pagination pagination-sm justify-content-center">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</section>
	
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

</body>
</html>