import React, {useState} from 'react';
import { Link } from 'react-router-dom';

function Nota({note}){
    const {title, author, categories} = note;

    return(
        <div className="note">
        <p className="textoNota">Title: {title}</p>    
        <p className="textoNota">Author: {author}</p>
        <p className="textoNota">Categories: {categories}</p>
        <Link to="/login" className="btn btn-info">Ver nota</Link>
      </div>
    );
}

export default Nota;