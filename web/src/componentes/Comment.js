import React from 'react'

function Comment({comentario}){

    const {author, body} = comentario;

    return(
        
        <div className="container">

            <p>Autor: {author} </p>
            <p>Mensaje: {body} </p>
        </div>
        
        );
}

export default Comment;