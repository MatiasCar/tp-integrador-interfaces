import React from 'react'
import '../estilos/Notas.css'

function Comment({comentario}){

    const {author, body} = comentario;
    const photo = comentario.author.photo

    return(
        
        <div className="comentario">
            <img 
                src= {photo}
                alt= {"foto de perfil de "+author.name}
                />
                
            <p>{author.name} </p>
            <p>{body} </p>
        </div>
        
        );
}

export default Comment;