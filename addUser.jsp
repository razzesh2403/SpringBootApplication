<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="f" %>
<f:form  commandName="user" method="post">
<h1 align="center">Add User</h1>
<table border="1" align="center" width="40%">
	<tr><td>UserName</td><td><f:input path="username" required="required"/></td></tr>
	<tr><td>Password</td><td><f:password path="password"/></td></tr>
	<tr><td>Email</td><td><f:input path="email"/></td></tr>
	<tr><td>Mobile</td><td><f:input path="mobile"/></td></tr>
	<tr><td>User Type</td><td><f:select path="userType">
		<f:option value="">SELECT</f:option>
		<f:option value="ADMIN">ADMIN</f:option>
		<f:option value="USER">USER</f:option>
	</f:select></td></tr>
	<tr><td colspan="2"><f:button>Add User</f:button></td></tr>
</table>


</f:form>

<form action="/logout" method="post">
	<input type="submit" value="Sign out"/>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
</form>