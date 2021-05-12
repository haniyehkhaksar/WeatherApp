# WeatherApp
## How to use this app? 
###### when you run it, you should type your city name on the search bar. After that just submit your search by pressing the search icon on the keyboard.

## what is the architecture/structure in this project:
###### I call it Onion Architecture. I use MVVM structure as a part of my architecture.

## What is Onion Architecture?
###### when you start a project it is really important to have a clean architecture mostly for large applications. you can test all layers independently. this is when Onion Architecture can help you have independent layers. what I see in my project as layers is UI, domain, data. Ui handles Views, Domain handles use-cases and logic of the app, data is where you can find repositories related to API or database.

## What is MVVM?
###### It's an architectural pattern that has 3 types of objects including Models, Views, ViewModels.
###### * Model: it keeps data. they are data classes that are filling by use-cases.
###### * View: the screens like activities or fragments
###### * ViewModel: it is like a bridge between model and view. it gives data from the model and gives it to view. 

## What about Dependency Injection?
###### I use Dagger as dependency injection

## what is custom scope in Dagger? and why we use this?
###### if we don't use custom scope, we mostly have to use singleton which makes a leak of objects when we don't need them. for example, we have 2 different fragments called news and weather in different activities, if we provide fragments with their params in the constructor as Singleton, they will be alive until the app is destroyed. but we don't need news fragment in weather activity, we just need it when we are in news activity, there is an API we provide for news, it will be a singleton as well, so many singleton instances we can have with this approach. what we can do? we can make a custom scope and put on our news activity, news fragment and news API, so when activity is destroyed, they will be destroyed as well. no more leak of the unused object.

## when you use @Singletone annotation, you use Dagger annotation, is it thread-safe?
###### The @Singleton annotation provides thread-safety by default. So if you will replace it with @ApplicationScoped, you will lose the synchronization.

## what should we do to have a singleton class thread-safe?
###### make it synchronization. use synchronized in the constructor.

## what is data class in Kotlin and what are its advantages?
###### in java we made model class with getter and setter, if we need we would implement toString(), equals(), hashCode(). but now we data class in Kotlin we don't need to implement everything unless we want it in a specific way which needs to our implementation.
###### Don't forget we have to at least one param in the primary constructor! params in primary constructor have to be 'val' or 'var'! and they cannot be inner, open, abstract or sealed!

## what is a sealed class in Kotlin?
###### I use sealed class here as Enum class. because somehow they are like enums. sealed classes are abstract by default, so you cannot make an instance of them.
###### (read about the sealed interface, they can be sealed too!)
###### constructor in sealed class can be private or protected, never can be public, and never a third-party client can extend your sealed class! 
###### subclasses of them must be declared in the same package! (what about actual/expect?!)
###### another benefit is when you put sealed class as when expression, you never need to have else, it takes care of it!

## what is an open class in Kotlin?
###### open keyword means it is open for extension. All classes in Kotlin are final which means you cannot extend from them unless you use the 'open' keyword.
###### Don't forget if you want to override or overload a method in your class you need to use the 'open' keyword for them as well. (open class, open method)

## what is an abstract class in Kotlin?
###### abstract class is open by default, so you can create subclasses from that. But you never can make an instance from it. in this class, you can have a simple method, open or abstract methods. you cannot override a simple method in any subClasses, but you can override open or abstract methods. The difference between open and abstract methods is open ones have a body and you can override it (not necessary, just if you want). but abstract ones don't have any implementation and you have to override it and make an implementation for them.

## what is the difference between abstract class and interface in Kotlin? ( abstract vs interface)
###### abstract class has class features which means it has a constructor and you can extend only one class not more. 
###### on the other hand with interface there is no constructor for them, but you can implement interfaces in your classes as many as you want.
###### methods in an abstract class that we want to override have to be open, but all methods in an interface are open and you can override them even they have a body.
###### interfaces can have methods with default body. if you need to refer to a class that implements the interface in the default body, you need to use the 'this' keyword. even methods with the body are not final in the interface.
###### if you want to use the default body and override the method together, you can use the 'super' keyword.
###### interfaces can have properties, it means they have an abstraction of getter(for val) or getter/setter(for var). there is no actual value for properties in the interface! the getter/setter can have the body in the interface.

## what is the difference between abstract class and open class in Kotlin? (abstract vs open)
###### you cannot make an instance of an abstract class, but you can make an instance from an open class. you can extend from both.

## what is @Reusable annotation in dagger? @Reusable vs @Singleton!
###### we use @Reusable when it is not important to have the same instance (like singleton/customScope) in any scope. but we don't want to make so many instances because it has a cost for us. so we can use this annotation. for example, I used it for my network (API classes)
###### you should know that @Singleton makes an instance and it is alive till the application gets destroyed. but with @Reusable you can have several instances and there is no scope to tell us how long it is alive!

## @AppScope vs @Singleton
###### we define custom scope if we want to have instances alive in a specific lifecycle of our component, components like activity or fragment. how I define a component in my project?! when I use @ContributeAndoridInjector in activity builder and fragment builder, this annotation generates a subcomponent by itself, so I have a component here if I give them a custom scope, so any provider has the same scope it will be alive till the component is alive.
###### when I define @AppScope in AppComponent means it will alive till the application is alive, it somehow is like singleton, but the difference is AppScope is not thread-safe!

## what is a design pattern? name some of them!
###### Design patterns are solutions that make our code readable, reusable and clean. we have 3 types of design patterns called creational, structural and behavioural. the creational one is used when you want to create an object, some patterns in this type are builders, DI.

## what is BindingAdapter and why we use it?
###### when you want to control setting value on a view, you may make a method and by using BindingAdapter you give this permission to XML use the method to set value for view.

## why should we use NonNullLiveData instead of MutableLiveData?
###### we need to use NonNullLiveData to avoid passing null value to our LiveData, it makes this nonNull safety.

## what is viewModelScope?
###### coroutines can resume themselves, so they can use memory and CPU even when we don't need them. it is called a coroutine leak. to avoid this, we should define scopes to keep coroutines in that scope. mostly in view-model, we want to stop coroutines when viewModel is destroyed. so there are 2 ways, one defines our scope and cancel coroutines after view-model is destroyed or using viewModelScope which is defined by default.

## what is a dispatcher, what kind of dispatchers we have?
###### dispatcher determines which thread coroutines should use for operation. there are 3 types of dispatchers: 1. Main, 2. IO, 3. Default. main means use UI (main) thread, like set value into a view, IO means to use another thread in the background, we use it for background jobs like network, Default is used for computation which uses CPU.

## how to set value in LiveData from the background?
###### there are 2 ways to set value for LiveData, one of them is setValue which use in the main thread and postValue which is used in the background thread. so we must use postValue for the background thread.

## Difference between fields and properties in Kotlin? (fields vs properties)
###### field is a class member variable which hold value. Property is more complicated, this contains a private field and accessors.

## Difference between MutableLiveData and MediatorLiveData in Kotlin?
###### when you want to have more sources for your LiveData, you should use mediatorLiveData. MutableLiveData just supports one source.

## how to start a coroutine?
