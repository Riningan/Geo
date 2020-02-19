# geoplatform
-keep class org.findmykids.geo.common.model.Command**
-keep class org.findmykids.geo.common.model.Configuration**
-keep class org.findmykids.geo.common.model.Geo**
# toothpick
-keep class **__Factory { *; }
-keep class **__MemberInjector { *; }
-keepclasseswithmembers class * { @javax.inject.Inject <init>(...); }

-keep class org.findmykids.sample.App