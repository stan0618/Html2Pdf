import java.awt.Insets;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.net.URL;

import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

import com.lowagie.text.FontFactory;

public class rrr {
    public static void main(String[] args) throws Exception {
        rrr converter = new rrr();
        converter.generatePDF_2(new File("d:/demo_ch_pd4ml2_a.pdf"), "D:/Test/Northeastern University_ a leader in global experiential learning in Boston, MA.html");
        File pdfFile = new File("d:/demo_ch_pd4mlssss.pdf");
    }

    public void generatePDF_2(File outputPDFFile, String inputHTMLFileName) throws Exception {
        FileOutputStream fos = new FileOutputStream(outputPDFFile);
        PD4ML pd4ml = new PD4ML();
        pd4ml.setPageSize(PD4Constants.A4);
        pd4ml.setHtmlWidth(793);
        pd4ml.setPageInsets(new Insets(5, 20, 20, 20));
        pd4ml.useTTF("C:\\Users\\stan0\\Desktop\\jar\\pd4ml\\fonts", true); //F:/Test/fonts
        pd4ml.setDefaultTTFs("SimSun", "SimSun", "SimSun");
        pd4ml.enableDebugInfo();
        pd4ml.render("file:"+inputHTMLFileName, fos);
//        pd4ml.render(new URL("http://yahoo.com.tw/yahoo.htm"), fos);
    }
}
