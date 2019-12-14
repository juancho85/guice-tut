package org.example;

import com.google.inject.AbstractModule;

class TextEditorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SpellChecker.class).to(SpellCheckerImpl.class);
        bind(SpellCheckerImpl.class).to(WinWordSpellCheckerImpl.class);
    }
}
