import React from 'react';
import { Link } from 'react-router-dom';

function NotaResumen({note}){
    const {id, title, author, categories} = note;

    return(
        <div className="note">
        <p className="textoNota">Title: {title}</p>    
        <p className="textoNota">Author: {author}</p>
        <p className="textoNota">Categorias:
        {categories.map(categoria =>(
          <Link to={"/category/"+categoria} className="btn btn-link" key={categoria}>{categoria}</Link>
        ))}</p>
        <Link to={"/content/"+id} className="btn btn-info">Ver nota</Link>
        
      </div>
    );
}

export default NotaResumen;