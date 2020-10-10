package org.example.exceptions

import org.omg.CORBA.UserException
import java.lang.Exception

class UserNameExistException(email : String) : UserException("ya existe un correo con la direccion : $email")