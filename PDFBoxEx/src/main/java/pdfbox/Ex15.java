package pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class Ex15 {
	public static void main(String[] args) {
		String destfileName = "pdf/ex15.pdf";

		try (PDDocument document = new PDDocument();) {// 문서읽기

			PDPage page = new PDPage(); // 페이지 얻기
			document.addPage(page);
			
			// 내용 추가하기 
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();
			// 텍스트 행간 설정 
			contentStream.setLeading(18.5f);
			// 글꼴 설정
			InputStream in  = new FileInputStream("font/NanumGothicCoding.ttf");
			PDType0Font korfont = PDType0Font.load(document, in);
			contentStream.setFont(korfont, 25);		
			contentStream.newLineAtOffset(55, 720);
			String text1 = "제목입니다.";
			String text2 = "내용입니다. 하하하 한글은?";
			contentStream.showText(text1);
			contentStream.setFont(korfont, 11);		
			for(int i=0;i<10;i++) {
				contentStream.newLine();
				contentStream.showText(text2);
			}

			contentStream.endText();

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
