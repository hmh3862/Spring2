package iText5Ex2;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.GreekList;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class ItemList {
	public static void main(String[] args) {
		String destFileName = "pdf/ItemList.pdf";
    	try {
    		Document document = new Document();
    		BaseFont baseFont = BaseFont.createFont("font/NanumGothicCoding.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 10);
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();
			
			List orderedList = new List(List.ORDERED);
			for(int i=1;i<=3;i++) orderedList.add(new ListItem(String.format("Item %02d", i)));
            document.add(orderedList);
            document.add(Chunk.NEWLINE);
            
            List unorderedList = new List(List.UNORDERED);
            for(int i=1;i<=3;i++) unorderedList.add(new ListItem(String.format("아이템 %02d", i), font));
            document.add(unorderedList);
            document.add(Chunk.NEWLINE);

            RomanList romanList = new RomanList();
            for(int i=1;i<=3;i++) romanList.add(new ListItem(String.format("아이템 %02d", i), font));
            document.add(romanList);
            document.add(Chunk.NEWLINE);
            
            GreekList greekList = new GreekList();
            for(int i=1;i<=3;i++) greekList.add(new ListItem(String.format("아이템 %02d", i), font));
            document.add(greekList);
            document.add(Chunk.NEWLINE);
            
            for(int cnt=41;cnt<=50; cnt++) {
	            ZapfDingbatsList zapfDingbatsList = new ZapfDingbatsList(cnt, (cnt-40)*5);
	            for(int i=1;i<=3;i++) zapfDingbatsList.add(new ListItem(String.format("아이템 %02d", i), font));
	            document.add(zapfDingbatsList);
	            document.add(Chunk.NEWLINE);
            }
			document.close();
			ChromeView.view(destFileName);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		} 
	}
}
