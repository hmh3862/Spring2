package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
/*
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk16</artifactId>
    <version>1.46</version>
</dependency>
 */
public class Ex09 {
	public static void main(String[] args) {
		String fileName = "pdf/ex09.pdf";
		String imgFileName = "src/main/resources/dog.jpg";
		try (PDDocument document = new PDDocument();) {// 문서읽기
			// 페이지 만들기
			PDPage page = new PDPage();
			
			// 암호화 하기
			AccessPermission ap = new AccessPermission();
			StandardProtectionPolicy spp = new StandardProtectionPolicy("1234", "1234", ap);
			spp.setEncryptionKeyLength(128);
			spp.setPermissions(ap);
			document.protect(spp);

			// 그림 읽기
			PDImageXObject pdImage = PDImageXObject.createFromFile(imgFileName, document);
			PDPageContentStream contents = new PDPageContentStream(document, page);
			// 그림 출력
			contents.drawImage(pdImage, 15, 550);
			contents.close();

			document.addPage(page);

			document.save(fileName); // 저장
			System.out.println("PDF에 암호화 저장 완료");
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
