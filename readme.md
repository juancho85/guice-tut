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

# Constructor bindings (since Guice 3.0)
* https://www.tutorialspoint.com/guice/guice_constructor_bindings.htm
* https://github.com/google/guice/wiki/ToConstructorBindings
Occasionally it's necessary to bind a type to an arbitrary constructor. This comes up when the @Inject annotation 
cannot be applied to the target constructor: either because it is a third party class,
or because multiple constructors that participate in dependency injection