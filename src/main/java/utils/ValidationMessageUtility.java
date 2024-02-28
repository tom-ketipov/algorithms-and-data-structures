package utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ValidationMessageUtility {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("validation.validation_messages");

    public static String getMessage(String key, Object... params) {
        String pattern;

        try {
            pattern = RESOURCE_BUNDLE.getString(key);
        } catch (Exception e) {
            // Log the exception or handle missing resource key appropriately
            return "Missing validation message for: " + key;
        }

        MessageFormat format = new MessageFormat(pattern);
        return format.format(params);
    }
}
