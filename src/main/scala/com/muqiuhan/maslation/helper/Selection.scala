package com.muqiuhan.maslation.helper

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import scala.util.{Try, Success, Failure}
import com.muqiuhan.maslation.helper.Error

object Selection:
    def apply(): Option[String] =
        Try[String](
            Toolkit
                .getDefaultToolkit
                .getSystemSelection
                .getData(DataFlavor.stringFlavor)
                .toString) match
            case Success(value) => Some(value)
            case Failure(e)     => Error.CannotGetTheClipboardValue.report(e); None
end Selection
