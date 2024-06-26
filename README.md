- # maslation (WIP)
  - Minimalist cross-platform translation app
  - Copyright (c) 2024 Muqiu Han
  - Issues: https://github.com/muqiuhan/maslation/issues
  - Contribution: https://github.com/muqiuhan/maslation/pulls

- ![./resources](./resources/screenshot.png)

- ## TODO
  - [x] [translate-shell](https://github.com/soimort/translate-shell)
  - [x] System tray
  - [x] Hotkey (F9)
  - [ ] Custom config
  - [ ] Network API
  - [ ] Multiple translation sources
  - [ ] Refactor messy code
  - [ ] Wayland (?)

- ## Dependencies
  - ```scala
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
      "com.formdev" % "flatlaf" % "3.4.1",
      "com.github.kwhat" % "jnativehook" % "2.2.2"
    )
    ```

- ## [LICENSE](./LICENSE)
  - ```
    Copyright (c) 2024 Muqiu Han
  
    All rights reserved.
  
    Redistribution and use in source and binary forms, with or without modification,
    are permitted provided that the following conditions are met:
  
        * Redistributions of source code must retain the above copyright notice,
          this list of conditions and the following disclaimer.
        * Redistributions in binary form must reproduce the above copyright notice,
          this list of conditions and the following disclaimer in the documentation
          and/or other materials provided with the distribution.
        * Neither the name of maslation nor the names of its contributors
          may be used to endorse or promote products derived from this software
          without specific prior written permission.
  
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
    "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
    LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
    A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
    CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
    EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
    PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
    PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
    NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
    SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
    ```
