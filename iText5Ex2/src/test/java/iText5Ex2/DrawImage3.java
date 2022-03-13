package iText5Ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class DrawImage3 {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawImage3.pdf";
		String imgFileName = "src/main/resources/ship.png";
		Document document = null;
    	try {
    		document = new Document();
    		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFileName));

    		document.open();
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 10);
			String text = "나는 어디에 나타날까요?";
			Phrase phrase = new Phrase(text, font);
	        
			Image img = Image.getInstance(imgFileName); 
			document.add(phrase);
			document.add(phrase);
			document.add(img);
			
			document.add(new Paragraph(phrase));
			document.add(new Paragraph(phrase));
			document.add(img);
			
			//  Chunk(final Image image, final float offsetX, final float offsetY, final boolean changeLeading)
			phrase.add(new Chunk(img, 0, 0, true));
			phrase.add("호호호");
			phrase.add(new Chunk(img, 0, 0, true));
			document.add(new Paragraph(phrase));
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			document.add(img);
			PdfContentByte contentByte = writer.getDirectContent();
			ColumnText columnText = new ColumnText(contentByte);
			Phrase phrase2 = new Phrase("여러줄의 문장입니다,\n그림옆으로 나타납니다.\n하하하하", font);
			// setSimpleColumn(Phrase phrase, float llx, float lly, float urx, float ury, float leading, int alignment) {
			columnText.setSimpleColumn(phrase2, 160, 530, 310, 465, 15, Element.ALIGN_LEFT);
			columnText.go();
			// 사각형 그리기
			contentByte.saveState();
	        contentByte.rectangle(160, 530, 150,-65); // 영역
	        contentByte.stroke(); // 그리기
	        contentByte.restoreState();

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
