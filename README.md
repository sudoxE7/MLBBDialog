# MLBBDialog
MLBB Dialog Library for Android

## Screenshots
<p align="left">
<img src="/images/mlbb_dialog_new_layout.jpg" width=25%/>
<img src="/images/mlbb_dialog_old_layout.jpg" width=25%/>
</p>

## Including in your project
[![](https://jitpack.io/v/sudoxE7/MLBBDialog.svg)](https://jitpack.io/#sudoxE7/MLBBDialog)

### Gradle
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
And add a dependency code to your **module**'s `build.gradle` file.
```gradle
dependencies {
        implementation 'com.github.sudoxE7:MLBBDialog:1.0.0'
}
```

## Default Usage
Add in your Activity file.
```java
new MLBBDialogBuilder(MainActivity.this, Style.NEW)
        .setTitle(getString(R.string.title))
        .setSubtitle(getString(R.string.subtitle))
        .setCancelable(true)
        .setPositiveListener(getString(R.string.positive), new MLBBDialogClickListener() {
            @Override
            public void onClick(MLBBDialog mLBBDialog) {
                finishAffinity();
                mLBBDialog.dismiss();
            }
        })
        .setNegativeListener(getString(R.string.negative), new MLBBDialogClickListener() {
            @Override
            public void onClick(MLBBDialog mLBBDialog) {
                mLBBDialog.dismiss();
            }
        })
        .build().show();
```

## How to hide Negative Button
Just remove in build:
```java
.setNegativeListener(getString(R.string.negative), new MLBBDialogClickListener() {
    @Override
    public void onClick(MLBBDialog mLBBDialog) {
        mLBBDialog.dismiss();
    }
})
```

## How to add Custom Font
Just add in build:
```java
.setFont(Typeface.createFromAsset(getAssets(),"fonts/anastasia.ttf"))
```

## Style
To change the style of MLBB Dialog
```java
Style.OLD
Style.NEW
```

#
// Credit to Exodus
