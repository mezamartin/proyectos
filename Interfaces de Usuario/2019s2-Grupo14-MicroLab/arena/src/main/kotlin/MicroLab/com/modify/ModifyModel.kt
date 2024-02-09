package MicroLab.com.modify

import org.uqbar.commons.model.annotations.Observable


@Observable
class State(var name : String) {
    fun estado() = "$name"
}

class ModifyModel {
    var nombre = ""
    var apellido = ""
    var numeroDeDocumento = Double
    var correoElectronico = ""
    var cuentaCVU = ""
    var saldo = Double
    var estados = listOf(
        State("Bloqueado"),
        State("Habilitado")
    )
    var bloqueado = estados[0]
    var habilitado = estados[1]

    /* fun createBenefit() {

         if (descuento == types[0]) {
             digitalWallet.addLoyalty(
                 LoyaltyGift(
                     nombre,
                     DiscountGiftStrategy(importe.toDouble()),
                     cantidadOperaciones.toInt(),
                     importeOperacion.toDouble(),
                     DateTransformer().viewToModel(fechaDesde),
                     DateTransformer().viewToModel(fechaHasta)
                 )
             )
         } else {
             digitalWallet.addLoyalty(
                 LoyaltyGift(
                     nombre, FixedGiftStrategy(importe.toDouble()), cantidadOperaciones.toInt(), importeOperacion.toDouble(),
                     DateTransformer().viewToModel(fechaDesde),
                     DateTransformer().viewToModel(fechaHasta)
                 )
             )
         }
     }*/
}