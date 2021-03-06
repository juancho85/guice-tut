package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class GuiceTester {
    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new TextEditorModule());
            TextEditor editor = injector.getInstance(TextEditor.class);
            editor.makeSpellCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

