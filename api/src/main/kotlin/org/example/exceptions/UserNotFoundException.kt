package org.example.exceptions

import org.omg.CORBA.UserException

class UserNotFoundException() : UserException("Usuario no encontrado") {
}