package epam.com.lab.test;

import com.epam.lab.data.datdproviderutils.DataProviderUtiles;
import com.epam.lab.data.models.DataModel;
import com.epam.lab.data.readers.CsvDataReader;
import com.epam.lab.data.readers.DataReader;
import com.epam.lab.github.businesslogic.Login;
import com.epam.lab.github.businesslogic.Search;
import com.epam.lab.utiles.ConfigReader;
import com.epam.lab.utiles.Driver;

import org.testng.annotations.*;

import java.io.File;
import java.util.Properties;

@Listeners
public class GitHubTest {
    private static final String PROPERTY_FILE_PATH = "src/test/resources/Configuration.properties";
    private static final String PATH_TO_CSV_FILE = "src/test/resources/users.csv";

    private DataModel data;
    private Login loginBO;
    private Search search;


    @BeforeMethod
    public void createChromeDriver() {
        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.readConfig(PROPERTY_FILE_PATH);
        data = new DataReader().readData(new File(properties.getProperty("data")));
        System.setProperty(properties.getProperty("driverType"), properties.getProperty("chromeDriverPath"));
        Driver.getWebDriver().get(properties.getProperty("githuburl"));
        loginBO = new Login();
        search = new Search();
    }

    @DataProvider(name = "git-data")
    public Object[][] provide(){
        return DataProviderUtiles.provide(PATH_TO_CSV_FILE, new CsvDataReader());
    }


    @Test(dataProvider = "git-data")
    public void GithubSearchTest(String email, String password) {
        loginBO.login(email, password);
        search.searchText(data.getQuery1());
        search.printResults();
//        search.verifiingTagForSearchResults(data.getTag());
        search.changeSorting(2);
        search.printResults();
        search.searchText(data.getQuery2());
        search.printResults();
    }

    @AfterMethod
    public void closeTab() {
        Driver.close();
    }

}
