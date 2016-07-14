# IndicatorBinder

IndicatorBinder is a library that provides the ability to attach indicators to ViewPagers,
so that the user may see their current position within the ViewPager.

<img src="demo.gif" height="500px" />

There are libraries out there who do the same thing. However, most of them do not offer much
customization on these indicators, and also don't allow you to easily select the location of
the indicators. With PagerIndicatorBinder, one simply uses one method to bind a ViewPager to a
ViewGroup that will hold the indicators, and is therefore very easy to use and open to
modification.

Also feel free to reference the sample application.

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
        compile 'com.github.vontell:IndicatorBinder:v0.1.1-alpha'
}
```

## Usage

To create the indicators for a ViewPager, simply define in your layout a ViewPager and a ViewGroup-
based container that will hold your indicators. Then use the following lines of code to connect the
ViewPager to the container:

`IndicatorBinder.bind(context, viewPager, viewGroup, R.drawable.selectedRes, R.drawable.unselectedRes);`

This will populate the viewGroup with indicators, and presto! You have indicators for your ViewPager.

**NEW**: You can now add **text tabs** to your ViewPagers with this simple method (custom view coming soon):
`IndicatorBinder.bindTextTabs(context, viewPager, tabContainer, tabViews, R.color.selectedBackgroundColor, R.color.unselectedBackgroundColor, R.color.selectedTextColor, R.color.unselectedTextColor);`

NOTE: Full documentation can be found within the wiki!

## License
The MIT License (MIT)

Copyright (c) 2016 Aaron Vontell

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
