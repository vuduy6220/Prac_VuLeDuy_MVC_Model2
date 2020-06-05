<%--
  Created by IntelliJ IDEA.
  User: vuduy
  Date: 6/5/2020
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <h2>Login Form</h2>
  <div>
    <form action="login" method="post">
      <div>
        <span style="color: red">
        <c:out value="${param.msg}"/>
      </span>
      </div>
      <div>
        Username: <input type="text" name="username">
      </div>
      <div>
        Passowrd: <input type="password" name="password">
      </div>
      <div>
        <button>Login</button>
      </div>
    </form>
  </body>
</html>
