package iText5Ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex02_HelloWorld {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex02_HelloWorld.pdf";
		Document document = null;
    	try {
    		// 1. 문서 작성
    		document = new Document();
    		// 2. 출력 지정
    		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			// 3. 열기
			document.open();

			// 4. 문단 작성
			document.add(new Paragraph("Hello World!"));
			// 이미지 넣기
			String imageFile = "src/main/resources/logo.jpg"; 
			addImage(writer, imageFile, 10, 750);
			// 5. 닫기
			document.close();
			// 작성된 PDF문서 확인하기
			ChromeView.view(destFileName);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(document!=null) document.close();
		}
	}
	// 지정 위치에 이미지 넣기
	private static void addImage(PdfWriter writer, String imageFile, float x, float y)
		throws BadElementException, MalformedURLException, IOException, DocumentException {
		PdfContentByte canvas = writer.getDirectContentUnder();
		Image image = Image.getInstance(imageFile);
		image.setAbsolutePosition(x, y);
		canvas.addImage(image);
	}
}
