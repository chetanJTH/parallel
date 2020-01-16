package Constants;

import utils.Devices;

public class Constants {

    public static final boolean IS_PRODUCTION = false;
    public static final boolean NO_RESET = true;
    public static final boolean FULL_RESET = false;
    public static final Devices devices = Devices.moto;


    public static final String getAppPath(){
        if (IS_PRODUCTION) {
            return "src/app/driver-release.apk";
        }
        return "src/app/driver.apk";
    }

    public static final String getAppPackage(){
        if (IS_PRODUCTION) {
            return "com.invitationcardmaker.videomaker";
        }
        return "com.invitationcardmaker.videomaker";
    }

    public static final String getAppActivity(){
        if (IS_PRODUCTION) {
            return "com.ui.activity.SplashActivity";
        }
        return "com.ui.activity.SplashActivity";
    }

    public static final String prefixID(){
        if (IS_PRODUCTION) {
            return "driver.facecar.com.facecardriver:id/";
        }
        return "driver.facecar.com.facecardriver.dev:id/";
    }
}
