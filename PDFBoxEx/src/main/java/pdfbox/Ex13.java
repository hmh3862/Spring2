package pdfbox;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class Ex13 {
	public static void main(String[] args) {
		String fileName = "pdf/domain.pdf";
		try (PDDocument document = PDDocument.load(new File(fileName));) {
			int numberOfPages = document.getNumberOfPages();
			PDFRenderer renderer = new PDFRenderer(document);
			for(int i=0;i<numberOfPages;i++) {
				BufferedImage image = renderer.renderImage(i);
				ImageIO.write(image, "JPEG", new File("pdf/domain"+(i+1)+".jpg"));
			}
			System.out.println("PDF를 그림 으로 저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 저장된 그림 보기
		String chrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		try {
			File file = new File("pdf/domain1.jpg");
			new ProcessBuilder(chrome, file.getAbsolutePath()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
