package MicroLab.com.beneficios

import MicroLab.com.DateTransformer
import org.uqbar.arena.bindings.ValueTransformer
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException
import wallet.DigitalWallet
import wallet.DiscountGiftStrategy
import wallet.FixedGiftStrategy
import wallet.LoyaltyGift
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


@Observable class Gift(var name : String) {
    fun type() = "$name"
}


@Observable
class BenefitsModel(val digitalWallet : DigitalWallet) {

    var nombre = ""

    var fechaDesde: LocalDate? = null
    var fechaHasta: LocalDate? = null
    var importe = ""
    var cantidadOperaciones = ""
    var importeOperacion = ""
    var types = listOf(
        Gift("Descuento"),
        Gift("Regalo")
    )
    var descuento = types[0]
    var regalo = types[1]

    fun createBenefit() {
        var dt = DateTransformer()

        if (descuento == types[0]) {
            digitalWallet.addLoyalty(LoyaltyGift(
                nombre,
                DiscountGiftStrategy(importe.toDouble()),
                cantidadOperaciones.toInt(),
                importeOperacion.toDouble(),
                dt.viewToModel(fechaDesde!!.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
                dt.viewToModel(fechaHasta!!.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))

            ))
        } else {
            digitalWallet.addLoyalty(LoyaltyGift(
                nombre, FixedGiftStrategy(importe.toDouble()), cantidadOperaciones.toInt(),
                importeOperacion.toDouble(),
                dt.viewToModel(fechaDesde!!.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))),
                dt.viewToModel(fechaHasta!!.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
            ))
        }
        check(fechaDesde!!.isAfter(LocalDate.now()) || fechaDesde!!.equals(LocalDate.now()) ){"La fecha debe ser actual"}
        check(fechaHasta!!.isAfter(fechaDesde)){"La fecha debe ser mayor a la 'Fecha Desde"}
    }
}


