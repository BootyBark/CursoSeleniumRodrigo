package Examen;

import org.testng.annotations.DataProvider;

public class Mailchimp_Data {

    @DataProvider(name = "EmailProvider")
    public Object[][] getEmails() {
        return new Object[][]
                {
                        {"rodrigo@ituarte.com", "holamundo"},
                        {"oktana@a.com", "holamundo"},
                        {"nuevo@email.com", "holamundo"}
                };
    }
}
