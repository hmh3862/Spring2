package iText5Ex;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex10_ChunkStandardDeviation {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex10_ChunkStandardDeviation.pdf";
		float fontSize = 18;
		float leading = 28;
		try {
			Document document = new Document(PageSize.A4, 20, 20, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(leading);

			document.open();
			
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, fontSize);
			Chunk chunk = new Chunk("표준편차 기호는 Helvetica에 존재하지 않습니다.", font);
			document.add(chunk);
			
			document.add(Chunk.NEWLINE);
			
			Font symbol = new Font(FontFamily.SYMBOL);
			Phrase phrase = new Phrase("Symbol 글꼴 사용 : ", font);
			phrase.add(new Chunk("s", symbol));
			
			document.add(phrase);

			document.close();
			// 저장된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
