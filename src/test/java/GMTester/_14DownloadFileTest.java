package GMTester;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class _14DownloadFileTest extends BaseTest {

    @Test
    void downloadWithHandlerTest(){
        page.navigate("http://localhost:7080/download");

        //HANDLER ZAWSZE PRZED KLIKNIECIEM
        page.onDownload(download -> download.saveAs(Paths.get("download/Ja i Furia.jpg")));
        page.waitForTimeout(3000);
        page.getByText("Ja i Furia.jpg").click();
        page.waitForTimeout(3000);
    }
}
