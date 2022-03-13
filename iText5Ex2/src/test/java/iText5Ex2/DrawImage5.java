package iText5Ex2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class DrawImage5 {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawImage5.pdf";
		String urlAddress = "https://avatars.githubusercontent.com/u/5889165?s=200&v=4";
		Document document = null;
		try {
			document = new Document(PageSize.A4, 20, 20, 20, 20);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			Rectangle rectangle = document.getPageSize();
			float width = rectangle.getWidth();
			float height = rectangle.getHeight();
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 15);
			document.open();

			Image image = Image.getInstance(urlAddress);
			PdfContentByte contentByte = writer.getDirectContent();
			// 이미지 투명도 지정
			PdfGState state = new PdfGState();
			state.setFillOpacity(0.5f);
			contentByte.setGState(state);
			image.setAbsolutePosition(0, 0);
			// 용지 크기로 변경
			image.scaleAbsolute(width, height);
			contentByte.addImage(image);
			for (int i = 1; i <= 10; i++)
				document.add(new Paragraph("나는 어떻게 표시될까요?", font));

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
