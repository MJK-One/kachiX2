<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>test</title>

</head>

<body>

	<c:forEach items="${list}" var="test">

	int = ${test.userID }<br>

	test = ${test.name}<br>


	</c:forEach>

</body>

</html>