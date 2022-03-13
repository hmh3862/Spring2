package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Ex08 {
	public static void main(String[] args) {
		String fileName = "pdf/ex08.pdf";
		String imgFileName = "src/main/resources/dog.jpg";
		try (PDDocument document = new PDDocument();) {// 문서읽기
			// 페이지 만들기
			PDPage page = new PDPage();
			// 그림 읽기
			PDImageXObject pdImage = PDImageXObject.createFromFile(imgFileName, document);
			PDPageContentStream contents = new PDPageContentStream(document, page);
			// 그림 출력
			contents.drawImage(pdImage, 15, 550);
			contents.drawImage(pdImage, 315, 550);
			contents.drawImage(pdImage, 15, 350);
			contents.drawImage(pdImage, 315, 350);
			contents.close();

			document.addPage(page);

			document.save(fileName); // 저장
			System.out.println("PDF에 그림 출력 완료");
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
