<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Khai báo thư viện JSTL theo chuẩn Jakarta EE (Tomcat 10+) --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<html>
<head>
    <title>Tìm kiếm sự kiện</title>
    <style>
        .sold-out { color: red; font-weight: bold; }
        .low-stock { color: orange; }
        .available { color: green; }
        .badge-free { background-color: #28a745; color: white; padding: 2px 5px; border-radius: 4px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .disabled-link { color: gray; pointer-events: none; text-decoration: none; }
    </style>
</head>
<body>

<h2>
    Kết quả tìm kiếm cho:
    <c:out value="${keyword}" default="(Trống)" escapeXml="true" />
</h2>

<p>Tìm thấy <strong>${fn:length(events)}</strong> sự kiện.</p>

<c:choose>
    <%-- Trường hợp không có dữ liệu --%>
    <c:when test="${empty events}">
        <p>Không tìm thấy sự kiện nào phù hợp.</p>
    </c:when>

    <%-- Trường hợp có dữ liệu --%>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>STT</th>
                <th>Tên sự kiện</th>
                <th>Ngày tổ chức</th>
                <th>Giá vé</th>
                <th>Vé còn lại</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${events}" var="event" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>
                            <%-- Chống XSS cho tên sự kiện --%>
                        <c:out value="${event.name}" />
                    </td>
                    <td>${event.date}</td>
                    <td>
                        <c:choose>
                            <c:when test="${event.price == 0}">
                                <span class="badge-free">MIỄN PHÍ</span>
                            </c:when>
                            <c:otherwise>
                                <fmt:formatNumber value="${event.price}" type="number" /> VNĐ
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${event.remainingTickets == 0}">
                                <span class="sold-out">HẾT VÉ</span>
                            </c:when>
                            <c:when test="${event.remainingTickets < 10}">
                                <span class="low-stock">Sắp hết (còn ${event.remainingTickets} vé)</span>
                            </c:when>
                            <c:otherwise>
                                <span class="available">${event.remainingTickets}</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:url var="bookUrl" value="/events/${event.id}/book" />
                        <c:choose>
                            <c:when test="${event.remainingTickets == 0}">
                                <span class="disabled-link">Đặt vé</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${bookUrl}">Đặt vé</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<hr>
<footer>
    <c:if test="${not empty events}">
        <p>Sự kiện nổi bật: <strong>${fn:toUpperCase(events[0].name)}</strong></p>
    </c:if>
    <p>Độ dài từ khóa: ${fn:length(keyword)} ký tự.</p>
</footer>

</body>
</html>