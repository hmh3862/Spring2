package pdfbox;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class Ex14 {
	public static void main(String[] args) {
		String fileName = "pdf/ex14.pdf";
		try (PDDocument document = new PDDocument();) {// 문서읽기
			// 페이지 만들기
			PDPage page = new PDPage();

			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.setNonStrokingColor(Color.CYAN);
			contentStream.addRect(200, 650, 100, 100);
			contentStream.fill();
			contentStream.setNonStrokingColor(Color.RED);
			contentStream.addRect(210, 660, 80, 80);
			contentStream.fill();
			System.out.println("사각형 그리기");
			contentStream.close();

			document.addPage(page);

			document.save(fileName); // 저장
			System.out.println("저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 저장된 문서 보기
		String chrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		try {
			File file = new File(fileName);
			new ProcessBuilder(chrome, file.getAbsolutePath()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
