package iText5Ex;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

///텍스트의 입력에 있어서 3개의 클래스를 가지고 있다.
// Chunk - Phrase - Paragraph 를 가지고 있으며 Chunk 가 가장 작은 단위의 표현이다.
public class Ex06_ChunkPhraseParagraph {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex06_ChunkPhraseParagraph.pdf";
		try {
			Document document = new Document(PageSize.A4, 20, 20, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(26); // 행간지정

			document.open();
			// Chunk - Phrase - Paragraph 차이점
			document.add(new Chunk("Hello", FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD)));
			document.add(new Phrase("PDF", FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC))); // 옆으로
			document.add(new Paragraph("WORLD", FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL))); // 줄분리
			// 줄바꿈
			document.add(Chunk.NEWLINE);

			// 한글 폰트로 변경
			BaseFont baseFont = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font = new Font(baseFont, 10);
			BaseFont baseFont2 = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font2 = new Font(baseFont2, 25);
			font2.setColor(BaseColor.RED);

			// 조각 만들고
			Chunk chunk1 = new Chunk("하나", font);
			chunk1.setBackground(BaseColor.PINK);

			Chunk chunk2 = new Chunk("둘", font2);
			chunk2.setBackground(BaseColor.PINK);

			Chunk chunk3 = new Chunk("셋", font2);
			chunk3.setBackground(BaseColor.CYAN);

			// 조각을 이용하여 구절만들고
			Phrase phrase1 = new Phrase();
			phrase1.add(chunk1);
			phrase1.add(chunk2);

			Phrase phrase2 = new Phrase();
			phrase2.add(chunk3);

			// 구절을 이용하여 문단을 만들고
			Paragraph paragraph = new Paragraph();
			paragraph.add(phrase1);
			paragraph.add(phrase2);

			// 문서에 추가 한다.
			document.add(paragraph);
			// 닫기
			document.close();
			// 작성된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
