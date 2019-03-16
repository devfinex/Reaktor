# Reaktor

![Reaktor Version](https://img.shields.io/badge/Reaktor-0.0.1-red.svg) ![minSdk](https://img.shields.io/badge/minSdk-14-green.svg)

Reaktor is a framework for a reactive and unidirectional application architecture.  
It is a Kotlin port of the [ReaktorKit](https://github.com/ReactorKit/ReactorKit/) Swift concept.

<p align="center">
  <img alt="flow" src="https://github.com/floschu/Reaktor/blob/master/reactor_diagram.png">
</p>

## Installation

```groovy
allprojects {
    repositories {
        jcenter()
    }
}

dependencies {
    implementation 'at.florianschuster:reaktor:0.0.1'
}
```

## What should I know before I try this?

* Kotlin
* RxJava2
* MVI Architecture Pattern

## Tell me more

### General Concept and Unidirectional Data Flow

For this you should hit up the [ReactorKit Repo Readme](https://github.com/ReactorKit/ReactorKit/blob/master/README.md). It is very extensive and since Swift 4 and Kotlin are much alike you will feel right at home! They also have nice graphics.

### Reaktor

A Reactor has to implement the `Reactor<Action, Mutation, State>` interface. Do not forget to clear the `CompositeDisposable` in the `Reactor` after you are done with it. A View that binds to a Reactor has to implement the interface `ReactorView`.

By default, a `Reactor` catches and ignores all errors emitted in `fun mutate()` and `fun reduce()` in release builds to keep the `state` stream going. You can change this behavior for debug builds and also attach an error handler with `Reaktor.handleErrorsWith(...)`.  

### Reaktor-Android

```groovy
dependencies {
    implementation 'at.florianschuster:reaktor-android:0.0.1'
}
```

When binding the Reactor to an Activity or a Fragment, their life cycles have to be taken into account.  
All views have to be laid out before the bind happens, so you should not call `fun bind(Reactor)` before:

* Activity: after `setContentView(Int)` in `fun onCreate(Bundle)`
* Fragment: `fun onViewCreated(View, Bundle)`

Also do not forget to dispose the View's `CompositeDisposable`. I propose to do this in: 

* Activity: `fun onDestroy()`
* Fragment: `fun onDestroyView()`

The `ViewModelReactor` is a default implementation for a `Reactor` that uses the [Android Architecture ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) and thus handles the clearing of the `CompositeDisposable` in `fun onCLeared()`.

## Examples

* [Counter](https://github.com/floschu/Reaktor/tree/master/countersample): Most Basic Counter Example. It uses `ViewModelReactor` for an Activity.
* [Github Search](https://github.com/floschu/Reaktor/tree/master/githubsample): Github Repository Search. It uses `ViewModelReactor` for a Fragment.
* [Save State Example](https://github.com/floschu/Reaktor/tree/master/savestatesample): Like the Counter. Basic but it uses `onSaveInstanceState` to preserve the `Reactor`'s state on process death.
* [Watchables](https://github.com/floschu/Watchables): A Movie and TV Show Watchlist Application. It uses [Koin](https://github.com/InsertKoinIO/koin) as DI Framework to inject dependencies into a `Reactor`.

## Author

Visit my [Website](https://florianschuster.at/).

## AboutLibraries

``` xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="define_reaktor"></string>
    <string name="library_reaktor_author">Florian Schuster</string>
    <string name="library_reaktor_authorWebsite">https://florianschuster.at</string>
    <string name="library_reaktor_libraryName">Reaktor</string>
    <string name="library_reaktor_libraryDescription">Reaktor is a framework for a reactive and unidirectional application architecture.</string>
    <string name="library_reaktor_libraryWebsite">https://github.com/floschu/Reaktor</string>
    <string name="library_reaktor_libraryVersion">0.0.1</string>
    <string name="library_reaktor_isOpenSource">true</string>
    <string name="library_reaktor_repositoryLink">https://github.com/floschu/Reaktor</string>
    <string name="library_reaktor_classPath">at.florianschuster.reaktor</string>
    <string name="library_reaktor_licenseId">apache_2_0</string>
</resources>
```

## License

```
Copyright 2019 Florian Schuster.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```