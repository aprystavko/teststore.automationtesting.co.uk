package base;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public String getStringWebElement(WebElement element) {
        String elementString = element.toString();
        Pattern pattern = Pattern.compile("-> (.*?)]");
        Matcher matcher = pattern.matcher(elementString);
        if (matcher.find()) {
            return (matcher.group(1).trim()).replace("css selector: ", "");
        }
        return "No match found";
    }

}
