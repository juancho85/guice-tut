package org.example;

class WinWordSpellCheckerImpl extends SpellCheckerImpl {

    public WinWordSpellCheckerImpl(String dbUrl, String user, Integer timeout) {
        super(dbUrl, user, timeout);
    }

    @Override
    public void checkSpelling() {
        System.out.println("Inside WinWordSpellCheckerImpl.checkSpelling." );
    }
}
