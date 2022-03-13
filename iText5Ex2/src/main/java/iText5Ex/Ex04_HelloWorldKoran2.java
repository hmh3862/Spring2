package iText5Ex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex04_HelloWorldKoran2 {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex04_HelloWorldKoran2.pdf";
		try {
			// 1. 문서 작성
			Document document = new Document();
			// 2. 출력 지정
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			// 3. 열기
			document.open();
			// 4. 문단 작성
			// 폰트 파일을 이용한 폰트 작성
			BaseFont bf = BaseFont.createFont("font/NanumGothicCoding.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			BaseFont bf2 = BaseFont.createFont("font/NanumGothicCoding-Bold.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 10);
			Font font2 = new Font(bf2, 12);

			String content = Files.readString(Paths.get("src/main/resources/NationalAnthem2.txt"));
			document.add(new Paragraph(content, font));
			document.add(new Paragraph(" ", font));
			document.add(new Paragraph("안녕하세요 iText로 만든 PDF파일 입니다.", font));
			document.add(new Paragraph("안녕하세요 iText로 만든 PDF파일 입니다.", font2));

			// 5. 닫기
			document.close();

			// 저장된 문서 보기
			ChromeView.view(destFileName);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
}
