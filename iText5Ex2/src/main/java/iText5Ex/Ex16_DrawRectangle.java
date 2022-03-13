package iText5Ex;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex16_DrawRectangle {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex16_DrawRectangle.pdf";
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
	        contentByte.setRGBColorStroke(0xFF, 0x00, 0x00); // 선색상
	        contentByte.rectangle(200,height-200,100, 100); // 영역
	        contentByte.stroke(); // 외곽선 그리기
	        contentByte.restoreState();

	        contentByte.saveState();
	        contentByte.setRGBColorStroke(0xFF, 0x00, 0x00); // 선색상
	        contentByte.setRGBColorFill(0xFF, 0x00, 0xFF); // 채우기 색상
	        contentByte.rectangle(220,height-220, 100, 100); // 영역
	        contentByte.fill(); // 배경그리기
	        contentByte.restoreState();
	        
	        contentByte.saveState();
	        contentByte.setLineWidth(3); // 테두리 두께
	        contentByte.setRGBColorStroke(0x00, 0x00, 0xFF); // 선색상
	        contentByte.setRGBColorFill(0x00, 0xFF, 0xFF); // 채우기 색상
	        contentByte.rectangle(240,height-240, 100, 100); // 영역
	        contentByte.fillStroke(); // 외각선과 배경 모두 그리기
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
