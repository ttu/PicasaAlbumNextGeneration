//------------------------------------------------------------------------------
// Copyright (c) 2012 Microsoft Corporation. All rights reserved.
//------------------------------------------------------------------------------

package com.microsoft.live;

final public class LiveConfig {
    public static final String CLIENT_ID = "00000000440D581C";

    public static final String[] SCOPES = {
        "wl.signin",
        "wl.basic",
        "wl.offline_access",
        "wl.skydrive_update",
        "wl.contacts_create",
    };

    private LiveConfig() {
        throw new AssertionError("Unable to create Config object.");
    }
}