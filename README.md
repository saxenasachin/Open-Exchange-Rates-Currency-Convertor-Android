# Open Exchange Rate - Currency Convertor (Sample Application)
[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)

This is a sample application 📱 built to demonstrate use of Open Exchange Rate REST API ❤️

Download APK from here to test it.
[app-debug.apk.zip](https://github.com/saxenasachin/Open-Exchange-Rates-Currency-Convertor-Android/files/9697991/app-debug.apk.zip)
<br/>
<br/>

<img width="300" height="550" alt="Landing screen" src="https://user-images.githubusercontent.com/22069181/193595106-44daae5b-f2f8-4ff2-8f79-a8f7dffc9705.jpg">&nbsp;&nbsp;&nbsp;&nbsp;<img width="300" height="550" alt="Closed Pull Requests screen" src="https://user-images.githubusercontent.com/22069181/193595147-b4562495-f658-43bd-b573-6aec66ff9b05.jpg">&nbsp;&nbsp;&nbsp;&nbsp;<img width="300" height="550" alt="Closed Pull Requests screen" src="https://user-images.githubusercontent.com/22069181/193595180-fdbc1053-df73-4acb-87b8-959ddf7a7706.jpg">


## - About
It simply loads data from [Open Exchange Rate](https://openexchangerates.org/) about latest currency rates and list of all currencies. It converts from one currency to another after getting input from user. It also works offline if user is not connected to the internet. It uses Room database to store all the value.

## - Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - It notifies views of any data set changes. Use LiveData to build data objects that notify views when the underlying data set changes..
   - [Room](https://developer.android.com/jetpack/androidx/releases/room?gclid=Cj0KCQjwkOqZBhDNARIsAACsbfLyej9JhAOsH3EHot6AAZVY6gc_eQTTvc077gQoq469M1U8H9SK5uIaAo3aEALw_wcB&gclsrc=aw.ds) - persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [OkHttp](http://square.github.io/okhttp/) - HTTP client that's efficient by default: HTTP/2 support allows all requests to the same host to share a socket
- [Gson](https://github.com/google/gson) - used to convert Java Objects into their JSON representation and vice versa.

## Architecture

The architecture of the application is based, apply and strictly complies with each of the following 5 points:
-   [Android architecture components](https://developer.android.com/topic/libraries/architecture/), part of Android Jetpack for give to project a robust design, testable and maintainable.
-   [Dagger2](https://developer.android.com/training/dependency-injection/dagger-android), help you automate dependency injection in your app. With Dagger, you don't have to write tedious and error-prone boilerplate code.
-   Pattern  [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)  (MVVM) facilitating a [separation](https://en.wikipedia.org/wiki/Separation_of_concerns) of development of the graphical user interface.
-   [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID)  design principles intended to make software designs more understandable, flexible and maintainable.
-   [Modular app architecture](https://proandroiddev.com/build-a-modular-android-app-architecture-25342d99de82)  allows to be developed features in isolation, independently from other features.

## If this project helps you in anyway, show your love :heart: by putting a :star: on this project :v:

### - Contact - Let's become friend
- [Blog](https://medium.com/@sachinsaxena28)
- [Linkedin](https://www.linkedin.com/in/sachin1790/)

## - License

```
MIT License

Copyright (c) 2020 Happy Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.```
