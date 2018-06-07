package epam.com.lab.test;

import com.epam.lab.data.datdproviderutils.DataProviderUtiles;
import com.epam.lab.data.models.DataModel;
import com.epam.lab.data.readers.DataReader;
import com.epam.lab.data.readers.XlsxDataReader;
import com.epam.lab.gmail.businesslogic.Letters;
import com.epam.lab.gmail.businesslogic.Login;

import com.epam.lab.utiles.ConfigReader;
import com.epam.lab.utiles.Driver;
import org.testng.annotations.*;

import java.io.File;
import java.util.Properties;
@Listeners
public class GmailTest {
    private static final String PROPERTY_FILE_PATH = "src/test/resources/Configuration.properties";
    private static final String PATH_TO_XLS_FILE = "src/test/resources/users.xlsx";
    private static Login loginBO;
    private static Letters lettersBO;
    private DataModel data;

    @BeforeMethod
    public void createChromeDriver() {
        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.readConfig(PROPERTY_FILE_PATH);
        data = new DataReader().readData(new File(properties.getProperty("data")));
        System.setProperty(properties.getProperty("driverType"), properties.getProperty("chromeDriverPath"));
        Driver.getWebDriver().get(properties.getProperty("gmailurl"));
        loginBO = new Login();
        lettersBO = new Letters();
    }

    @DataProvider(name = "gmail-data")
    public Object[][] provide() {
        return DataProviderUtiles.provide(PATH_TO_XLS_FILE, new XlsxDataReader());
    }

    @Test(dataProvider = "gmail-data")
    public void GmailDeleteLettersTest(String email, String password) {
        loginBO.login(email, password);
        lettersBO.deleteLetters(data.getLettersNumber());
        lettersBO.verifyThatLettersNotDeleted();

    }

    @AfterMethod
    public void closeDriver() {
        Driver.close();
    }

}
