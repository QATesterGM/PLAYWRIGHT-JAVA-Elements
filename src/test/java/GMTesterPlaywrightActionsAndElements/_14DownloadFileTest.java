package GMTesterPlaywrightActionsAndElements;

import com.microsoft.playwright.Download;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class _14DownloadFileTest extends BaseTest {

    @Test
    void downloadWithHandlerTest() {
        page.navigate("http://localhost:7080/download");

        //HANDLER ZAWSZE PRZED KLIKNIECIEM
        page.onDownload(download -> download.saveAs(Paths.get("download/Ja i Furia.jpg")));
        page.getByText("Ja i Furia.jpg").click();

    }

    @Test //DRUGI SPOSOB - najpierw klikamy a pozniej zapisujemy
    void downloadWithSaveTest() {
        page.navigate("http://localhost:7080/download");

        //KLIKAMY
        Download download = page.waitForDownload(() -> page.getByText("Ja i Furia.jpg").click());

        //ZAPISUJEMY
        download.saveAs(Paths.get("download/Ja i Furia drugi sposob.jpg"));
    }
}
