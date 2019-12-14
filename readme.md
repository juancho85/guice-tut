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

## Binding annotations
* https://www.tutorialspoint.com/guice/guice_binding_annotations.htm
* https://github.com/google/guice/wiki/BindingAnnotations
What is the purpose? Isn't the example below the same as injecting a concrete implementation WinWordSpellCheckerImpl?

```java
@Inject
public TextEditor(@WinWord SpellChecker spellChecker) {
   this.spellChecker = spellChecker;
}
```

## Named annotations
* https://www.tutorialspoint.com/guice/guice_named_binding.htmWhat is the purpose. Isn't the example below the same as injecting a concrete implementation WinWordSpellCheckerImpl?
* https://github.com/google/guice/wiki/BindingAnnotations
Similar to binding annotations but without creating a custom annotation

```java
//Binding Module
class TextEditorModule extends AbstractModule {
   @Override
   
   protected void configure() {
      bind(SpellChecker.class).annotatedWith(Names.named("OpenOffice"))
         .to(OpenOfficeWordSpellCheckerImpl.class);
   } 
}

class TextEditor {
   private SpellChecker spellChecker;
   
   @Inject
   public TextEditor(@Named("OpenOffice") SpellChecker spellChecker) {
      this.spellChecker = spellChecker;      
   }
   public void makeSpellCheck() {
      spellChecker.checkSpelling(); 
   }  
}
```

# Constant/Instance bindings
* https://www.tutorialspoint.com/guice/guice_constant_bindings.htm
* https://github.com/google/guice/wiki/InstanceBindings
Guice provides a way to create bindings with value objects or constants


# @Provides methods - binding complex objects
* https://www.tutorialspoint.com/guice/guice_provides_annotation.htm
* https://github.com/google/guice/wiki/ProvidesMethods
* Method annotated with @Provides creating the object, must be defined within a module

# Provider class - provider bindings
* https://www.tutorialspoint.com/guice/guice_provider_class.htm
* https://github.com/google/guice/wiki/ProviderBindings
This approach allows extracting complex provide methods to a separate class

```java
// Guice's Provider interface
public interface Provider<T> {
  T get();
}

// Provider
class SpellCheckerProvider implements Provider<SpellChecker> {
   @Override
   public SpellChecker get() {
      String dbUrl = "jdbc:mysql://localhost:5326/emp";
      String user = "user";
      int timeout = 100;
      SpellChecker SpellChecker = new SpellCheckerImpl(dbUrl, user, timeout);
      return SpellChecker;
   } 
}

//Binding Module
class TextEditorModule extends AbstractModule {
   @Override
   
   protected void configure() {
      bind(SpellChecker.class).toProvider(SpellCheckerProvider.class);
   } 
}

```
