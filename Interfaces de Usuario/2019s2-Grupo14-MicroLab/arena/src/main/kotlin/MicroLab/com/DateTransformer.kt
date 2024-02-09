package MicroLab.com

import org.uqbar.arena.bindings.ValueTransformer
import org.uqbar.commons.model.exceptions.UserException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class DateTransformer : ValueTransformer<LocalDate, String> {
    val pattern = "dd-MM-yyyy"
    val formatter = DateTimeFormatter.ofPattern(pattern)

    override fun getModelType() = LocalDate::class.java
    override fun getViewType() = String::class.java
    //@Throws(Exception::class, UserException::class)

    override fun modelToView(valueFromModel: LocalDate): String = valueFromModel.format(formatter)

    override fun viewToModel(valueFromView: String): LocalDate {
        try {
            return LocalDate.parse(valueFromView, formatter)
        } catch (e: DateTimeParseException) {
            throw UserException("Fecha incorrecta, por favor use $pattern")
        }
    }
}