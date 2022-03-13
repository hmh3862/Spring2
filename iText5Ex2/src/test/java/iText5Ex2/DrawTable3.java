package iText5Ex2;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;
/*
셀 텍스트 모드 및 합성 모드
셀은 텍스트 모드 또는 합성 모드에서 추가할 수 있습니다.
텍스트 모드에서는 추가된 요소( Phrase, Paragraph등)의 설정이 무시됩니다. 셀의 설정만 적용됩니다.
복합 모드에서는 추가된 요소의 설정이 적용됩니다. 따라서 행간(줄 간격), 여백 등과 같은 설정이 적용됩니다.
PdfCell의 생성자에 추가된 콘텐츠 는 텍스트 모드 콘텐츠로 간주됩니다. 
PdfCell.addElement()메서드 를 통해 추가된 콘텐츠는 복합 모드 콘텐츠로 간주됩니다.
 */
public class DrawTable3 {
	public static void main(String[] args) {
		String destFileName = "pdf/DrawTable3.pdf";
		try {
			Document document = new Document();
			BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 10);
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();
			
			PdfPTable table = new PdfPTable(2);
			Paragraph paragraph = new Paragraph("셀 텍스트 모드", font);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			paragraph.setLeading(20);
			PdfPCell textModeCell = new PdfPCell(paragraph);
			
			paragraph = new Paragraph("합성 모드", font);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			paragraph.setLeading(20);
			PdfPCell compositeModeCell = new PdfPCell();
			compositeModeCell.addElement(paragraph);
			
			table.addCell(textModeCell);
			table.addCell(compositeModeCell);

			
			table.addCell(new Paragraph("셀 텍스트 모드", font));
			
			PdfPCell defaultCell = table.getDefaultCell();
			System.out.println(defaultCell);
			defaultCell.setPadding(15);
			defaultCell.setBorderWidth(4f);
			defaultCell.setBorderColor(BaseColor.RED);

			table.addCell(new Paragraph("default text mode cell 1"));
			table.addCell(new Phrase("default text mode cell 2"));
			table.addCell(new Phrase("default text mode cell 3"));
			
			document.add(table);
			
			document.close();
			ChromeView.view(destFileName);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}

	}
}
