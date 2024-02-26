# Kredivo App
An simple app to do mobile phone topup.



<div align="center">
  <sub>Built with ❤︎ by
  <a href="https://twitter.com/kolanji_karthik">Karthik Kolanji</a>
</div>
<br/>
<br/>


## Project Brief:
* Arachitecture used : MVVM + Clean Architecture
* Library used : Hilt,LiveData,Coroutines,Retrofit,Navigation Component, Mockk, JUnit
* Project Module : It's modularized project where it has 3 modules (app,core,pulsa). Modularization helps in adding new fetures easily and reduces build time.
  * Module app: It has Application, Activity , Navigation graph. It uses all the feature modules in the project
  * Module core: It has all the core objects(provided by hilt), Extension file, utils etc. Any feature module can use this core module to access necessary functionality
  * Module pulsa: It has functionality retaled to recharge mobile number. It contains 3 screens ie, Pulsa, Purchase, Voucher and Payment Details screen.

## Clean Architure insight in project:
* Pulsa module has 3 layers according to Clean Architecture ie, Data, Domain and UI
* Every layer has its own Model, Mapper and interface to support SOLID principle.
*
## Test:
* Sample Test ProductResponseApiToDataMapperTest and VoucherItemsDataToDomainMapperTest is added to demonstrate test can be easily implemented with good architecture.

## Built With 🛠
- [MVVM Architecture](https://developer.android.com/topic/architecture) - Official architecture for Android development.
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- [Dependency Injection](https://developer.android.com/training/dependency-injection)
  - [Hilt](https://dagger.dev/hilt) - Easier way to incorporate Dagger DI into Android apps.
- [Navigation Component](https://developer.android.com/guide/navigation/get-started) - Navigation between screens in app.
- [MockK](https://mockk.io) - For Mocking and Unit Testing


## Assumptions made while developing code
- Currency is without decimal
- Baisc android fetures like accessing contact to read mobile number can be avoided for this assignment and focus on Architecture. Once good architecture implemented features can be added easily.
- Colors and icons was least priority for code demonstration.
- Api response provided is dummy, so values from it can be taken lighlty .


## Improvements I would like to make, if spent more time
- Add test case for all mappers and usecase.
- UI improvements, access user phonebook to read mobile number
- Take use to phone dial, mail app on click of Terms and condition.
-
## 👨 Developed By

<a href="https://twitter.com/kolanji_karthik" target="_blank">
  <img src="https://avatars.githubusercontent.com/u/8638991?v=4" width="70" align="left">
</a>

**Karthik Kolanji**

[![Twitter](https://img.shields.io/badge/-twitter-grey?logo=twitter)](https://twitter.com/kolanji_karthik)
[![Medium](https://img.shields.io/badge/-medium-grey?logo=medium)](https://medium.com/@karthik_78204)
[![Linkedin](https://img.shields.io/badge/-linkedin-grey?logo=linkedin)](https://www.linkedin.com/in/karthik-kolanji-179122139/)
