<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Import thư viện JSTL Core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <%-- Đã thay đổi: Sử dụng JSP Comment để người dùng không thể xem được từ Source code trình duyệt --%>
  <title>Báo cáo điểm</title>
</head>
<body>
<%-- Đã thay đổi: Sử dụng Expression Language (EL) để lấy tiêu đề --%>
<h1>${reportTitle}</h1>

<%-- Đã xóa bỏ toàn bộ phần hiển thị lượt xem trang và biến đếm bị lỗi --%>

<table border="1">
  <tr>
    <th>STT</th>
    <th>Họ tên</th>
    <th>Điểm</th>
    <th>Xếp loại</th>
  </tr>

  <%-- Đã thay đổi: Sử dụng c:forEach thay cho vòng lặp for của Java --%>
  <c:forEach items="${studentList}" var="sv" varStatus="status">

    <%-- Đã thay đổi: Sử dụng c:choose để tính toán xếp loại thay cho if/else --%>
    <c:choose>
      <c:when test="${sv.score >= 90}">
        <c:set var="rank" value="Xuất sắc" />
      </c:when>
      <c:when test="${sv.score >= 80}">
        <c:set var="rank" value="Giỏi" />
      </c:when>
      <c:when test="${sv.score >= 70}">
        <c:set var="rank" value="Khá" />
      </c:when>
      <c:when test="${sv.score >= 60}">
        <c:set var="rank" value="Trung bình khá" />
      </c:when>
      <c:when test="${sv.score >= 50}">
        <c:set var="rank" value="Trung bình" />
      </c:when>
      <c:otherwise>
        <c:set var="rank" value="Yếu" />
      </c:otherwise>
    </c:choose>

    <tr>
        <%-- Trạng thái status.index bắt đầu từ 0, cộng 1 để lấy số thứ tự --%>
      <td>${status.index + 1}</td>

        <%-- Đã thay đổi: Sử dụng c:out để chống lại tấn công XSS --%>
      <td><c:out value="${sv.fullName}"/></td>

        <%-- Đã thay đổi: Sử dụng EL và xóa lỗi dư dấu chấm phẩy --%>
      <td>${sv.score}</td>
      <td>${rank}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>