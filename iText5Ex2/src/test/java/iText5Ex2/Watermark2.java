package iText5Ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class Watermark2 {
	public static void main(String[] args) {
		String destFileName = "pdf/Watermark.pdf";
		String imgFileName1 = "src/main/resources/a01.jpg";
		String imgFileName2 = "src/main/resources/a03.jpg";
		String imgFileName3 = "src/main/resources/ship2_1.png";

		Document document = null;
    	try {
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding-Bold.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 12);
			font.setColor(BaseColor.WHITE);

    		document = new Document();
    		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
    		pdfWriter.setInitialLeading(12);
			document.open();
			PdfContentByte contentByte = pdfWriter.getDirectContent();
			
			font.setSize(50);
			font.setColor(BaseColor.WHITE);
			document.add(getWatermarkedImage(contentByte, Image.getInstance(imgFileName1), font, "연습용"));
			document.add(getWatermarkedImage(contentByte, Image.getInstance(imgFileName2), font, "연습용"));
			font.setSize(15);
			document.add(getWatermarkedImage(contentByte, Image.getInstance(imgFileName3), font, "연습용"));
					
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
	public static Image getWatermarkedImage(PdfContentByte contentByte, Image img, Font font, String watermark) throws DocumentException {
        float width = img.getScaledWidth();
        float height = img.getScaledHeight();
        PdfTemplate template = contentByte.createTemplate(width, height);
        template.addImage(img, width, 0, 0, height, 0, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_CENTER, new Phrase(watermark, font), width / 2, height / 2, 30);
        return Image.getInstance(template);
    }	
}
