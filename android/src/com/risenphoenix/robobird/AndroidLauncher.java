package com.risenphoenix.robobird;

import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.InterstitialCallbacks;
import com.appodeal.gdx.GdxAppodeal;
import com.appodeal.gdx.callbacks.BannerCallback;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.risenphoenix.robobird.ZBGame;

public class AndroidLauncher extends AndroidApplication {

	private boolean flag;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		config.useCompass=false;
		config.useAccelerometer=false;
		config.useGyroscope=false;
		flag = false;

		initialize(new ZBGame(), config);

		Appodeal.disableNetwork(this, "cheetah");
		String appKey = "c27a514ebdc180ec93ca1bf102738025938bf612c8c6d622";
		com.appodeal.gdx.GdxAppodeal.disableLocationPermissionCheck();

		//Appodeal.setAutoCache(Appodeal.INTERSTITIAL|com.appodeal.gdx.GdxAppodeal.BANNER, false);
		com.appodeal.gdx.GdxAppodeal.initialize(appKey, com.appodeal.gdx.GdxAppodeal.INTERSTITIAL |com.appodeal.gdx.GdxAppodeal.BANNER);//
		//Appodeal.cache(this, Appodeal.INTERSTITIAL|com.appodeal.gdx.GdxAppodeal.BANNER);

		Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
			public void onInterstitialLoaded(boolean isPrecache) {
				Log.d("Appodeal", "onInterstitialLoaded");
				if(!flag) {
					if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {
						GdxAppodeal.show(GdxAppodeal.INTERSTITIAL);
						flag=true;
					}
				}
			}
			public void onInterstitialFailedToLoad() { }
			public void onInterstitialShown() { }
			public void onInterstitialClicked() { }
			public void onInterstitialClosed() { }
		});
//When you want to show the ad



		GdxAppodeal.setBannerCallbacks(new BannerCallback() {
			@Override
			public void onBannerLoaded() {
				Log.d("Appodeal", "onBannerLoaded");
				if (Appodeal.isLoaded(GdxAppodeal.BANNER)) {
					GdxAppodeal.show(GdxAppodeal.BANNER_BOTTOM);
				}
			}

			@Override
			public void onBannerFailedToLoad() { }

			@Override
			public void onBannerShown() { }

			@Override
			public void onBannerClicked() { }
		});
	}
}
