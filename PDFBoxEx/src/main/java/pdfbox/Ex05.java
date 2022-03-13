package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Ex05 {
	public static void main(String[] args) {
		String srcfileName = "pdf/ex01.pdf";
		String destfileName = "pdf/ex05.pdf";

		try (PDDocument document = PDDocument.load(new File(srcfileName));) {// 문서읽기

			PDPage page = document.getPage(0); // 페이지 얻기
			
			// 내용 추가하기 
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
			contentStream.newLineAtOffset(55, 720);
			String text = "This is the sample document and we are adding content to it.";
			contentStream.showText(text);
			contentStream.endText();
			System.out.println("내용 1줄 추가");
			contentStream.close();

			document.save(destfileName); // 저장
			System.out.println("PDF 페이지 저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 저장된 문서 보기
		String chrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		try {
			File file = new File(destfileName);
			new ProcessBuilder(chrome, file.getAbsolutePath()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
