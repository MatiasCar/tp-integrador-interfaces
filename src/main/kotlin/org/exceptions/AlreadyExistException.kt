package org.exceptions

import java.lang.Exception

open class AlreadyExistException(mensaje : String) : Exception(mensaje) {
}