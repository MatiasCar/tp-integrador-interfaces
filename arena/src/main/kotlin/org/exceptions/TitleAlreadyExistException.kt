package org.exceptions

import java.lang.Exception

open class TitleAlreadyExistException(mensaje : String) : Exception(mensaje) {
}