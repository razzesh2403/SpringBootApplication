<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="f" %>

<f:form commandName="user" method="post">
<f:select path="username" items="${userNameList}"></f:select>
<input type="submit" value="FindUser"/>
</f:form>