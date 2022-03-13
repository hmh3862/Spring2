package iText5Ex;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex09_ChunkOrdinalNumbers {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex09_ChunkOrdinalNumbers.pdf";
		float fontSize = 10;
		float leading = 28;
		try {
			Document document = new Document(PageSize.A4, 20, 20, 30, 30); // 페이지 사이즈와 좌우상하 여백
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(leading);

			document.open();
			// Chunk 클래스는 기준선을 기준으로 텍스트 변위를 설정하는 setTextRise 메서드를 제공합니다.
			// 양수 값 상승 텍스트, 음수 값은 텍스트를 낮춥니다.
			Font small = new Font(FontFamily.HELVETICA, fontSize);
			Chunk st = new Chunk("st", small);
			st.setTextRise(7);
			Chunk nd = new Chunk("nd", small);
			nd.setTextRise(8);
			Chunk rd = new Chunk("rd", small);
			rd.setTextRise(9);
			Chunk th = new Chunk("th", small);
			th.setTextRise(10);
			
			Paragraph first = new Paragraph();
			first.add("The 1");
			first.add(st);
			first.add(" of May");
			document.add(first);
			
			Paragraph second = new Paragraph();
			second.add("The 2");
			second.add(nd);
			second.add(" and the 3");
			second.add(rd);
			second.add(" of June");
			document.add(second);
			
			Paragraph fourth = new Paragraph();
			fourth.add("The 4");
			fourth.add(rd);
			fourth.add(" of July");
			document.add(fourth);

			document.close();
			// 저장된 문서 보기
			ChromeView.view(destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
