<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="f" %>
<f:form commandName="user" method="POST" action="updateordelete">
username:<f:input name="username" path="username" value="${model.username}"/>
password:<f:input name="password" path="password"/>
email :<f:input name="email" path="email"/>
mobile :<f:input name="mobile" path="mobile"/>
<input type="submit" name="delete" value="delete" />
<input type="submit" name="update" value="update"/>
</f:form>