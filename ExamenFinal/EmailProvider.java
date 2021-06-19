package ExamenFinal;

import org.testng.annotations.DataProvider;

public class EmailProvider {
    @DataProvider(name = "emails")
    public Object[][] getEmails() {
        return new Object[][]
                {
                        {"rodrigo@ituarte.com"},
                        {"oktana@hotmail.com"},
                        {"nuevo@mail.com"}
                };
    }
}
