package pdfbox;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class Ex11 {
	public static void main(String[] args) {
		String srcfileName = "pdf/domain.pdf";

		try (PDDocument document = PDDocument.load(new File(srcfileName));) {// 문서읽기
			// PDF문서 분리하기
			Splitter splitter = new Splitter();
			List<PDDocument> Pages = splitter.split(document);
			Iterator<PDDocument> iterator = Pages.listIterator();

			int i = 1;
			while (iterator.hasNext()) {
				PDDocument pd = iterator.next();
				pd.save("pdf/domain" + i++ + ".pdf");
			}
			System.out.println("PDF파일 페이지별 저장 완료!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
