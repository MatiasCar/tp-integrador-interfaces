import React from 'react'
import '../estilos/Notas.css'

function Comment({comentario}){

    const {author, body} = comentario;

    return(
        
        <div className="comentario">

            <p>Autor: {author.name} </p>
            <p>Message: {body} </p>
        </div>
        
        );
}

export default Comment;