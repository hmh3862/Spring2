package pdfbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class Ex12 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String fileName = "pdf/ex12.pdf";
		PDFMergerUtility PDFmerger = new PDFMergerUtility();
		PDFmerger.setDestinationFileName(fileName);
		try {
			for (int i = 1; i <= 3; i++) {
				PDFmerger.addSource(new File("pdf/domain" + i + ".pdf"));
			}
			PDFmerger.mergeDocuments();
			System.out.println("PDF파일 합치기 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
