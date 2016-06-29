# PagerIndicatorBinder

PagerIndicatorBinder is a library that provides the ability to attach indicators to ViewPagers,
so that the user may see their current position within the ViewPager.

There are libraries out there who do the same thing. However, most of them do not offer much
customization on these indicators, and they also don't let you easily select the location of
the indicators. With PagerIndicatorBinder, one simply uses one method to bind a ViewPager to a
ViewGroup that will hold the indicators, and is therefore very simple to use and open to
modification.

## Referencing the Library

The library may be referenced by either downloading and importing the library directly, referencing
it as a Maven dependency, or referencing it as a Gradle dependency.

Put dependencies here

## Usage

To create the indicators for a ViewPager, simply define in your layout a ViewPager and a ViewGroup-
based container that will hold your indicators. Then use the following lines of code to connect the
ViewPager to the container:

`PagerIndicatorBinder.bind(viewPager, viewGroup, R.drawable.selectedRes, R.drawable.unselectedRes);`

This will populate the viewGroup with containers, and presto! You have indicators for your ViewPager.

## License