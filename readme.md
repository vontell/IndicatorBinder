# IndicatorBinder
[![](https://jitpack.io/v/vontell/IndicatorBinder.svg)](https://jitpack.io/#vontell/IndicatorBinder)

<a href="https://www.buymeacoffee.com/SYwZPjK4F" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/black_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

IndicatorBinder is a library that provides the ability to attach indicators to ViewPagers,
so that the user may see their current position within the ViewPager.

<img src="demo.gif" height="500px" />

There are libraries out there who do the same thing. However, most of them do not offer much
customization on these indicators, and also don't allow you to easily select the location of
the indicators. With PagerIndicatorBinder, one simply uses one method to bind a ViewPager to a
ViewGroup that will hold the indicators, and is therefore very easy to use and open to
modification.

Also feel free to reference the sample application.

Documentation located at: [http://www.avontell.com/indbinder/documentation/index.html](http://www.avontell.com/indbinder/documentation/index.html)

## Referencing the Library

The library may be referenced by either downloading and importing the library directly, referencing
it as a Maven dependency, or referencing it as a Gradle dependency.

1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
2. Add the dependency
```grrovy
dependencies {
        compile 'com.github.vontell:IndicatorBinder:v0.1.3-alpha'
}
```

## Usage

To create the indicators for a ViewPager, simply define in your layout a ViewPager and a ViewGroup-
based container that will hold your indicators. See examples within the `app` folder.

## License
The MIT License (MIT)

Copyright (c) 2016 Aaron Vontell

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
