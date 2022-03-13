package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Ex06 {
	public static void main(String[] args) {
		String srcfileName = "pdf/ex01.pdf";
		String destfileName = "pdf/ex06.pdf";

		try (PDDocument document = PDDocument.load(new File(srcfileName));) {// 문서읽기

			PDPage page = document.getPage(0); // 페이지 얻기

			// 내용 추가하기
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 11);
			// 텍스트 행간 설정 
			contentStream.setLeading(14.5f);
			contentStream.newLineAtOffset(55, 720);
			String text1 = "This is an example of adding text to a page in the pdf document. we can add as many lines";
			String text2 = "as we want like this using the ShowText()  method of the ContentStream class";
			contentStream.showText(text1);
			for(int i=0;i<10;i++) {
				contentStream.newLine();
				contentStream.showText(text2);
			}
			contentStream.endText();
			System.out.println("내용 여러줄 추가");
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
