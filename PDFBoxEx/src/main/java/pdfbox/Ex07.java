package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Ex07 {
	public static void main(String[] args) {
		String srcfileName = "pdf/ex06.pdf";

		try (PDDocument document = PDDocument.load(new File(srcfileName));) {// 문서읽기
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(document);
			System.out.println("읽은 내용");
			System.out.println(text);

			System.out.println("PDF 페이지 내용 읽기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
