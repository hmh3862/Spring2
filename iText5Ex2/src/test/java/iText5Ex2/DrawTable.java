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

public class DrawTable {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawTable.pdf";
		try {
			Document document = new Document();
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 10);
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();

			document.add(makeTable(3, 5, font)); // 3행 5열
			
			PdfPTable table = makeTable(2, 3, font);
			// 위아래 여백 지정
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);
			table.setWidthPercentage(60f); // 폭지정
			document.add(table);
			
			table = makeTable(3, 4, font);
			// 열의 폭지정
			float[] columnWidths = {1f, 2f, 3f, 4f};
			table.setWidths(columnWidths);
			// 위아래 여백 지정
			table.setSpacingAfter(10f);
			table.setWidthPercentage(60f); // 폭지정
			document.add(table);

			document.close();
			ChromeView.view(destFileName);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}

	}

	private static PdfPTable makeTable(int rows, int colums, Font font) {
		PdfPTable table = new PdfPTable(colums); 
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=colums;j++) {
				PdfPCell cell = new PdfPCell(new Paragraph(String.format("%d행 %d열", i,j), font));
				table.addCell(cell);
			}
		}
		return table;
	}
}
