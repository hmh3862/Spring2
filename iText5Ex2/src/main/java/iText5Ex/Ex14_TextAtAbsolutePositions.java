package iText5Ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Ex14_TextAtAbsolutePositions {
	public static void main(String[] args) {
		String destFileName = "pdf/Ex14_TextAtAbsolutePositions.pdf";
		try {
			// 1. 문서 작성
			Document document = new Document();
			// 2. 출력 지정
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			pdfWriter.setInitialLeading(12);
			
			// 3. 열기
			document.open();
			BaseFont baseFont1 = BaseFont.createFont("font/NanumGothicCoding.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			BaseFont baseFont2 = BaseFont.createFont("font/NanumGothicCoding-Bold.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font1 = new Font(baseFont1, 10);
			Font font2 = new Font(baseFont2, 12);

			String text = "나는 어디에 나타날까요?";
			PdfContentByte contentByte = pdfWriter.getDirectContent();
			contentByte.saveState(); // 현재 상태 저장
			contentByte.setLineWidth(0.05f);// 선의 폭
			// 수직선 2개
	        contentByte.moveTo(400, 806);
	        contentByte.lineTo(400, 626);
	        contentByte.moveTo(508, 806);
	        contentByte.lineTo(508, 626);
	        // 수평선 5개
	        contentByte.moveTo(280, 788);
	        contentByte.lineTo(520, 788);
	        contentByte.moveTo(280, 752);
	        contentByte.lineTo(520, 752);
	        contentByte.moveTo(280, 716);
	        contentByte.lineTo(520, 716);
	        contentByte.moveTo(280, 680);
	        contentByte.lineTo(520, 680);
	        contentByte.moveTo(280, 644);
	        contentByte.lineTo(520, 644);
	        contentByte.stroke(); // 그리기
	        contentByte.restoreState();		// 상태폭원	
			// 텍스트 출력 : PdfContentByte를 이용한 출력
			contentByte.beginText();
			contentByte.setFontAndSize(baseFont1, 12);
			contentByte.showTextAligned(Element.ALIGN_LEFT, text+1, 400, 788, 0);
			contentByte.showTextAligned(Element.ALIGN_RIGHT, text+2, 400, 752, 0);
			contentByte.showTextAligned(Element.ALIGN_CENTER, text+3, 400, 716, 0);
			contentByte.showTextAligned(Element.ALIGN_CENTER, text+4, 400, 680, 30);// 마지막 인수 회전 각도
			contentByte.showTextAlignedKerned(Element.ALIGN_LEFT, text+5, 400, 644, 0);
			contentByte.endText();
			
			// 선그리기
			contentByte.saveState();
	        contentByte.setLineWidth(0.05f);
	        // 수직선 2개
	        contentByte.moveTo(200, 590);
	        contentByte.lineTo(200, 410);
	        contentByte.moveTo(400, 590);
	        contentByte.lineTo(400, 410);
	        // 수평선 5개
	        contentByte.moveTo(80, 572);
	        contentByte.lineTo(520, 572);
	        contentByte.moveTo(80, 536);
	        contentByte.lineTo(520, 536);
	        contentByte.moveTo(80, 500);
	        contentByte.lineTo(520, 500);
	        contentByte.moveTo(80, 464);
	        contentByte.lineTo(520, 464);
	        contentByte.moveTo(80, 428);
	        contentByte.lineTo(520, 428);
	        contentByte.stroke();
	        contentByte.restoreState();
	        // ColumnText.showTextAligned()을 이용한 텍스트 출력
	        font2.setColor(BaseColor.BLUE);
	        Phrase phrase = new Phrase(text+6, font2);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_LEFT, phrase, 200, 572, 0);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_RIGHT, phrase, 200, 536, 0);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_CENTER, phrase, 200, 500, 0);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_CENTER, phrase, 200, 464, 30);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_CENTER, phrase, 200, 428, -30);
	        
	        // Chunk 속성을 변경한 출력
	        Chunk chunk = new Chunk(text+7, font1);
	        chunk.setHorizontalScaling(0.5f); // 크기 변경
	        phrase = new Phrase(chunk);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_LEFT, phrase, 400, 572, 0);
	        chunk = new Chunk(text+8, font1);
	        chunk.setSkew(15, 15); // 비스듬한 정도
	        phrase = new Phrase(chunk);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_LEFT, phrase, 400, 536, 0);
	        chunk = new Chunk(text+9, font1);
	        chunk.setSkew(0, 15);
	        phrase = new Phrase(chunk);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_LEFT, phrase, 400, 500, 0);
	        chunk = new Chunk(text+10, font1);
	        chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_STROKE, 0.1f, BaseColor.RED); // 모드,두께,색상
	        phrase = new Phrase(chunk);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_RIGHT, phrase, 400, 464, 0);
	        chunk = new Chunk(text+11, font1);
	        chunk.setTextRenderMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE, 2, BaseColor.BLUE);
	        phrase = new Phrase(chunk);
	        ColumnText.showTextAligned(contentByte, Element.ALIGN_CENTER, phrase, 400, 428, -0);			
			// 5. 닫기
			document.close();
			// 작성된 PDF문서 확인하기
			ChromeView.view(destFileName);
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
