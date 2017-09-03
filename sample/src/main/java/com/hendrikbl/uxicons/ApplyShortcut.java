/*
 * Copyright (c) 2017 Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Special thanks to the project contributors and collaborators
 * 	https://github.com/jahirfiquitiva/IconShowcase#special-thanks
 */

package com.hendrikbl.uxicons;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import jahirfiquitiva.iconshowcase.config.Config;
import jahirfiquitiva.iconshowcase.utilities.LauncherIntents;
import jahirfiquitiva.iconshowcase.utilities.utils.Utils;

public class ApplyShortcut extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String launcherPackage = Utils.getDefaultLauncherPackage(this);
        if (launcherPackage != null && launcherPackage.length() > 0) {
            try {
                new LauncherIntents(this, launcherPackage);
            } catch (Exception e) {
                startHomeActivity();
            }
        } else {
            startHomeActivity();
        }
        finish();
    }

    private void startHomeActivity() {
        Intent home = new Intent(this, HomeActivity.class);
        home.setAction(Config.APPLY_ACTION);
        startActivity(home);
    }
}