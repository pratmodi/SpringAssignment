<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head></head>

<body>
<form:form method="POST">

<table border=1>
	<c:forEach  var="item" items="${summarybean.selecteditems}">
	<tr>
		<td>${item.name} ${item.price}</td>
	</tr>
	</c:forEach>
	<tr>
		<td>Total =====> ${summarybean.total}</td>
	</tr>
</table>

<input type="submit" name="backtocart" value="Back To Cart">
<input type="submit" name="checkout" value="Checkout!">

</form:form>

</body>
</html>