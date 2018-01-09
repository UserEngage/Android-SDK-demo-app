# Configuration

## Add UserEngage SDK to your app:

Copy userengage-sdk.aar into your libs directory in app module.

In **top level build.gradle** file add:
```groovy
allprojects {
    repositories {
        jcenter()
        flatDir {
            dirs 'libs'
        }
    }
}
```

Then in **app module build.gradle**:
```groovy
    compile(name:'userengage-sdk', ext: 'aar')
```

## Configure SDK in your app:
```java
public class App extends Application {

    public static final String TAG = App.class.getSimpleName();
    private UserEngage userEngage;

    @Override
    public void onCreate() {
        super.onCreate();
        userEngage = new UserEngage.Builder()
                .context(this) //application context
                .apiKey("api_secret") //your api secret key generated in panel [url]
                .baseUrl("http://localhost:8080/") //use only if you have self hosted UE engine
                .trackActivities()
                .build();
    }
}
```