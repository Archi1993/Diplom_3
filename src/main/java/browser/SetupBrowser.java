package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * Принимает три переменных окружения
 * browserType - Тип браузера (CHROME или YANDEX)
 * chromeBrowserPath - путь до исполняемого файла хрома - если не писать в проперти берет из строки private final static String PATH_CHROMEBROWSER_EXE
 * yandexBrowserPath - путь до исполняемого файла яндекс-браузера - если не писать в проперти берет из строки private final static String PATH_YANDEXBROWSER_EXE
 *
 */

public class SetupBrowser {
    private final static Browser CURRENT_BROWSER = Objects.nonNull(System.getProperty("browserType")) ? Browser.valueOf(System.getProperty("browserType").toUpperCase()) : Browser.CHROME;  // mvn -DbrowserType=yandex test или mvn -DbrowserType=chrome test
    private static final ChromeOptions options = new ChromeOptions();
    private final static String PATH_CHROMEDRIVER_EXE = "chromedriver.exe";
    private final static String PATH_YANDEXDRIVER_EXE = "chromedriver-yandex.exe";
    private final static String PATH_CHROMEBROWSER_EXE = Objects.nonNull(System.getProperty("chromeBrowserPath")) ? System.getProperty("chromeBrowserPath") : "/Program Files/Google/Chrome/Application/chrome.exe";
    private final static String PATH_YANDEXBROWSER_EXE = Objects.nonNull(System.getProperty("yandexBrowserPath")) ? System.getProperty("yandexBrowserPath") : "/Users/asort/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";

    static HashMap<Browser, String> browserToDriver = new HashMap<>() {{
        put(Browser.CHROME, PATH_CHROMEDRIVER_EXE);
        put(Browser.YANDEX, PATH_YANDEXDRIVER_EXE);
    }};

    static HashMap<Browser, String> browserToBinary = new HashMap<>() {{
        put(Browser.CHROME, PATH_CHROMEBROWSER_EXE);
        put(Browser.YANDEX, PATH_YANDEXBROWSER_EXE);
    }};

    public static WebDriver browserDriverSetUp() {
        WebDriver driver = null;
        try {
            String driverFile = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(browserToDriver.get(CURRENT_BROWSER))).getFile();
            String browserBinaryFile = browserToBinary.get(CURRENT_BROWSER);

            System.setProperty("webdriver.chrome.driver", new File(driverFile).getCanonicalPath());
            options.addArguments("--remote-allow-origins=*");
            options.setBinary(browserBinaryFile);
            driver = new ChromeDriver(options);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}