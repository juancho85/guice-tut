package org.example;

import javax.inject.Inject;
import java.util.logging.Logger;

class TextEditor {
    private SpellChecker spellChecker;
    private Logger logger;

    @Inject
    public TextEditor(SpellChecker spellChecker, Logger logger) {
        this.spellChecker = spellChecker;
        this.logger = logger;
    }
    public void makeSpellCheck() {
        logger.info("In TextEditor.makeSpellCheck() method");
        spellChecker.checkSpelling();
    }
}
