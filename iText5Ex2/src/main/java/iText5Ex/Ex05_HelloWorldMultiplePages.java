package iText5Ex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex05_HelloWorldMultiplePages {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex05_HelloWorldMultiplePages.pdf";
		try {
			// 1. 문서 작성
			Document document = new Document();
			// 2. 출력 지정
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			// 3. 열기
			document.open();
			// 4. 문단 작성
			BaseFont bf = BaseFont.createFont("font/NanumGothicCoding.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 15);

			String content = Files.readString(Paths.get("src/main/resources/NationalAnthem2.txt"));
			for(int i=1;i<=4;i++) {
				document.add(new Paragraph(i + "번째 페이지 입니다.", font));
				document.add(new Paragraph(" ", font));
				document.add(new Paragraph(content, font));
				document.newPage();
			}
			// 5. 닫기
			document.close();

			// 페이지 번호 달기
			PdfReader reader = new PdfReader(destFileName);
	        int n = reader.getNumberOfPages();
	        String destFileName2 = "pdf/Ex05_HelloWorldMultiplePages2.pdf";
	        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destFileName2));
	        PdfContentByte pagecontent;
	        for (int i = 0; i < n; ) {
	            pagecontent = stamper.getOverContent(++i);
	            ColumnText.showTextAligned(pagecontent, Element.ALIGN_RIGHT, new Phrase(String.format("%s/%s Page", i, n)), 559, 806, 0);
	        }
	        stamper.close();
	        reader.close();
			// 저장된 문서 보기
			// ChromeView.view(destFileName);
			ChromeView.view(destFileName2);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
}
