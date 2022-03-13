package iText5Ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex25_AddMetaData {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex25_AddMetaData.pdf";
		try {
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7); // PDF버전 변경(기본 1.4)
			document.open();
			// 문서의 속성을 추가한다.
			document.addTitle("My Title");
			document.addSubject("My Subject");
			document.addKeywords("My Keyword");
			document.addAuthor("My Auther");
			document.addCreator("My Creator");
			document.addProducer();
			document.addCreationDate();
			
			document.add(new Chunk(""));
			document.close();
			ChromeView.view(destFileName);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} 
	}
}
