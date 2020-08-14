<%@ page
	import="com.foodorder.models.Order, com.foodorder.dao.impl.OrderDAOImpl, java.util.*"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table-info table-hover center">
		<thead>
			<tr>
				<th colspan="2" style="text-align: center;">Order Details</th>
			</tr>
		</thead>
		<%
		//System.out.println("Haiiii");
		OrderDAOImpl dao = new OrderDAOImpl();
		List<Order> orders = dao.getOrderByOrderId(request.getParameter("orderId"));
		//System.out.println("Hello");
		//System.out.println(request.getParameter("orderId") + "Hello hai");
		if (orders != null) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "inline; filename=" + "orderDetail.xls");
		}
		for(Order order : orders){
        	//System.out.println(order.getC_id());
        	//System.out.println("Hi to print excel");
		%>
		
		
			<tr>
				<td>Customer Id</td>
				<td><%=order.getC_id()%></td>
			</tr>
			<tr>
				<td>Order Id</td>
				<td><%=order.getOrder_id()%></td>
			</tr>
			<tr>
				<td>Bill Amount</td>
				<td><%=order.getBill()%></td>
			</tr>
		<% 
           }
        %>
		
	</table>
</body>
</html>

