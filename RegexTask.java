import java.util.regex.*;

public class RegexTask {

    public static void main(String[] args) {
        String converterText = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";
        String emailText = "test 2667843 (test_email@griddynamics.com) test 67483 some string";
        String splitterText = "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [2]";
        String testFoeSearch = "When you first start to evaluate a cloud migration, the decisions to be made, stakeholders who need to be involved, it can sometimes feel overwhelming – and with good reason. A move to the cloud can take time, resources, and manpower, and while companies are nearly universally glad they made those investments, that doesn't cancel out the fact that they take strategic planning and up-front work."
       + "What do you need to plan for? Who needs to be involved (and when)? What roles and responsibilities need to be divided up? The answers vary a bit depending on your company size, the scope of your migration, and whether you have the budget (or need) for a migration partner."
       + "Below are the typical roles and responsibilities we see from successful migrations – and some tips to prepare your team for success. Because without the right team in place, missed deadlines, duplicative work, and post-migration workflow issues become much greater risks.";

        String orderRegex = "(orderUUID)";
        String uuIDNumberRegex = "(orderUUID=)([a-zA-Z0-9-]+)\\s?";
        String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        String orderCompleteRegex = "total number of orders successfully processed:\\s?\\[(\\d)\\]";
        String deWordsRegex = "\\bde+[A-Za-z]*";

        Pattern pattern = Pattern.compile(orderRegex);
        Pattern idPattern = Pattern.compile(uuIDNumberRegex);
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern completePattern = Pattern.compile(orderCompleteRegex);
        Pattern deWordsPattern = Pattern.compile(deWordsRegex);


        Matcher matcher = pattern.matcher(converterText);
        Matcher idMatcher = idPattern.matcher(converterText);
        Matcher emailMatcher = emailPattern.matcher(emailText);
        Matcher completeMatcher = completePattern.matcher(splitterText);
        Matcher deWordsMatcher = deWordsPattern.matcher(testFoeSearch);


        System.out.println("\n####### P A R T  O N E #######\n");
        if (matcher.find()) {
            System.out.println("orderUUID Found!");
        } else {
            System.out.println("UUID not found");
        }

        System.out.println("\n####### P A R T  T W O #######");
        if (idMatcher.find()) {
            System.out.println("Order UUID: " + idMatcher.group(2));
        }

        System.out.println("\n####### P A R T  T H R E E #######");
        if (emailMatcher.find()) {
            System.out.println("User Email: " + emailMatcher.group());
        }

        System.out.println("\n####### P A R T  F O U R #######");
        if (completeMatcher.find()) {
            System.out.println("Orders Processed: " + completeMatcher.group(1));
        }

        System.out.println("\nWords Starting With \"de\":");
        while (deWordsMatcher.find()){
            System.out.println(deWordsMatcher.group());
        }

    }
}
