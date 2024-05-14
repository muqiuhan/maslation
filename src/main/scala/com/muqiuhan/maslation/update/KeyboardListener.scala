package com.muqiuhan.maslation.update

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import scala.util.Try
import scala.util.Success
import scala.util.Failure

import com.muqiuhan.maslation.errors

class KeyboardListener(_shortcuts: String, callback: () => Unit) extends NativeKeyListener:

    private val shortcuts = _shortcuts.split("\\+")
    private val status    = collection.mutable.Set[String]()

    def startListener(): Unit =
        Try(GlobalScreen.registerNativeHook()) match
            case Success(value) => GlobalScreen.addNativeKeyListener(this)
            case Failure(e) =>
                Error.UnsupportKeyboardListener.report(e, "There was a problem registering the keyboard native hook.")
                System.exit(0)

    end startListener

    def stopListener(): Unit =
        Try(GlobalScreen.unregisterNativeHook()) match
            case Failure(e) =>
                Error.CannotUnregisterNativeHook.report(e)
                System.exit(0)
            case _ => ()
    end stopListener

    override def nativeKeyPressed(nativeEvent: NativeKeyEvent): Unit =
        status.add(NativeKeyEvent.getKeyText(nativeEvent.getKeyCode()))
        if shortcuts.length == status.size && shortcuts.forall(status.contains(_)) then
            callback()
        else ()
    end nativeKeyPressed

    override def nativeKeyReleased(nativeEvent: NativeKeyEvent): Unit =
        status.clear()

end KeyboardListener
