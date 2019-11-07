/*
 * Copyright (C) 2019 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class DerpBuildTypePreferenceController  extends BasePreferenceController {

    private static final String TAG = "DerpBuildTypePreferenceController";
    private static final String DERP_BUILDTYPE = "ro.aosip.buildtype";

    public DerpBuildTypePreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        String buildType = SystemProperties.get(DERP_BUILDTYPE);
        switch (buildType) {
            case "Official":
                return mContext.getString(R.string.derp_official, buildType);
            case "CI":
                return mContext.getString(R.string.derp_ci, buildType);
            case "Private":
                return mContext.getString(R.string.derp_private, buildType);
            default:
                return mContext.getString(R.string.derp_community);
        }
    }
}

