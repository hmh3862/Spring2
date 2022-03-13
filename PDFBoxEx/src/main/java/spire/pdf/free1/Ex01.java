package spire.pdf.free1;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfLayoutType;
import com.spire.pdf.graphics.PdfRGBColor;
import com.spire.pdf.graphics.PdfSolidBrush;
import com.spire.pdf.graphics.PdfStringFormat;
import com.spire.pdf.graphics.PdfTextAlignment;
import com.spire.pdf.graphics.PdfTextLayout;
import com.spire.pdf.graphics.PdfTextWidget;
import com.spire.pdf.graphics.PdfTrueTypeFont;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		PdfDocument doc = new PdfDocument();

		PdfPageBase page = doc.getPages().add();

		String heading = "Java - Overview";

		PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.BLUE));

		PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Times New Roman", Font.PLAIN, 20));

		PdfStringFormat format1 = new PdfStringFormat();
		format1.setAlignment(PdfTextAlignment.Center);
		page.getCanvas().drawString(heading, font1, brush1,
				new Point2D.Float((float) page.getActualBounds(true).getWidth() / 2, 0), format1);

		PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.BLACK));
		PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		String content = Files.readString(Paths.get("src/main/resources/NationalAnthem.txt"));
		PdfTextWidget widget = new PdfTextWidget(content, font2, brush2);
		Rectangle2D.Float rect = new Rectangle2D.Float(0, 30, (float) page.getActualBounds(true).getWidth(),
				(float) page.getActualBounds(true).getHeight());
		PdfTextLayout layout = new PdfTextLayout();
		layout.setLayout(PdfLayoutType.Paginate);
		widget.draw(page, rect, layout);

		doc.saveToFile("CreatePdf.pdf");
	}
}
