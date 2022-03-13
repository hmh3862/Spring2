package iText5Ex2;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;
/*
셀 정렬
다음 setHorizontalAlignment()과 setVerticalAlignment()같이 및 를 사용하여 셀 정렬을 설정할 수 있습니다 .
cell.setHorizontalAlignment(Element.ALIGN_LEFT);
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
cell.setVerticalAlignment(Element.ALIGN_TOP);
cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
 */
public class DrawTable4 {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawTable4.pdf";
		try {
			Document document = new Document();
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 10);
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();
			
			PdfPTable table = new PdfPTable(3);
			
			PdfPCell cell = new PdfPCell(new Paragraph("1행 1열", font));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("1행 2열", font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("1행 3열", font));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("2행 1열", font));
			cell.setFixedHeight(80f);
			cell.setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("2행 2열", font));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("2행 3열", font));
			cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell(cell);

			cell = new PdfPCell(new Paragraph("3행 1열", font));
			cell.setFixedHeight(130f);
			cell.setVerticalAlignment(Element.ALIGN_TOP);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("3행 2열", font));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("3행 3열", font));
			cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);

			document.add(table);
			
			document.close();
			ChromeView.view(destFileName);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}

	}
}
