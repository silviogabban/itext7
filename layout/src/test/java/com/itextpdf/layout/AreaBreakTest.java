package com.itextpdf.layout;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.test.annotations.type.IntegrationTest;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.test.ExtendedITextTest;


import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class AreaBreakTest extends ExtendedITextTest {

    static final public String sourceFolder = "./src/test/resources/com/itextpdf/layout/AreaBreakTest/";
    static final public String destinationFolder = "./target/test/com/itextpdf/layout/AreaBreakTest/";

    @BeforeClass
    static public void beforeClass() {
        createDestinationFolder(destinationFolder);
    }

    @Test
    public void pageBreakTest1() throws IOException,  InterruptedException {
        String outFileName = destinationFolder + "pageBreak1.pdf";
        String cmpFileName = sourceFolder + "cmp_pageBreak1.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream(outFileName)));

        Document document = new Document(pdfDocument);
        document.add(new AreaBreak());

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, destinationFolder, "diff"));
    }

    @Test
    public void pageBreakTest2() throws IOException,  InterruptedException {
        String outFileName = destinationFolder + "pageBreak2.pdf";
        String cmpFileName = sourceFolder + "cmp_pageBreak2.pdf";
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream(outFileName)));

        Document document = new Document(pdfDocument);
        document.add(new Paragraph("Hello World!")).add(new AreaBreak(new PageSize(200, 200)));

        document.close();

        Assert.assertNull(new CompareTool().compareByContent(outFileName, cmpFileName, destinationFolder, "diff"));
    }

}