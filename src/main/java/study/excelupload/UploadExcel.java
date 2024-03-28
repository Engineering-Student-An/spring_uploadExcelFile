package study.excelupload;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadExcel {
    public static Map<String, String> uploadExcel(MultipartFile file) throws IOException {

        Map<String, String> student = new HashMap<>();

        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sheet.getRow(i);
            DataFormatter formatter = new DataFormatter();

            String id = formatter.formatCellValue(row.getCell(0));
            String name = formatter.formatCellValue(row.getCell(1));

            student.put(id, name);

        }

        return student;
    }
}
