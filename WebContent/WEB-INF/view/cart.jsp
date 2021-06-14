<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Cart</title>
</head>
<body>

<form:form method="POST" modelAttribute="inputbean">
<table>
	<tr>
		<th>Checkbox</th>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Quantity</th>
	</tr>
	
		<c:forEach items="${itemlist}" var="item">
			<tr>
				<td><form:checkbox value="${item.id}" path="selected"/></td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td><form:input  value="${inputbean.quantities[item.id-1]}" path="quantities[${item.id-1}]"/></td>
			</tr>
		</c:forEach>
		
	
</table>
<input type="submit" value="Add To Cart" name="addtocart"/>
<input type="submit" value="Checkout Now!" name="checkout"/>

</form:form>


</body>
</html>