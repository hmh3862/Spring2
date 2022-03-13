package iText5Ex2;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfWriter;

import iText5Ex.ChromeView;

public class ItemList2 {
	public static void main(String[] args) {
		String destFileName = "pdf/ItemList2.pdf";
    	try {
    		Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(destFileName));
			document.open();
			
		    // 서브리스트 만들기
		    List nestedList = new List(List.UNORDERED);
		    nestedList.add(new ListItem("Item 1"));
		 
		    List sublist = new List(true, false, 20);
		    sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
		    sublist.add("A");
		    sublist.add("B");
		    nestedList.add(sublist);
		 
		    nestedList.add(new ListItem("Item 2"));
		 
		    sublist = new List(false, true, 40);
		    sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 8)));
		    sublist.add("C");
		    sublist.add("D");
		    nestedList.add(sublist);
		 
		    document.add(nestedList);

			document.close();
			ChromeView.view(destFileName);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		} 
	}
}
