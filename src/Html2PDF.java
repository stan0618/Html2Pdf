import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class Html2PDF {
//    public static void main(String[] args) {
//        //Initial Document Object
//        try {
//
////            String str = Html2PDF.getHTML("http://xhtmlrenderer.java.net/news.html","big5");
////            System.out.println(Html2PDF.getHTML("http://xhtmlrenderer.java.net/news.html","big5"));
//
//            Document document = new Document();
//
//            //Initial PdfWriter, Assign document obj, and PDF ouput path
//
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/pd4ml1.pdf"));
//
//            document.open();
//
//            //中文字型檔路徑
//
//            String fontPath = "C:\\Users\\stan0\\Desktop\\jar\\pd4ml\\fonts\\mingliu.ttc";
//
//            //自訂字型物件
//
//            XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(fontPath);
//
//            FontFactory.setFontImp(fontImp);
//
//            //註冊FontFactory，定義Font Alias Name = mingliu
//            FontFactory.register(fontPath, "mingliu");
//
//            //Check是否註冊字型成功
//
//            System.out.println("IS mingliu?===" + FontFactory.isRegistered("mingliu"));
//
//            //Initial HTML轉換物件
//
//            XMLWorkerHelper xmlWorker = XMLWorkerHelper.getInstance();
//
//            //Parse HTML字串，要把自訂的FontProvider傳入
//            FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE);
//            xmlWorker.parseXHtml(writer, document, new FileInputStream("d:\\Test\\uu.html"), null, Charset.forName("utf-8"));
//            FontFactory.getFont(FontFactory.HELVETICA, 12, Font.UNDERLINE);
////            xmlWorker.parseXHtml(writer, document, new ByteArrayInputStream(str.getBytes("big5")), null, Charset.forName("big5"));
//
//            if (document != null) {
//                document.close();
//            }
//
//
//            System.out.println("PDF Created!");
//
//
//            //=========Finished=================
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    /**
     * 取得整個網頁的html
     * @param urlPath    網址,例如:http://tw.yahoo.com/
     * @param fmt        網頁編碼格式 utf8,big5
     * @return
     */
    public static String getHTML(String urlPath, String fmt){
        StringBuffer total = new StringBuffer();;

        try{
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream,fmt));
            String line="";

            while ((line = reader.readLine()) !=null ){
                total.append(line + "\n");
            }
            //System.out.println("檔案："+total);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("取得網頁html時發生錯誤");
        }
        return total.toString();
    }

     public Font getFont(String fontName, String encoding, boolean embedded, float size, int style, BaseColor color, boolean cached) {
        //可用Arial或标楷体，自己选一个
         BaseFont baseFont = null;
         try {
             BaseFont bf = BaseFont.createFont( "MHei-Medium", "UniCNS-UCS2-H", BaseFont.EMBEDDED );
         } catch (DocumentException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return new Font(baseFont, size, style, color);
    }

}
