package utils

import play.api.libs.json.{Format, JsError, JsPath, JsString, JsSuccess, JsonValidationError}

object CodecUtils {
  def generateCodec[T](values: Seq[T]): Format[T] = Format(
    {
      case JsString(str) =>
        values.find(_.toString == str)
          .map(JsSuccess(_))
          .getOrElse(JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.validenumvalue")))))
      case _ => JsError(Seq(JsPath -> Seq(JsonValidationError("error.expected.enumstring"))))
    },
    (value: T) => JsString(value.toString)
  )
}
