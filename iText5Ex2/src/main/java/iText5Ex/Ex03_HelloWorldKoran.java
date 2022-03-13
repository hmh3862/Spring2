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

public class Ex03_HelloWorldKoran {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex03_HelloWorldKoran.pdf";
		try {
			// 1. 문서 작성
			Document document = new Document();
			// 2. 출력 지정
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			// 3. 열기
			document.open();
			// 4. 문단 작성
			// 4) 한글 입력을 위해 폰트를 선택해줍니다. iTextAsian.jar에서는 다음 3개의 폰트를 사용할 수 있습니다.
			// HYGoThic-Medium, HYSMyeongJo-Medium, HYSMyeongJoStd-Medium
			String fontFace = "HYGoThic-Medium";
			String fontFace2 = "HYSMyeongJo-Medium";

			// 5) 글자 방향을 결정하는 CMap은 두가지가 있습니다.
			// UniKS-UCS2-H : 가로, UniKS-UCS2-V : 세로
			String fontNameH = "UniKS-UCS2-H";
			String fontNameV = "UniKS-UCS2-V";

			// 6) 준비한 설정값들을 활용해 Font 객체를 생성해줍니다. 생성자에 들어가는 인자는 BaseFont 와 사이즈 입니다.
			BaseFont bf = BaseFont.createFont(fontFace, fontNameH, BaseFont.NOT_EMBEDDED);
			BaseFont bf2 = BaseFont.createFont(fontFace2, fontNameV, BaseFont.NOT_EMBEDDED);
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
