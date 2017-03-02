<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<f:form commandName="users">
Users List
<table border="1" draggable="true">
<c:forEach var="i" begin="0" end="${users.size() }">
	<tr><td><c:out value="${users[i].username }"></c:out></td>
	<td><c:out value="${users[i].email }"></c:out></td>
	<td><c:out value="${users[i].mobile }"></c:out></td></tr>
</c:forEach>
</table>
</f:form>