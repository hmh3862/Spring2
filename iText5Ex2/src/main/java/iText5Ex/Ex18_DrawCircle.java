package iText5Ex;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex18_DrawCircle {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex18_DrawCircle.pdf";
		try {
			// 여백
			float marginLeft = 20, marginRight = 20, marginTop = 30, marginBottom = 30;
	        Document document = new Document(PageSize.A4, marginLeft, marginRight, marginTop, marginBottom);// 크기, 여백 좌, 우, 상, 하
	        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
	        document.open();
	        // 페이지 정보 출력
	        getPageInfo(document);
	        Rectangle rectangle = document.getPageSize();
	        float width = rectangle.getWidth();
	        float height = rectangle.getHeight();
	        System.out.println(width + ", " + height);

	        PdfContentByte contentByte = pdfWriter.getDirectContent();
	        // 여백을 제외한 부분에 사각형그리기
	        contentByte.saveState();
	        contentByte.setRGBColorStroke(0xFF, 0x45, 0x00); // 선색상
	        contentByte.rectangle(marginLeft, marginBottom, width-marginRight*2,height-marginTop*2); // 영역
	        contentByte.stroke(); // 그리기
	        contentByte.restoreState();

	        contentByte.saveState();
	        contentByte.setLineWidth(2); // 테두리 두께
	        contentByte.setRGBColorStroke(0x00, 0x00, 0xFF); // 선색상
	        contentByte.setRGBColorFill(0xFF, 0xFF, 0x00); // 채우기 색상
	        contentByte.rectangle(200, 200, 5,5);
	        contentByte.circle(200, 200, 50);
	        contentByte.stroke();
	        
	        contentByte.rectangle(250, 250, 5,5);
	        contentByte.circle(250, 250, 50);
	        contentByte.fillStroke();
	        
	        contentByte.circle(300, 300, 50);
	        contentByte.fill();
	        contentByte.rectangle(300, 300, 5,5);
	        contentByte.stroke();
	        contentByte.restoreState();

	        document.close();
			// 작성된 PDF문서 확인하기
			ChromeView.view(destFileName);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		} 
	}
	private static void getPageInfo(Document document) {
		Rectangle rectangle = document.getPageSize();
		System.out.println(rectangle);
		double width = PtMmConverter.pt2mm(rectangle.getWidth());
		double height = PtMmConverter.pt2mm(rectangle.getHeight());
		System.out.printf("크기 : (%.0f, %.0f)\n", width, height);
	}
}
