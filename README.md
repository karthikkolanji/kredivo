# Upkeep

This is a basic Kotlin Multiplatform app for Android and iOS. It includes shared business logic and data handling, and a shared UI implementation using Compose Multiplatform.

### Features
- SplashScreen : Displays Logo. Check user login status and properly navigates user to LoginScreen or WorkOrderListScreen

- LoginScreen : Enables users to login. Once logged in, user can navigate to WorkOrderListScreen
- WorkOrderListScreen : Displays all work orders data. User can do logout, once logged-out user is taken to LoginScreen

- WorkOrderDetailsScreen : Displays details of specific work order selected by user from WorkOrderListScreen


### Technologies 🛠

The data displayed by the app is from [Mocky](https://run.mocky.io/v3/ee8ab182-708b-40f8-8845-a129b425949a).

The app uses the following multiplatform dependencies in its implementation:

- [Compose Multiplatform : ](https://jb.gg/compose) for UI
- [Ktor :](https://ktor.io/) for Networking
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)  for JSON handling
- [Koin](https://github.com/InsertKoinIO/koin) for Dependency Injection
- [Voyager](https://github.com/adrielcafe/voyager) for navigation and screen models
- [SqlDelight](https://cashapp.github.io/sqldelight/2.0.1/) for local databse
- [Coroutines ](https://kotlinlang.org/docs/coroutines-overview.html) for asynchronous or non-blocking 
- [Kermit ](https://kermit.touchlab.co/docs/) for logging
- [Multiplatform Settings ](https://github.com/russhwolf/multiplatform-settings) for persist key-value data storage
- [Koltin Test ](https://kotlinlang.org/api/latest/kotlin.test/) for assertions
key-value data storage
- [MockK ](https://kotlinlang.org/api/latest/kotlin.test/) for mocking objects

### Installation
To make project work on both iOS and Android, you'll need to [setup](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-setup.html)  an environment for Kotlin Multiplatform development. 

### Usage
To run application on both Android and iOS follow [this](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-create-first-app.html#run-your-application) step

### Screenshots/Demo
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Android (Light Theme) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iOS (Dark Theme)
![Android (Light Theme)](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExaTdlZTBndnkwaDZxZmt0dnMwazFxZ2pkZjR2MnZqd3F0YjBicWgweSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/DYXYDRLZFEJHlCvAvp/giphy.gif). &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![ iOS (Dark Theme)](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExd3BiMjNzZDI2cGZvdXZzNnBod25mY3pyNHJsZ2F1cW1vNTJkeWJ3aCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/taxGg6KzYix2mG4fbc/giphy.gif)

### Roadmap
- fgfgfggh
-vdvdvdvdv


## 👨 Developed By
<a href="https://twitter.com/kolanji_karthik" target="_blank">
  <img src="https://avatars.githubusercontent.com/u/8638991?v=4" width="70" align="left">
</a>

**Karthik Kolanji**

[![Twitter](https://img.shields.io/badge/-twitter-grey?logo=twitter)](https://twitter.com/kolanji_karthik)
[![Medium](https://img.shields.io/badge/-medium-grey?logo=medium)](https://medium.com/@karthik_78204)
[![Linkedin](https://img.shields.io/badge/-linkedin-grey?logo=linkedin)](https://www.linkedin.com/in/karthik-kolanji-179122139/)
