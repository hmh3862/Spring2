package iText5Ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex01_BlankPage {
	public static void main(String[] args) {
		File file = new File("pdf");
		if(!file.exists()) {
			file.mkdir();
		}
		String destFileName = "pdf/Ex01_BlankPage.pdf";
		Document document = null;
    	try {
    		// 1. 문서 작성
    		document = new Document();
    		// 2. 출력 지정
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			// 3. 열기
			document.open();
			// 문서의 크기 출력 
			getPageInfo(document);
			// 4. 빈 내용 작성
			document.add(new Chunk(""));
			// 5. 닫기
			document.close();
			// 작성된 PDF문서 확인하기
			ChromeView.view(destFileName);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} finally {
			if(document!=null) document.close();
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
