package iText5Ex;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex07_ChunkBackground {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex07_ChunkBackground.pdf";
		float fontSize = 25;
		float leading  = 28;
		try {
			Document document = new Document(PageSize.A4, 20, 20, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(leading); // 행간지정

			document.open();
			// 한글 폰트로 변경
			BaseFont baseFont1 = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font1 = new Font(baseFont1, fontSize);
			font1.setColor(BaseColor.GREEN);
			BaseFont baseFont2 = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font2 = new Font(baseFont2, fontSize);
			font2.setColor(BaseColor.MAGENTA);

			// 지정한 font를 이용하여 Chunk객체를 만듭니다.
			Chunk chunk1 = new Chunk("Green text on pink background", font1);
			// 배경색을 지정합니다.
			chunk1.setBackground(BaseColor.PINK);
			// 문서에 붙입니다.
			document.add(chunk1);
			// 빈줄을 삽입합니다.
			document.add(Chunk.NEWLINE);

			Chunk chunk2 = new Chunk("PINK 바탕에 MAGENTA 글씨 입니다.", font2);
			chunk2.setBackground(BaseColor.PINK);
			document.add(chunk2);
			document.add(Chunk.NEWLINE);
			
			// 닫기
			document.close();
			// 작성된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
