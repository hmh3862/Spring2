package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Ex02 {
	public static void main(String[] args) {
		String srcfileName = "pdf/sample.pdf";
		String destfileName = "pdf/ex02.pdf";

		try (PDDocument document = PDDocument.load(new File(srcfileName));) {// 문서읽기
			System.out.println("PDF 읽기완료");
			document.addPage(new PDPage()); // 페이지 추가
			document.save(destfileName); // 저장
			System.out.println("PDF 페이지 추가 완료");
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
