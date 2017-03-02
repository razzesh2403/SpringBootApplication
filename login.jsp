<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form  action="/login" method="POST">
username<input type="text" name="username"/>
password<input type="password" name="password"/>
<input type="submit" name="btn" value="Login"/> 
Remember Me: <input type="checkbox" name="remember-me" />

<c:if test="${param.error ne null }">
invalid credentials
</c:if>

<c:if test="${param.logout ne null }">
logout successful
</c:if>

<input type="hidden"
name="${_csrf.parameterName }"
value="${_csrf.token }"/>

</form>
