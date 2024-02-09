package MicroLab.com.exceptions

import kotlin.Exception

class EmailException(message : String?) : Exception(message)

class DeleteUserException(message: String?) : Exception(message)