 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<form:form method="POST" modelAttribute="loginBean">

	Username:<form:input path = "username"/>
	<form:errors path="username"/>
	Password:<form:password path = "password"/>
	
<form:errors path="password"/>
<input type="submit" name="login" value="Login"/>

</form:form>

</body>
</html>