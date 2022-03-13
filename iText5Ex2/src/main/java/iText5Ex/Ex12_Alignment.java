package iText5Ex;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

public class Ex12_Alignment {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex12_Alignment.pdf";
		float fontSize = 18;
		float leading = 28;
		try {
			Document document = new Document(PageSize.A4, 30, 30, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(leading);

			document.open();
			
			// 한글 폰트로 변경
			BaseFont baseFont1 = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font1 = new Font(baseFont1, fontSize);
			BaseFont baseFont2 = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font2 = new Font(baseFont2, fontSize);
			
			Chunk title= new Chunk("월간 보고서", font1);
			Phrase phrase1 = new Phrase();
			phrase1.add(title);
			Paragraph paragraph1 = new Paragraph();
			paragraph1.add(phrase1);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph1);
			
			font2.setSize(fontSize-8);
			Chunk subTitle = new Chunk("작성자 : 한사람", font2);
			Phrase phrase2 = new Phrase();
			phrase2.add(subTitle);
			Paragraph paragraph2 = new Paragraph();
			paragraph2.add(phrase2);
			paragraph2.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragraph2);
			
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			Chunk glue = new Chunk(new VerticalPositionMark());
			Paragraph paragraph3 = new Paragraph();
			paragraph3.add(new Chunk("왼쪽",font2));
			paragraph3.add(glue);
			paragraph3.add(new Chunk("가운데",font2));
			paragraph3.add(glue);
			paragraph3.add(new Chunk("오른쪽",font2));
			document.add(paragraph3);

			document.add(Chunk.NEWLINE);
			String nationalAnthem = Files.readString(Paths.get("src/main/resources/NationalAnthem2.txt"));
			Paragraph paragraph4 = new Paragraph(nationalAnthem, font2);
			paragraph4.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph4);
			document.add(Chunk.NEWLINE);
			paragraph4.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph4);
			document.add(Chunk.NEWLINE);
			paragraph4.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragraph4);
			document.add(Chunk.NEWLINE);
			paragraph4.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paragraph4);
			
			document.close();
			
			// 저장된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
