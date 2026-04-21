1. XSS là gì? Tại sao <c:out /> an toàn hơn ${ }?
   XSS (Cross-Site Scripting): Là lỗ hổng cho phép kẻ tấn công chèn các đoạn mã script độc hại (thường là JavaScript) vào trang web. Khi người dùng khác truy cập, trình duyệt sẽ thực thi đoạn mã này, dẫn đến mất cookie, chiếm quyền điều khiển phiên làm việc (session) hoặc thay đổi nội dung trang web.

So sánh:

${keyword}: Sẽ render dữ liệu thô. Nếu keyword là <script>alert(1)</script>, trình duyệt sẽ thực thi nó và hiện popup.

<c:out value="${keyword}" />: Có cơ chế mặc định escapeXml="true". Nó sẽ biến các ký tự đặc biệt thành thực thể HTML (HTML Entities).

Output sinh ra khi input là <script>alert(1)</script>:

Dùng ${ }: <script>alert(1)</script> (Trình duyệt thực thi mã).

Dùng <c:out />: &lt;script&gt;alert(1)&lt;/script&gt; (Trình duyệt chỉ hiển thị dưới dạng văn bản thuần, không thực thi).

2. Phân biệt <c:if> và <c:choose>
   <c:if>: Dùng cho các câu lệnh điều kiện đơn lẻ (chỉ có nhánh TRUE). Nếu muốn xử lý nhánh FALSE, ta phải dùng thêm một thẻ <c:if> với điều kiện ngược lại.

<c:choose>: Hoạt động tương tự switch-case hoặc if-else if-else. Nó cho phép kiểm tra nhiều điều kiện loại trừ lẫn nhau một cách logic và rõ ràng hơn.

Áp dụng: Trong bài này, phần "Giá vé" và "Vé còn lại" nên dùng <c:choose>.

Lý do: Vì các trạng thái (Miễn phí / Có phí) hoặc (Hết vé / Sắp hết / Còn vé) là các trạng thái loại trừ lẫn nhau. Dùng <c:choose> giúp code sạch hơn, dễ đọc và tránh việc hệ thống phải đánh giá nhiều thẻ <c:if> độc lập không cần thiết.

3. Vai trò của <c:url>
   Vấn đề giải quyết: <c:url> tự động xử lý Context Path của ứng dụng.

So sánh:

Nếu hardcode href="/events/1/book": Khi bạn deploy ứng dụng tại root (/), link sẽ chạy đúng. Nhưng nếu deploy với context path là /ticketing, link này sẽ dẫn đến localhost:8080/events/1/book (thiếu /ticketing/) và gây lỗi 404.

Dùng <c:url value="/events/1/book" />: JSTL sẽ tự động sinh ra URL chính xác là /ticketing/events/1/book bất kể ứng dụng được deploy ở đâu. Ngoài ra, nó còn hỗ trợ tự động chèn jsessionid vào URL nếu trình duyệt người dùng tắt Cookie.