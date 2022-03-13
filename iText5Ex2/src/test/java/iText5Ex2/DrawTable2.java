package iText5Ex2;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class DrawTable2 {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawTable2.pdf";
		try {
			Document document = new Document();
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 10);
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();
			
			PdfPTable table = new PdfPTable(4);
			PdfPCell cell = new PdfPCell(new Paragraph(String.format("%d행 %d열", 1,1), font));
			// 행 결합
			cell.setRowspan(2);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.format("%d행 %d열", 1,2), font));
			// 열 결합
			cell.setColspan(2);
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.format("%d행 %d열", 1,3), font));
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.format("%d행 %d열", 2,2), font));
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph(String.format("%d행 %d열", 2,3), font));
			cell.setColspan(2);
			table.addCell(cell);
			
			document.add(table);
			
			document.close();
			ChromeView.view(destFileName);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}

	}
}
