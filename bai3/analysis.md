1.Tại sao lỗi đăng nhập dùng Request Scope?
Lý do: Thông báo lỗi chỉ có giá trị ngay tại thời điểm đó. Nếu dùng Session, lỗi sẽ "ám" người dùng mãi cho đến khi họ đăng nhập thành công hoặc tắt trình duyệt, gây hiểu lầm là mình vẫn đang nhập sai dù đã tải lại trang.

Hệ quả nếu dùng nhầm Session: Người dùng F5 trang login vẫn thấy thông báo "Sai mật khẩu" dù chưa bấm nút gửi form lần nữa.

2.Tại sao totalViewCount dùng Application Scope?
Lý do: Application Scope tồn tại duy nhất một bản trên toàn server, dành cho mọi người dùng.

Nếu dùng Session: Mỗi nhân viên sẽ có một bộ đếm riêng. Nhân viên A xem 5 lần thì A thấy số 5, nhưng nhân viên B mới vào sẽ thấy số 0 (hoặc 1). Chúng ta sẽ không bao giờ biết được tổng lượt xem của toàn bộ cửa hàng.

3.Race Condition là gì?
Race Condition xảy ra khi hai hoặc nhiều luồng (threads/người dùng) cùng truy cập và cố gắng thay đổi một dữ liệu dùng chung cùng một lúc.

Phân tích đoạn code lỗi:

Luồng A đọc count (giả sử là 10).

Luồng B đọc count (cũng lấy được 10 vì A chưa kịp ghi đè).

Luồng A tăng lên 11 và lưu vào.

Luồng B cũng tăng lên 11 và lưu vào.
Kết quả đúng phải là 12, nhưng hệ thống chỉ ghi nhận 11. Một lượt xem đã bị "bốc hơi".

Cách khắc phục:
Sử dụng khối synchronized(application) { ... } để đảm bảo tại một thời điểm chỉ có duy nhất một luồng được quyền đọc-ghi bộ đếm, hoặc sử dụng AtomicInteger để xử lý biến này.