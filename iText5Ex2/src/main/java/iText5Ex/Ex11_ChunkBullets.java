package iText5Ex;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex11_ChunkBullets {
	 public static final String[] ITEMS = {
		        "Insurance system", "Agent", "Agency", "Agent Enrollment", "Agent Settings",
		        "Appointment", "Continuing Education", "Hierarchy", "Recruiting", "Contract",
		        "Message", "Correspondence", "Licensing", "Party"
		    };
	
	public static void main(String[] args) {
		String destFileName = "pdf/Ex11_ChunkBullets.pdf";
		float fontSize = 10;
		float leading = 28;
		try {
			Document document = new Document(PageSize.A4, 20, 20, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(leading);

			document.open();
			
			Font zapfdingbats = new Font(FontFamily.ZAPFDINGBATS, 8);
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, fontSize);

	        Chunk bullet = new Chunk(String.valueOf((char) 108), zapfdingbats);
	        
	        Paragraph paragraph = new Paragraph("아이템 ", font);
	        document.add(paragraph);
	        font.setSize(10);
	        for (String item: ITEMS) {
	        	Paragraph paragraph1 = new Paragraph();
	        	paragraph1.add(bullet);
	        	paragraph1.add(new Phrase(" " + item , font));
	        	document.add(paragraph1);
	        }
	        document.add(Chunk.NEWLINE);
	        
	        font.setSize(15);
	        paragraph = new Paragraph("아이템 ", font);
	        document.add(paragraph);
	        
	        font.setSize(10);
	        font.setColor(BaseColor.BLACK);

	        BaseFont baseFont2 = BaseFont.createFont("font/NotoEmoji-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	        Font font2 = new Font(baseFont2, 10);
	        font2.setColor(BaseColor.RED);
	        for (String item: ITEMS) {
	        	Paragraph paragraph1 = new Paragraph("\uD83C\uDFAF", font2);
	        	paragraph1.add(new Phrase(" " + item, font));
	        	document.add(paragraph1);
	        }
	        document.add(Chunk.NEWLINE);
			document.close();
			// 저장된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
