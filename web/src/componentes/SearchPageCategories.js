import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import axios from 'axios'
import Nav from './NavBar'
import NotaResumen from './NotaResumen'
import '../estilos/Notas.css'

function SearchPageCategories(){

    const [resBusqueda, setResBusqueda] = useState([]);

    let {name} = useParams();

    function buscarPorCategoria(){
        axios.get("http://localhost:7000/category/"+name)
        .then(success=> setResBusqueda(success.data.categories))
        .catch(error=>console.log(error))
    }

    useEffect(()=>{
        buscarPorCategoria()
    },[name]);


    return(
        <div className="body-search">
            <Nav/>
            <center><h1>Resultados encontrados para "{name}" : {+ resBusqueda.length}</h1></center>
            <div className="container">
                {resBusqueda.map( note =>(
                    <NotaResumen key={note.id} note={note} />
                    )
                        
                    )}
            </div>
            
        </div>
    );

}

export default SearchPageCategories;