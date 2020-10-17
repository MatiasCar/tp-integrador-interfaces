package org.example

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import javalinjwt.JWTGenerator
import javalinjwt.JWTProvider
import org.ui.Author
import org.ui.NotFound


class userGenerator : JWTGenerator<Author> {
    override fun generate(author: Author?, algoritmo: Algorithm?): String {
        val token = JWT.create().withClaim("id", author?.id)
        return token.sign(algoritmo)
    }

}


class MediumTokenJWT {

    val algorithm = Algorithm.HMAC256("Maybe.I.Can.Approve.This?")
    val generator = userGenerator()
    val verifer = JWT.require(algorithm).build()
    val provider = JWTProvider(algorithm,generator,verifer)


    fun generateToken(author : Author): String{
        return provider.generateToken(author)
    }

    fun validate(token : String) : String {
        val validatedToken =provider.validateToken(token)
        if(!validatedToken.isPresent){
            throw NotFound("Token not found")
        }
        return validatedToken.get().getClaim("id").asString()
    }
}