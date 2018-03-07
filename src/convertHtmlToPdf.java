

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;


import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

public class convertHtmlToPdf {

    protected int topValue = 10;
    protected int leftValue = 20;
    protected int rightValue = 10;
    protected int bottomValue = 10;
    protected int userSpaceWidth = 1300;

//    public static void main(String[] args) {
//        try {
//            convertHtmlToPdf jt = new convertHtmlToPdf();
//            jt.doConversion("file:///D:/Test/popup%20(1).html", "d:/pd4ml.pdf");
////            jt.doConversion("http://xhtmlrenderer.java.net/news.html", "d:/pd4ml.pdf");
//            File pdfFile = new File("d:/pd4ml.pdf");
//            StringBuffer html = new StringBuffer();
////            html.append("<html>")
////                    .append("<head>")
////                    .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />")
////                    .append("</head>")
////                    .append("<body>")
////                    .append("<font face=\"KaiTi_GB2312\">")
////                    .append("<font color='red' size=22>显示中文</font>")
////                    .append("</font>")
////                    .append("</body></html>");
//            StringReader strReader = new StringReader(html.toString());
//            jt.generatePDF_1(pdfFile, strReader);
////            demo_1();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    public void generatePDF_1(File outputPDFFile, StringReader strReader) throws Exception {
        FileOutputStream fos = new FileOutputStream(outputPDFFile);
        PD4ML pd4ml = new PD4ML();
        pd4ml.setPageInsets(new Insets(20, 10, 10, 10));
        pd4ml.setHtmlWidth(950);
        pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));
        pd4ml.useTTF("java:fonts", true);
        pd4ml.setDefaultTTFs("SimHei", "Arial", "Courier New");
        pd4ml.enableDebugInfo();
        pd4ml.render(strReader, fos);
    }

    public void doConversion( String url, String outputPath )
            throws InvalidParameterException, MalformedURLException, IOException {
        File output = new File(outputPath);
        java.io.FileOutputStream fos = new java.io.FileOutputStream(output);

        PD4ML pd4ml = new PD4ML();
        pd4ml.useTTF("C:\\Users\\stan0\\Desktop\\jar\\pd4ml\\fonts", true); //F:/Test/fonts
        pd4ml.setDefaultTTFs("mingliu", "mingliu", "mingliu");
        pd4ml.setHtmlWidth(userSpaceWidth); // set frame width of "virtual web browser"

        // choose target paper format and "rotate" it to landscape orientation
        pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));

        // define PDF page margins
        pd4ml.setPageInsetsMM(new Insets(topValue, leftValue, bottomValue, rightValue));

        // source HTML document also may have margins, could be suppressed this way
        // (PD4ML *Pro* feature):
        pd4ml.addStyle("BODY {margin: 0}", true);

        // If built-in basic PDF fonts are not sufficient or
        // if you need to output non-Latin texts,
        // TTF embedding feature should help (PD4ML *Pro*)
        pd4ml.useTTF("c:/windows/fonts", true);

        pd4ml.render(new URL(url), fos); // actual document conversion from URL to file
        fos.close();

        System.out.println( outputPath + "\ndone." );
    }

    public static void demo_1() throws Exception
    {
        String inputFile = "D:/Test/Northeastern University_ a leader in global experiential learning in Boston, MA.html";
        String url = new File( inputFile ).toURI().toURL().toString();
        String outputFile = "D:/Test/123.pdf";
        OutputStream os = new FileOutputStream( outputFile );
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument( url );
        renderer.layout();
        renderer.createPDF( os );
        os.close();
    }


//    public void convertHtmlToPdf(String inputFile, String outputFile)
//            throws Exception {
//        OutputStream os = new FileOutputStream(outputFile);
//        ITextRenderer renderer = new ITextRenderer();
//        String url = new File(inputFile).toURI().toURL().toString();
//        renderer.setDocument(url);
//// 解决中文支持问题
//        ITextFontResolver fontResolver = renderer.getFontResolver();
//        fontResolver.addFont("C:/Windows/Fonts/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
////解决图片的相对路径问题
//        renderer.layout();
//        renderer.createPDF(os);
//        os.flush();
//        os.close();
//    }
}
