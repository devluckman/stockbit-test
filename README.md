# Stockbit Test

### Introduction
This is Stockbit Test android application source code

This application written in kotlin

### Preview App

![](/images/app_preview.jpg)

### Architecture
Clean Architecture + MVVM (Model-View-ViewModel)

![http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/](/images/clean_architecture.png)

Architectural reactive approach
-----------------
![https://github.com/xyarim/android-clean-coroutines/](/images/clean_architecture_layers_details.png)

### Module

#### App module

The `:app` module is an [com.android.application](https://developer.android.com/studio/build/), which is needed to create the app bundle.  It is also responsible for initiating the [dependency graph](https://github.com/google/dagger), [play core](https://developer.android.com/reference/com/google/android/play/core/release-notes) and another project global libraries, differentiating especially between different app environments.

#### Core module

The `:core` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) only contains code and resources which are shared between other modules. Reusing this way resources, layouts, views, and components in the different modules, without the need to duplicate code.

#### Data module

The `:data` module is an [com.android.library](https://developer.android.com/studio/projects/dynamic-delivery) for serving network requests or accessing to the database. Providing the data source for the many features that require it.

#### Domain module

The `:domain` module is an [com.android.library](https://developer.android.com/studio/projects/android-library) lays a bridge between data
and view layers. It performs any business logic getting data from data
module and serves to view.


### Dependency
 * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
 * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
 * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
 * [Koin](https://github.com/InsertKoinIO/koin)
 * [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
 * [Retrofit](http://square.github.io/retrofit/)
 * [OkHttp](https://square.github.io/okhttp/)

 
### Local Development

Here are some useful Gradle/adb commands for executing this example:

 * `./gradlew clean build` - Build the entire example and execute unit and integration tests plus lint check.
 * `./gradlew installDebug` - Install the debug apk on the current connected device.
 * `./gradlew runUnitTests` - Execute domain and data layer tests (both unit and integration).
 * `./gradlew runAcceptanceTests` - Execute espresso and instrumentation acceptance tests.