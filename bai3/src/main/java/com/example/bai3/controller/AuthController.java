package com.example.bai3.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    // 1. HÀM MỚI THÊM: Hiển thị giao diện đăng nhập (GET request)
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Đi tìm file login.jsp để hiển thị
    }

    // 2. Xử lý khi người dùng bấm nút "Đăng nhập" (POST request)
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("username") String username, // Thêm ("username")
            @RequestParam("password") String password, // Thêm ("password")
            HttpSession session,
            HttpServletRequest request) {

        if ("admin".equals(username) && "admin123".equals(password)) {
            session.setAttribute("loggedUser", "Quản trị viên Hệ thống");
            session.setAttribute("role", "ADMIN");
            return "redirect:/oders"; // Lưu ý: Nếu ở file trên bạn cấu hình là /orders thì chỗ này phải là /orders nhé
        } else if ("staff".equals(username) && "staff123".equals(password)) {
            session.setAttribute("loggedUser", "Nguyễn Văn Nhân Viên");
            session.setAttribute("role", "STAFF");
            return "redirect:/oders";
        } else {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            return "login";
        }
    }

    // 3. Xử lý khi bấm "Đăng xuất"
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Xóa session
        return "redirect:/login"; // Đẩy về lại trang đăng nhập (sẽ gọi vào hàm số 1 ở trên)
    }

    // 4. Bổ sung thêm hàm trang chủ (tránh lỗi 404 khi gõ đường dẫn gốc)
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
}