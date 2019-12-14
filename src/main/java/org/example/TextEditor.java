package org.example;

import com.google.inject.name.Named;

import javax.inject.Inject;

class TextEditor {
    private SpellChecker spellChecker;
    private String dbUrl;

    @Inject
    public TextEditor(SpellChecker spellChecker, @Named("JDBC") String dbUrl) {
        this.spellChecker = spellChecker;
        this.dbUrl = dbUrl;
    }
    public void makeSpellCheck() {
        spellChecker.checkSpelling();
    }
    public void makeConnection() {
        System.out.println(dbUrl);
    }
}
