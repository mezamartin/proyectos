package MicroLab.com

class EmailExist() : Exception("El email ya existe en el sistema, ingrese otro"){}
class CvuException() : Exception("El cvu no existe en el sistema"){}
class SaldoNegativoException() : Exception("Saldo no puede ser menor o igual a 0"){}
class InvalidCardNumberException() : Exception("Numero de tarjeta mal formado"){}
class InvalidCVUException(): Exception("CVU mal formado"){}
