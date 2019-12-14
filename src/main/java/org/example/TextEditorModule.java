package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

class TextEditorModule extends AbstractModule {
    @Override
    protected void configure() {
//        bind(SpellChecker.class).to(SpellCheckerImpl.class);
//        bind(SpellCheckerImpl.class).to(WinWordSpellCheckerImpl.class);

        // Constant binding
        bind(String.class).annotatedWith(Names.named("JDBC")).toInstance("jdbc:mysql://localhost:5326/emp");

    }

    @Provides
    public SpellChecker provideSpellChecker() {
        String dbUrl = "jdbc:mysql://localhost:5326/emp";
        String user = "user";
        int timeout = 100;

        SpellChecker SpellChecker = new SpellCheckerImpl(dbUrl, user, timeout);
        return SpellChecker;
    }
}
