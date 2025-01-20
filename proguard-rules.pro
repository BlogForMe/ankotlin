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



#debugAndroidTest/missing_rules.txt
-dontwarn com.google.auto.value.AutoValue
-dontwarn java.lang.instrument.UnmodifiableClassException
-dontwarn org.junit.jupiter.api.extension.AfterEachCallback
-dontwarn org.junit.jupiter.api.extension.ExtensionContext
-dontwarn org.junit.jupiter.api.extension.ParameterContext
-dontwarn org.junit.jupiter.api.extension.ParameterResolver
-dontwarn org.junit.jupiter.api.extension.TestInstancePostProcessor



-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.conscrypt.Conscrypt$Version
-dontwarn org.conscrypt.Conscrypt
-dontwarn org.conscrypt.ConscryptHostnameVerifier
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE


# Keep Hilt-generated components and classes
-keep class dagger.hilt.** { *; }
-keep class dagger.hilt.android.** { *; }
-keep class hilt_aggregated_deps.** { *; }

# Keep Hilt's internal annotations used for component generation
-keep @dagger.hilt.InstallIn public interface *
-keep @dagger.hilt.DefineComponent public interface *
-keep @dagger.hilt.DefineComponent.Builder public interface *

# Keep annotations that are used by Hilt for processing
-keep @dagger.Module public class *
-keep @dagger.hilt.android.HiltAndroidApp public class *
-keep @dagger.hilt.EntryPoint public interface *
-keep @dagger.hilt.components.SingletonComponent public interface *

# Prevent obfuscation of Dagger/Hilt-related annotations
-keepattributes RuntimeVisibleAnnotations
-keepattributes Annotation

# Prevent obfuscation of classes annotated with Hilt annotations
-keep @dagger.hilt.android.lifecycle.HiltViewModel public class *
-keep @javax.inject.Inject public class *
-keep @dagger.hilt.android.AndroidEntryPoint public class *




# Keep Status enum class from being obfuscated
-keep class com.kot.proguard.ProguardStatus { *; }

## Keep the enum constants from being obfuscated
#-keepclassmembers class com.kot.proguard.Status {
#    public static ** enumValues();
#    public static ** valueOf(java.lang.String);
#}
