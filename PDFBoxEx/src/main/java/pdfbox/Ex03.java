package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class Ex03 {
	public static void main(String[] args) {
		String srcfileName = "pdf/ex01.pdf";
		String destfileName = "pdf/ex03.pdf";

		try (PDDocument document = PDDocument.load(new File(srcfileName));) {// 문서읽기
			System.out.println("PDF 읽기완료");
			int numberOfPages = document.getNumberOfPages(); // 전체 페이지수 얻기
			System.out.println("전체페이지 : " + numberOfPages + "페이지");
			document.removePage(numberOfPages-1); // 페이지 삭제(index 0부터 시작)
			document.save(destfileName); // 저장
			System.out.println("PDF 페이지 제거 완료");
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
