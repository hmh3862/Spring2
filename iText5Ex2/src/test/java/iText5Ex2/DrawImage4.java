package iText5Ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class DrawImage4 {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawImage3.pdf";
		String imgFileName = "src/main/resources/ship.png";
		Document document = null;
    	try {
    		document = new Document();
    		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
    		document.open();
			
			Image image = Image.getInstance(imgFileName); 
			document.add(image);

			PdfContentByte contentByte = writer.getDirectContent();
		    
		    image.setAbsolutePosition(170, 740);
		    contentByte.addImage(image);
		    image.setAbsolutePosition(35, 600);
		    // 지정크기로 변경
		    image.scaleAbsolute(200f, 50f);
		    contentByte.addImage(image);
		    
		    image.setAbsolutePosition(35, 500);
		    // 지정 Percent 크기로
		    image.scalePercent(50f);
		    contentByte.addImage(image);
		    
		    image.setAbsolutePosition(135, 400);
		    // 특정 너비와 높이에 맞도록 이미지의 크기를 조정합니다.
		    image.scaleToFit(-100f, 120f);
		    contentByte.addImage(image);
			
			document.close();
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
}
