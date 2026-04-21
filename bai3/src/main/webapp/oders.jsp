<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Danh sách đơn hàng</title></head>
<body>
<h2>Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}</h2>

<table border="1">
    <tr>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.id}</td>
            <td>${order.name}</td>
            <td><fmt:formatNumber value="${order.price}" type="currency" currencySymbol="VNĐ"/></td>
            <td><fmt:formatDate value="${order.date}" pattern="dd/MM/yyyy"/></td>
        </tr>
    </c:forEach>
</table>

<hr>
<p>Tổng lượt xem toàn hệ thống: <b>${applicationScope.totalViewCount}</b></p>
<a href="<c:url value='/logout'/>">Đăng xuất</a>
</body>
</html>