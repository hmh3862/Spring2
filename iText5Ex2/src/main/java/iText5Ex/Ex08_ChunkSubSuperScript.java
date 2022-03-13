package iText5Ex;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex08_ChunkSubSuperScript {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex08_ChunkSubSuperScript.pdf";
		float fontSize = 25;
		float leading  = 28;
		try {
			Document document = new Document(PageSize.A4, 20, 20, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(leading);

			document.open();
			
			// 윗첨자, 아래첨자
			// https://www.htmlsymbols.xyz 이곳에서 코드값 확인이 가능하다.
			BaseFont baseFont1 = BaseFont.createFont("font/Cardo-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	        Font font1 = new Font(baseFont1, fontSize);
	        Paragraph paragraph1 = new Paragraph("H\u2082SO\u2074", font1);
	        document.add(paragraph1);
	        
	        // Emoji Icon 출력
	        BaseFont baseFont2 = BaseFont.createFont("font/NotoEmoji-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	        Font font2 = new Font(baseFont2, fontSize);
	        font2.setColor(BaseColor.RED);
	        Paragraph paragraph2 = new Paragraph("\uD83D\uDC96\uD83D\uDE3B\uD83C\uDFAF", font2);
	        document.add(paragraph2);
			
			document.close();
			// 저장된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
