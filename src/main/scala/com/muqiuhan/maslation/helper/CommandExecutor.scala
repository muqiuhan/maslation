package com.muqiuhan.maslation.helper

import java.io.{BufferedReader, InputStreamReader, Closeable, IOException}
import java.util.stream.Collectors

object CommandExecutor:

    def apply(cmd: Array[String]): String =
        val result = new StringBuilder()
        var process: Process | Null = null
        var bufferIn: BufferedReader | Null = null

        try
            process = Runtime.getRuntime.exec(cmd)
            process.waitFor()

            bufferIn = new BufferedReader(new InputStreamReader(process.getInputStream))

            bufferIn.lines().collect(Collectors.joining("\n"))

        finally
            bufferIn match
                case null              => ()
                case _: BufferedReader => bufferIn.close()

            process match
                case null             => ()
                case process: Process => process.destroy()
