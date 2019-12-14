# Guice tutorial
* Seen on https://www.tutorialspoint.com/guice/index.htm

## Linked binding
https://www.tutorialspoint.com/guice/guice_linked_binding.htm
It is possible to chain bindings and.

Here we bind the interface SpellChecker to a subclass
of the initial implementation SpellCheckerImpl

```java
class TextEditorModule extends AbstractModule {
   @Override
   
   protected void configure() {
      bind(SpellChecker.class).to(SpellCheckerImpl.class);
      bind(SpellCheckerImpl.class).to(WinWordSpellCheckerImpl.class);
   } 
}
```
