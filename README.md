# WeatherApp
## How to use this app? 
###### when you run it, you should type your city name on search bar. afetr that just submit your search by pressing search icon on keyboard.

## what is the architecture/structure in this project:
###### I call it Onion Architecture. I use MVVM structure as a part of my architecture.

## What is Onion Architecture?
###### when you start a project it is really important to have a clean architecture mostly for large applications. you should can test all layers indepndant. this is when Onion Architecture can help you have independant layers. what I see in my project as layers is UI, domain, data. Ui handle Views, Domain handle usecases and logic of app, data is where you can find repositories related to api or database.

## What is MVVM?
###### It's a architectural pattern which has 3 type of objects including Model, Views, ViewModels.
###### * Model: it keeps data. they are data classes which is filling by usecases.
###### * View: the screens like activities or fragments
###### * ViewModel: it is like a bridge between modle and view. it gives data from model and give it to view. 

## What about Dependency Injection?
###### I use Dagger as dependency injection

## what is custom scope in Dagger? and why we use this?
###### if we don't use custom scope, we mostly have to use singleton which make leak of objects when we don't need them. for example we have 2 different fragments called news and weather in different activities, if we provide fragments with their params in constructor as Singleton, they will be alive until app is destroyed. but we don't need news fragment in weather activity, we just need it when we are in news activity, there is a api we provide for news, it will be singleton as well, so many singleton instances we can have with this approach. what we can do? we can make a custom scope and put on our news activity, news fragment and  news api, so when activity is destoyed, they will be destroyed as well. no more leak of unused object.

## when you use @Singletone annotation, you use Dagger annotation, is it thread safe?
###### The @Singleton annotation provides thread-safety by default. So if you will replace it with @ApplicationScoped, you will loose the synchronization.

## what should we do to have a singleton calss thread safe?
###### make it synchronization. use synchronized in constructor.

## what is data class in kotlin and what are its advantages?
###### in java we made model class with getter and setter, if we need we would implement toString(), equals(), hashCode(). but now we data class in ktolin we don't need to implement every thing unless we want it in specific way which need to our implementation.
###### Don't forget we have to at least one param in promary contructor!, params in primary constructor have to be 'val' or 'var'! and they cannot be inner, open, abstract or sealed!

## what is sealed calss in kotlin?
###### I use sealed class here as Enum calss. because somehow they are like enums. sealed classes are abstract by default, so you cannot make an instance of them.
###### (read about sealed interface, they can be sealed too!)
###### constructor in sealed class can be private or protected, never can be public, and never a third-party client can extend your sealed class! 
###### subclasses of them must declared in the same package! (what about actual/expect?!)
###### another benefit is when you put sealed calss as when expression, you never need to have else, it takes care of it!

## what is open calss in kotlin?
###### open keyword means it is open for extension. All classes in Kotlin is final which means you cannot extend from them, unless you use 'open' keyword.
###### Don't forget if you want to override or overload a method in your class you need use 'open' key word for them as well. (open class, open method)

## what is abstract calss in kotlin?
###### abstract class is open by default, so you can creat subclasses from that. But you never can make an instance from it. in this class you can have simple method, open or abstract methodes. you cannot override simple method in any subClasses, but you can override open or abstract methods. difference between open and abstract methods is open ones have a body and you can override it (not nessecery, just if you want). but abstract ones don't have any implementation and you have to override it and make an implementation for them.

## what is difference between abstarct class and interface in kotlin? ( abstract vs interface)
###### abstract class has classes features which means it has constructor and you can extend only one class not more. 
###### on the other hand with interface there is no constructor for them, but you can implement interfaces in your classes as many as you want.
###### methods in abstract class that we want to overrdie have to be open, but all methods in interface is open and you can overrdie them even they have body.
###### interfaces can have methods with default body. if you need to reference to class which implement interface in default body, you need to use 'this' keyword. even methods with body are not final in interface.
###### if you want use default body and override the method together, you can use 'super' keyword.
###### interfaces can have properties, it means the have an abstraction of getter(for val) or getter/setter(for var). there is no actual value for properties in interface! the getter/setter can have body in interface.

## what is difference between abstarct class and open class in kotlin? ( abstract vs abstract)
###### you cannot make an instance of abstract class, but you can make an instance from open class. you can extend form both.

## what is @Reusable annotation in dagger? @Reusable va @Singleton!
###### we use @Reusable when it is not important to have the same instance (like singleton/customScope) in any scope. but we don't want make so many instances because it has cost for us. so we can use this annotation. for example I used it for my network (api classes)
###### you should know that @Singleton make an instance and it is alive till application gets destroyed. but with @Reusable you can have several instances and there is no scope tell us how long it is alive!

## @AppScope vs @Singleton
###### we define custom scope if we want to have instances alive in specific lifecycle of our somponent, component like activity or fragment. how I define component in my project?! when I use @ContributeAndoridInjector in activity builder and fragment builder, this annotation generate a subcomponent by itself, so I have component here, if I give them a custom scope, so any provider have the same scope it will be alive till the component is alive.
###### when I define @AppScope in AppComponent means it will alive till application is alive, it somehow is like singleton, but the difference is AppScope is not thread safe!

## what is design pattern? name some of them!
###### Design patterns are solutions which are make our code readable, reusable and clean. we have 3 types of design patterns called creational, structural and behavioural. the creational one is used when you want to create an object, some patterns in this type are buildres, DI.

## what is BindingAdapter and why we use it?
###### when you want to control setting value on a view, you may make a method and by using BindingAdapter you give this permission to xml use the method to set value for view.

## why should we use NonNullLiveData instaed of MutableLiveData?
###### we need to use NonNullLiveData to avoid passing null value to our Livedata, it makes this nonNull safety.

## what is viewModelScope?
###### coroutines can resume itself, so they can use memory and CPU even when we don't need them. it is called coroutine leak. to avoid this, we sould define scopes to keep coroutines in that scope. mostly in viewmodel we want to stop coroutines when viewModel is destroyed. so there is 2 ways, one define our scope and cancel coroutines after viewmodel is destroyed or using viewModelScope which is defined by default.

## what is dispatcher, what kind of dispatecher we have?
###### dispatcher determine which thread coroutines should use for operation. there are 3 types of dispatcher: 1. Main, 2. IO, 3. Default. main means use UI(main) thread like set value into a view, IO means use another thread in background, we use it for background jobs like network, Default is used for computaion which use CPU.

## how to set value in livedata from background?
there are 2 ways to set value for livedata, one of them is setValue which use in main thread and postValue which is used in background thread. so we must use postValue for background thread.

## Difference between fields and properties in kotlin? (fileds vs properties)

## Difference between MutableLiveData and MediatorLiveData in kotlin?

## how to start a coroutine?
