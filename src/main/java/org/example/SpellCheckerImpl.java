package org.example;

import com.google.inject.name.Named;

import javax.inject.Inject;

class SpellCheckerImpl implements SpellChecker {

    private String dbUrl;
    public SpellCheckerImpl(){}

    public SpellCheckerImpl(@Named("JDBC") String dbUrl) {
        this.dbUrl = dbUrl;
    }
    @Override
    public void checkSpelling() {
        System.out.println("Inside checkSpelling." );
        System.out.println(dbUrl);
    }
}
