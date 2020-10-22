import React, { useEffect, useState } from 'react';
import axios from 'axios'
import '../estilos/Nota.css'
import NotaResumen from './NotaResumen';
import Nav from './NavBar'

function Home(){

    const [ultimasNotas, setUltimasNotas] = useState( [] );


    useEffect(()=> {
          
            const obtenerDatos = async() =>{
                await axios.get("http://localhost:7000/content")
            .then(response => {
                
                setUltimasNotas(response.data.content)
                
            })
            .catch(error => console.log(error))
            }
            obtenerDatos()
        
            }, []     
    )
            

   
        

    return(
        
       <div className="body">
           <Nav/>
           <center><h1>Ultimos agregados :</h1></center>
            <div className="container">
                
                {ultimasNotas.map( note =>(
                   <NotaResumen key={note.id} note={note} />
                )
                    
                )}
                
            </div> 
            
            
       </div>
        
    );


}

export default Home;