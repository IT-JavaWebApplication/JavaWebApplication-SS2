package com.example.bai3.controller;

import com.example.bai3.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/oders")
    public String viewOrders(HttpSession session, HttpServletRequest request) {
        // 1. Bảo mật: Kiểm tra Session
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // 2. Tạo Dữ liệu mẫu (Dùng ArrayList cho linh hoạt)
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("ORD-2024-001", "MacBook Pro M3", 45000000, new Date()));
        orders.add(new Order("ORD-2024-002", "iPhone 15 Pro Max", 32000000, new Date()));
        orders.add(new Order("ORD-2024-003", "Bàn phím cơ Keychron", 2500000, new Date()));
        orders.add(new Order("ORD-2024-004", "Chuột Logitech MX Master 3S", 2200000, new Date()));
        orders.add(new Order("ORD-2024-005", "Màn hình Dell UltraSharp 27 inch", 12500000, new Date()));

        // Đẩy vào Request Scope
        request.setAttribute("orderList", orders);

        // 3. Xử lý Application Scope (Bộ đếm toàn cục)
        ServletContext application = request.getServletContext();
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "oders"; // Trả về trang orders.jsp
    }
}