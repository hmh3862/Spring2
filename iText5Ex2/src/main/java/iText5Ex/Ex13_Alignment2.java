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
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex13_Alignment2 {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex13_Alignment2.pdf";
		try {
			Document document = new Document(PageSize.A4, 30, 30, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));

			document.open();
			
			// 한글 폰트로 변경
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font fontTitle = new Font(baseFont, 20, Font.BOLD|Font.UNDERLINE);
			Font fontNomal = new Font(baseFont, 10);
			Font fontBold = new Font(baseFont, 15, Font.BOLD);			
			// 애국가 읽기
			String nationalAnthem = Files.readString(Paths.get("src/main/resources/NationalAnthem2.txt"));
			
			document.add(getPragraph("애국가", fontTitle, Element.ALIGN_CENTER));
			document.add(Chunk.NEWLINE);
			
			document.add(getPragraph("애국가(왼쪽정렬)", fontBold, Element.ALIGN_CENTER));
			document.add(getPragraph(nationalAnthem, fontNomal, 10,  Element.ALIGN_LEFT, 10));
			document.add(Chunk.NEWLINE);
			
			document.add(getPragraph("애국가(오른쪽정렬)", fontBold, Element.ALIGN_CENTER));
			document.add(getPragraph(nationalAnthem, fontNomal, 10,  Element.ALIGN_RIGHT, 20));
			document.add(Chunk.NEWLINE);

			document.add(getPragraph("애국가(가운데정렬)", fontBold, Element.ALIGN_CENTER));
			document.add(getPragraph(nationalAnthem, fontNomal, 10,  Element.ALIGN_CENTER, 30));
			document.add(Chunk.NEWLINE);

			document.add(getPragraph("애국가(양쪽정렬)", fontBold, Element.ALIGN_CENTER));
			document.add(getPragraph(nationalAnthem, fontNomal, 10,  Element.ALIGN_JUSTIFIED, 40));
			document.add(Chunk.NEWLINE);
			
			document.close();
			
			// 저장된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static Paragraph getPragraph(String content, Font font,int align){
		Paragraph paragraph = new Paragraph(content, font);
		paragraph.setAlignment(align);
		paragraph.setLeading(30);
		return paragraph;
	}
	private static Paragraph getPragraph(String content, Font font,float fontSize, int align, int leading){
		font.setSize(fontSize);
		Paragraph paragraph = new Paragraph(content, font);
		paragraph.setAlignment(align);
		paragraph.setLeading(leading); // 행간
		return paragraph;
	}	
}
