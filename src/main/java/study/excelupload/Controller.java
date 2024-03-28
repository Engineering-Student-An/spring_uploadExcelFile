package study.excelupload;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("students", new HashMap<>());

        return "upload";
    }

    @PostMapping("")
    public String upload(@RequestParam("excelFile")MultipartFile file, Model model) throws IOException {

        Map<String, String> studentInfo = UploadExcel.uploadExcel(file);

        model.addAttribute("students", studentInfo);
        return "upload";
    }
}
