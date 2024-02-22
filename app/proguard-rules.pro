# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep all classes in the Jetpack Compose package
-keep class androidx.compose.** { *; }

# Keep classes that use Compose's @Composable annotation
-keep @androidx.compose.runtime.Composable class * {
    <methods>;
}

# Keep ViewModel classes to prevent issues with saved state
-keep class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}

# Keep all classes used
-keep class com.example.jlp.data.model.** { *;}
-keep class com.example.jlp.data.api.** { *;}
-keep class com.example.jlp.data.repository.** { *;}

-keep class com.example.jlp.di.** { *;}

-keep class com.example.jlp.domain.** { *;}
-keep class com.example.jlp.domain.usecases.** { *;}

-keep class com.example.jlp.presentation.components.** { *;}
-keep class com.example.jlp.presentation.screens.** { *;}
-keep class com.example.jlp.presentation.viewmodel.** { *;}
-keep class com.example.jlp.MainActivity {
    public <fields>;
    public <methods>;
}

-keep class com.example.jlp.data.model.**{
private <fields>;
}

#