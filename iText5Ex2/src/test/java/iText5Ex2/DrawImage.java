package iText5Ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class DrawImage {
	static String urlAddress="https://avatars.githubusercontent.com/u/5889165?s=200&v=4";
	public static void main(String[] args) {
		String destFileName = "pdf/DrawImage.pdf";
		String imgFileName1 = "src/main/resources/logo.jpg";
		String imgFileName2 = "src/main/resources/logo.gif";
		String imgFileName3 = "src/main/resources/logo.png";
		String imgFileName4 = "src/main/resources/logo.tif";
		String imgFileName5 = "src/main/resources/logo.bmp";
		Document document = null;
    	try {
    		document = new Document();
    		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();
			PdfContentByte contentByte = writer.getDirectContent();
			// 화면 중앙에 배치
			Image img1 = Image.getInstance(urlAddress); // 원격이미지 얻기
		    img1.setAbsolutePosition((PageSize.A4.getWidth() - img1.getScaledWidth()) / 2,
		                (PageSize.A4.getHeight() - img1.getScaledHeight()) / 2); // 표시할 절대 좌표
		    
		    contentByte.addImage(img1);
		    System.out.println(img1);
		    // 다양한 형식의 이미지 얻기
		    Image img2 = Image.getInstance(imgFileName1);
		    System.out.println(img2);
		    
		    img2.setAbsolutePosition(50, 50);
		    contentByte.addImage(img2);
		    
		    Image img3 = Image.getInstance(imgFileName2);
		    img3.setAbsolutePosition(50+img2.getWidth(), 50);
		    contentByte.addImage(img3);
			
		    Image img4 = Image.getInstance(imgFileName3);
		    img4.setAbsolutePosition(50, 50+img2.getHeight());
		    contentByte.addImage(img4);
		    
		    Image img5 = Image.getInstance(imgFileName4);
		    img5.setAbsolutePosition(50+img2.getWidth(), 50+img2.getHeight());
		    contentByte.addImage(img5);
		    
		    Image img6 = Image.getInstance(imgFileName5);
		    img6.setAbsolutePosition(50, 50+img2.getHeight()*2);
		    contentByte.addImage(img6);
		    
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
