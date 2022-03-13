package iText5Ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class Watermark {
	public static void main(String[] args) {
		String destFileName = "pdf/Watermark.pdf";
		String imgFileName = "src/main/resources/background.jpg";
		Document document = null;
    	try {
			BaseFont baseFont1 = BaseFont.createFont("font/NanumGothicCoding.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			BaseFont baseFont2 = BaseFont.createFont("font/NanumGothicCoding-Bold.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font1 = new Font(baseFont1, 10);
			Font font2 = new Font(baseFont2, 12);

    		document = new Document();
    		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
    		pdfWriter.setInitialLeading(12);
			document.open();
			PdfContentByte contentByte = pdfWriter.getDirectContent();
			// 배경이미지 출력
			Image image = Image.getInstance(imgFileName);
			image.scaleAbsolute(595f, 842f);
		    image.setAbsolutePosition(0, 0);
		    // 이미지 투명도 지정
		    PdfGState state = new PdfGState();
		    state.setFillOpacity(0.5f);
		    contentByte.setGState(state);
		    contentByte.addImage(image);
		    contentByte.beginText();
		    contentByte.setFontAndSize(baseFont1, 150);
		    contentByte.showTextAligned(Element.ALIGN_LEFT, "SAMPLE", 140, 80, 30);
		    contentByte.showTextAligned(Element.ALIGN_LEFT, "SAMPLE", 140, 280, 30);
		    contentByte.showTextAligned(Element.ALIGN_LEFT, "SAMPLE", 140, 480, 30);
		    contentByte.endText();
		    
		    String content = Files.readString(Paths.get("src/main/resources/NationalAnthem2.txt"));
		    document.add(new Paragraph(content, font1));
		    document.add(new Paragraph(content, font2));
		    
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
