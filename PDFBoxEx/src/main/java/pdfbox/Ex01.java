package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Ex01 {
	public static void main(String[] args) {
		String fileName = "pdf/ex01.pdf";
		try (PDDocument document = new PDDocument();) {// 문서작성
			for (int i = 0; i < 3; i++) {
				PDPage blankPage = new PDPage(); // 페이지 작성
				document.addPage(blankPage); // 페이지 추가
			}
			document.save(fileName); // 저장
			System.out.println("PDF 작성완료");
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
