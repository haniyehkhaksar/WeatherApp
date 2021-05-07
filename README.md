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

## what is open and public calss in kotlin? open vs public!

## what is abstract calss in kotlin?

## what is difference between abstarct class and interface in kotlin? ( abstract vs interface)

## what is @Reusable annotation in dagger? @Reusable va @Singleton!

## @AppScope vs @Singleton

## what is design pattern? name some of them!

## what is BindingAdapter and why we use it?

## why should we use NonNullLiveData instaed of LiveData?

## what is viewModelScope?

## what is dispatcher, what kind of dispatecher we have?

## how to set value in livedata from background?

## what is difference between livedata.value and livedata,postValue()

## what is MutableLiveDataExtension?


