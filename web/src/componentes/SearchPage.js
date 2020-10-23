import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import axios from 'axios'
import Nav from './NavBar'
import NotaResumen from './NotaResumen'

function SearchPage(){

    const [resBusqueda, setResBusqueda] = useState([]);
    
    let {search} = useParams()

    function buscar(){
        axios.get("http://localhost:7000/search?text="+search)
        .then(success => setResBusqueda(success.data.content))
        .catch(error => console.log(error))
    }

    useEffect(()=>{
        buscar()
    },[search]);


    return(
        <div>
            <Nav/>
            <center><h1>Resultados encontrados : {+ resBusqueda.length}</h1></center>
            <div className="container">
                {resBusqueda.map( note =>(
                    <NotaResumen key={note.id} note={note} />
                    )
                        
                    )}
            </div>
        </div>
    );
}

export default SearchPage;