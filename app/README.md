The app has following packages:
adapter: It contains adapter for showing the api data in recyclerview
base: contains Base Interface and Extensions file for accessing the common methods

model: It contains response model
utils: Utility classes.
network : Network classes for accesing the network calls using retrofit
view : UI coponents
viewModel : for interaction the view and network calls

This project follows the MVVM architecture in Kotlin

Libraries used :

Retrofit

Android Libraries ( appcompat, design support, data binding, etc )

Rx Java 2 + Rx Android

Setup included :

Data Binding
Using Android Data Binding Library
ViewModel is inside viewmodel package

FirstScreen -> showing the article data fectched from NYTime api
Second Screen -> show the article details

Note -> You need to signup the for an api key on NYTimes portal https://developer.nytimes.com/get-started




