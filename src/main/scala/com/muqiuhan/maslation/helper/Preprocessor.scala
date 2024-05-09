package com.muqiuhan.maslation.helper

trait Preprocessor:
  def apply(source: String): String

object PDFInputPreprocessor extends Preprocessor:

  def apply(source: String): String =
    source
      .replaceAll("-\\R", "")
      .replaceAll("\\R", "")
      .trim

object PDFOutputPreprocessor extends Preprocessor:

  def apply(source: String): String =
    println(source)
    source
      .replaceAll("\\R", "")
      .replaceAll("。", "。\n")
      .replaceAll("\\.", ".\n")
