<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
  <title>Đăng nhập hệ thống</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 50px; }
    .login-container { border: 1px solid #ccc; padding: 20px; width: 300px; border-radius: 5px; }
    .error-msg { color: red; font-weight: bold; margin-bottom: 15px; }
    .form-group { margin-bottom: 15px; }
    .form-group label { display: block; margin-bottom: 5px; }
    .form-group input { width: 100%; padding: 8px; box-sizing: border-box; }
    button { padding: 10px 15px; background-color: #007BFF; color: white; border: none; border-radius: 3px; cursor: pointer; }
    button:hover { background-color: #0056b3; }
  </style>
</head>
<body>

<div class="login-container">
  <h2>Đăng nhập</h2>

  <%-- Bắt thông báo lỗi từ Request Scope (AuthController đẩy sang) --%>
  <c:if test="${not empty requestScope.error}">
    <div class="error-msg">${requestScope.error}</div>
  </c:if>

  <%-- Form gửi dữ liệu POST về đường dẫn /login --%>
  <form action="<c:url value='/login'/>" method="POST">
    <div class="form-group">
      <label>Tên đăng nhập:</label>
      <input type="text" name="username" required placeholder="Nhập admin hoặc staff" />
    </div>

    <div class="form-group">
      <label>Mật khẩu:</label>
      <input type="password" name="password" required placeholder="Nhập mật khẩu" />
    </div>

    <button type="submit">Đăng nhập</button>
  </form>

  <hr>
  <p style="font-size: 12px; color: #666;">
    <b>Tài khoản test:</b><br>
    - admin / admin123<br>
    - staff / staff123
  </p>
</div>

</body>
</html>