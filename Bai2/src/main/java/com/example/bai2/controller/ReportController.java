package com.example.bai2.controller;

// 1. Import các thư viện của Spring Framework
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 2. Import thư viện chuẩn của Java (dành cho List và ArrayList)
import java.util.ArrayList;
import java.util.List;

// 3. Import class Student của bạn
// (Dựa vào file JSP ở bài trước, có vẻ class Student nằm trong package com.demo.model)
import com.example.bai2.model.Student;

@Controller
public class ReportController {

    @GetMapping("/")
    public String redirectToReport() {
        return "redirect:/report";
    }

    @GetMapping("/report")
    public String showReport(Model model) {
        // Sau khi import, IDE đã hiểu List, ArrayList và Student là gì
        List<Student> students = new ArrayList<>();

        students.add(new Student("Nguyễn Thị Bình", 92));
        students.add(new Student("Trần Minh Khoa", 75));
        students.add(new Student("Lê Thu Hà", 55));
        students.add(new Student("Phạm Duy An", 48));

        // IDE đã nhận diện được phương thức addAttribute của Model
        model.addAttribute("studentList", students);
        model.addAttribute("reportTitle", "Báo cáo điểm cuối kỳ");

        return "report";
    }
}