package utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestListener implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {


    }

    @Attachment
    public String log(String message) {
        return message;
    }
}
