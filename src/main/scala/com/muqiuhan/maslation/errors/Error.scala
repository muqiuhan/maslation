package com.muqiuhan.maslation.errors

import com.muqiuhan.maslation.view

object Error:
    inline def stackTraceElementsToString(exn: Throwable): String =
        exn
            .getStackTrace
            .map(_.toString())
            .reduce((s1: String, s2: String) => s1.concat("\n").concat(s2))
    end stackTraceElementsToString
end Error

trait Error:
    override def toString: String = s"$this: "

    inline def report(e: Throwable, message: String = ""): Unit =
        view.ErrorWindow(
            if message.isEmpty() then
                s"$this"
            else
                s"$this: $message"
            ,
            Error.stackTraceElementsToString(e)
        )
    end report

    inline def reportAndExit(e: Throwable = new Exception(), message: String = ""): Nothing =
        report(e, message)
        throw e

end Error
