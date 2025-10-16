package Infra;

public class DataList {
    public static String setJSON(String method, String scenario, String Status) {
        String methodName = method;

        if (methodName.equals("GrantingFlow")) {
            String Scenario = scenario;
            String RemoveOpenBracket = Scenario.replace("[", "");
            String RemoveCloseBracket = RemoveOpenBracket.replace("]", "");

            String[] ScenarioParts = RemoveCloseBracket.split(",");

            String Name = ScenarioParts[0];
            String Username = ScenarioParts[1];
            String Password = ScenarioParts[2];
            String SearchType = ScenarioParts[3];
            String CustomerNIC_EIC = ScenarioParts[4];
            String Other = ScenarioParts[5];
            String ProductName = ScenarioParts[6];
            String Item = ScenarioParts[7];
            String Appearance = ScenarioParts[8];
            String GrossWeight = ScenarioParts[9];
            String NetWeight = ScenarioParts[10];
            String MachineReadKaratage = ScenarioParts[11];
            String ExperienceKaratage = ScenarioParts[12];
            String ArticleRemark = ScenarioParts[13];
            String ItemWiseAdvAmt = ScenarioParts[14];
            String MeasureType = ScenarioParts[15];
            String Sector = ScenarioParts[16];
            String Purpose = ScenarioParts[17];
            String ServiceCharge = ScenarioParts[18];
            String InterestRate = ScenarioParts[19];
            String GrantingRemark = ScenarioParts[20];

            String name = Name;
            String username = Username;
            String password = Password;
            String searchType = SearchType;
            String customerNIC_EIC = CustomerNIC_EIC;
            String other = Other;
            String productName = ProductName;
            String item = Item;
            String appearance = Appearance;
            String grossWeight = GrossWeight;
            String netWeight = NetWeight;
            String machineReadKaratage = MachineReadKaratage;
            String experienceKaratage = ExperienceKaratage;
            String articleRemark = ArticleRemark;
            String itemWiseAdvAmt = ItemWiseAdvAmt;
            String measureType = MeasureType;
            String sector = Sector;
            String purpose = Purpose;
            String serviceCharge = ServiceCharge;
            String interestRate = InterestRate;
            String grantingRemark = GrantingRemark;

            String jsonString = "{\n" +
                    "  \"" + methodName + "\": [\n" +
                    "    {\n" +
                    "      \"name\": \"" + name + "\",\n" +
                    "      \"username\": \"" + username + "\",\n" +
                    "      \"password\": \"" + password + "\",\n" +
                    "      \"searchType\": \"" + searchType + "\",\n" +
                    "      \"customerNIC_EIC\": \"" + customerNIC_EIC + "\",\n" +
                    "      \"other\": \"" + other + "\",\n" +
                    "      \"productName\": \"" + productName + "\",\n" +
                    "      \"item\": \"" + item + "\",\n" +
                    "      \"appearance\": \"" + appearance + "\",\n" +
                    "      \"grossWeight\": \"" + grossWeight + "\",\n" +
                    "      \"netWeight\": \"" + netWeight + "\",\n" +
                    "      \"machineReadKaratage\": \"" + machineReadKaratage + "\",\n" +
                    "      \"experienceKaratage\": \"" + experienceKaratage + "\",\n" +
                    "      \"articleRemark\": \"" + articleRemark + "\",\n" +
                    "      \"itemWiseAdvAmt\": \"" + itemWiseAdvAmt + "\",\n" +
                    "      \"measureType\": \"" + measureType + "\",\n" +
                    "      \"sector\": \"" + sector + "\",\n" +
                    "      \"purpose\": \"" + purpose + "\",\n" +
                    "      \"serviceCharge\": \"" + serviceCharge + "\",\n" +
                    "      \"interestRate\": \"" + interestRate + "\",\n" +
                    "      \"grantingRemark\": \"" + grantingRemark + "\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            return jsonString;
        }

        return "{}";
    }


}



