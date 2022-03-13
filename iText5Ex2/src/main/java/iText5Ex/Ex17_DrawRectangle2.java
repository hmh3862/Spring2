package iText5Ex;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex17_DrawRectangle2 {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex17_DrawRectangle2.pdf";
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
	        contentByte.rectangle(100,height-100, 50, 50); // 영역
	        contentByte.fillStroke(); // 외각선과 배경 모두 그리기
	        contentByte.rectangle(110,height-110, 50, 50); // 영역
	        contentByte.stroke(); // 외각선 그리기
	        contentByte.rectangle(120,height-120, 50, 50); // 영역
	        contentByte.fill(); // 배경 그리기
	        
	        // concatCTM : 행렬을 현재 변환 행렬에 연결합니다.
	        // 이동 (Translation) [1 0 0 1 tx ty]
	        contentByte.setRGBColorFill(0xFF, 0x00, 0xFF); // 채우기 색상
	        contentByte.concatCTM(1, 0, 0, 1, 50, -50); // 우측으로 50 아래로 50 이동
	        contentByte.rectangle(120,height-120, 50, 50); // 영역
	        contentByte.fillStroke(); // 외각선과 배경 모두 그리기
	        contentByte.restoreState();
	        
	        contentByte.saveState();
	        // 크기 변환 (Scaling) : [sx 0 0 sy 0 0] 
	        contentByte.setRGBColorStroke(0x00, 0x00, 0xFF); // 선색상
	        contentByte.setRGBColorFill(0x00, 0xFF, 0xFF); // 채우기 색상
	        contentByte.concatCTM(0.5f, 0, 0, 0.5f, 0, 0); 
	        contentByte.rectangle(200,200, 50, 50); // 영역
	        contentByte.fill(); // 배경 그리기
	        contentByte.restoreState();

	        contentByte.saveState();
	        contentByte.setRGBColorStroke(0x00, 0x00, 0xFF); // 선색상
	        contentByte.setRGBColorFill(0xFF, 0xFF, 0x00); // 채우기 색상
	        contentByte.concatCTM(0.5f, 0, 0, 1f, 0, 0); 
	        contentByte.rectangle(250, 100, 50, 50); // 영역
	        contentByte.fillStroke(); // 외각선과 배경 모두 그리기
	        contentByte.restoreState();
	        
	        contentByte.saveState();
	        contentByte.setRGBColorStroke(0x00, 0x00, 0xFF); // 선색상
	        contentByte.setRGBColorFill(0xFF, 0x33, 0x00); // 채우기 색상
	        contentByte.concatCTM(2f, 0, 0, 0.5f, 0, 0); 
	        contentByte.rectangle(150, 200, 50, 50); // 영역
	        contentByte.fillStroke(); // 외각선과 배경 모두 그리기
	        contentByte.restoreState();
	        
	        /* Rotation: [cos(q) sin(q) -sin(q) cos(q) 0 0]
	        *   90 degrees CCW: [0 1 -1 0 0 0]
	        * 	180 degrees: [-1 0 0 -1 0 0]
	        *	270 degrees: [0 -1 1 0 0 0]
	        *   Skew: [1 tan(a) tan(b) 1 0 0]
	        */
	        contentByte.saveState();
	        contentByte.setRGBColorStroke(0x00, 0xFF, 0x00); // 선색상
	        contentByte.setRGBColorFill(0x55, 0xFF, 0x77); // 채우기 색상
	        contentByte.concatCTM(1, 0, 0.3f, 1, 0, 0); 
	        contentByte.rectangle(200, 100, 25, 50); // 영역
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
