package iText5Ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class DrawImage2 {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawImage2.pdf";
		String imgFileName = "src/main/resources/ship.png";
		Document document = null;
		try {
			document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();
			PdfContentByte contentByte = writer.getDirectContent();
	        // 여백을 제외한 부분에 사각형그리기
			float marginLeft = 20, marginRight = 20, marginTop = 30, marginBottom = 30;
			Rectangle rectangle = document.getPageSize();
	        float width = rectangle.getWidth();
	        float height = rectangle.getHeight();
	        contentByte.saveState();
	        contentByte.setRGBColorStroke(0xFF, 0x45, 0x00); // 선색상
	        contentByte.rectangle(marginLeft, marginBottom, width-marginRight*2,height-marginTop*2); // 영역
	        contentByte.stroke(); // 그리기
	        contentByte.restoreState();
	        
			// Image img = Image.getInstance(urlAddress);
			Image img = Image.getInstance(imgFileName);
			float imgWidth = img.getWidth();
			float imgHeight = img.getHeight();
			// addImage((이미지, 이미지폭, 0, 0,이미지높이, x좌표, y좌표)
			contentByte.addImage(img, imgWidth, 0, 0, imgHeight, 50, 700);// 50,700에 원본크기
			contentByte.addImage(img, imgWidth, 0, 0, imgHeight/2, 50, 700-imgHeight);// 높이만 1/2로 줄임
			contentByte.addImage(img, imgWidth/2, 0, 0, imgHeight, 50, 700-imgHeight*2); // 폭만 1/2로 줄임
			contentByte.addImage(img, imgWidth/2, 0, 0, imgHeight/2, 50, 700-imgHeight*3); // 폭, 높이 모두 1/2로 줄임
			contentByte.addImage(img, imgWidth*2, 0, 0, imgHeight*2, 50, 700-imgHeight*5); // 4배 확대
			// 이미지 기울림(이미지, 이미지폭,우측하단 y좌표값변위 , 좌측상단 x좌표변경변위,이미지높이, x좌표, y좌표)
			contentByte.addImage(img, imgWidth, 0, 0, imgHeight, 300, 700); 
			contentByte.addImage(img, imgWidth, 0, 10, imgHeight, 300, 700-imgHeight*2);
			contentByte.addImage(img, imgWidth, 0, 20, imgHeight, 300, 700-imgHeight*2);
			contentByte.addImage(img, imgWidth, 0, 30, imgHeight, 300, 700-imgHeight*2);
			contentByte.addImage(img, imgWidth, 0, 40, imgHeight, 300, 700-imgHeight*2);
			contentByte.addImage(img, imgWidth, 10, 0, imgHeight, 300, 700-imgHeight*4);
			contentByte.addImage(img, imgWidth, 20, 0, imgHeight, 300, 700-imgHeight*4);
			contentByte.addImage(img, imgWidth, 30, 0, imgHeight, 300, 700-imgHeight*4);
			contentByte.addImage(img, imgWidth, 40, 0, imgHeight, 300, 700-imgHeight*4);
			contentByte.addImage(img, imgWidth, 10, 10, imgHeight, 300, 700-imgHeight*6);
			contentByte.addImage(img, imgWidth, 20, 20, imgHeight, 300, 700-imgHeight*6);
			contentByte.addImage(img, imgWidth, 30, 30, imgHeight, 300, 700-imgHeight*6);
			contentByte.addImage(img, imgWidth, 40, 40, imgHeight, 300, 700-imgHeight*6);
			contentByte.addImage(img, imgWidth, 0, -10, imgHeight, 300, 700-imgHeight*8);
			contentByte.addImage(img, imgWidth, 0, -20, imgHeight, 300, 700-imgHeight*8);
			contentByte.addImage(img, imgWidth, 0, -30, imgHeight, 300, 700-imgHeight*8);
			contentByte.addImage(img, imgWidth, 0, -40, imgHeight, 300, 700-imgHeight*8);
			contentByte.addImage(img, imgWidth, -10, 0, imgHeight, 300, 700-imgHeight*10);
			contentByte.addImage(img, imgWidth, -20, 0, imgHeight, 300, 700-imgHeight*10);
			contentByte.addImage(img, imgWidth, -30, 0, imgHeight, 300, 700-imgHeight*10);
			contentByte.addImage(img, imgWidth, -40, 0, imgHeight, 300, 700-imgHeight*10);
			document.close();
			ChromeView.view(destFileName);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (document != null)
				document.close();
		}
	}
}
