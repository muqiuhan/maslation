package com.muqiuhan.maslation.helper

import com.muqiuhan.maslation.errors

enum Error extends errors.Error:
    case CannotGetTheClipboardValue
    case CannotGetTheSelectionValue
