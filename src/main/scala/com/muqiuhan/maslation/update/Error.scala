package com.muqiuhan.maslation.update

import com.muqiuhan.maslation.errors

enum Error extends errors.Error:
    case UnsupportKeyboardListener
    case CannotUnregisterNativeHook
