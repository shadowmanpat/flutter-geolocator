package com.baseflow.geolocator.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.baseflow.geolocator.errors.ErrorCallback;
import com.baseflow.geolocator.errors.ErrorCodes;

public class LocationAccuracyManager {

  public LocationAccuracyStatus getLocationAccuracy(Context context, ErrorCallback errorCallback) {
      Log.d("nagas", "getLocationAccuracy");
    if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
        == PackageManager.PERMISSION_GRANTED) {
      return LocationAccuracyStatus.precise;
    } else if (ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_COARSE_LOCATION)
        == PackageManager.PERMISSION_GRANTED) {
      return LocationAccuracyStatus.reduced;
    } else {
      errorCallback.onError(ErrorCodes.permissionDenied);
      return null;
    }
  }
}
