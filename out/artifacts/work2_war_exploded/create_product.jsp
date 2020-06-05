<%--
  Created by IntelliJ IDEA.
  User: vuduy
  Date: 6/5/2020
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <c:if test="${sessionScope.bean == null}">
    <jsp:forward page="index.jsp"></jsp:forward>
  </c:if>
  <title>Create product</title>
</head>
<body>

  <h2>Create product</h2>
  <form action="create_product" method="post">
    <div>
      <span>Name</span>
      <input type="text" name="name" />
    </div>
    <div>
      <span>Description</span>
      <input type="text" name="description" />
    </div>
    <div>
      <button>Create</button>
    </div>
  </form>
</body>
</html>
