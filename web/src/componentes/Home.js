import React, { useEffect, useState } from 'react';
import axios from 'axios'
import Note from './Nota'
import '../estilos/Nota.css'

function Home(){

    const [ultimasNotas, setUltimasNotas] = useState( [] );


    useEffect(()=> {
          
            const obtenerDatos = async() =>{
                await axios.get("http://localhost:7000/content")
            .then(response => {
                console.log("respuesta",response.data.content)
                setUltimasNotas(response.data.content)
                
            })
            .catch(error => console.log(error))
            }
            obtenerDatos()
        
            }, []     
    )
            

   
        

    return(
        
       <div>
           <center><h1>Ultimos agregados :</h1></center>
            <div className="container">
                
                {ultimasNotas.map( note =>(
                   <Note key={note.id} note={note} />
                )
                    
                )}
                
            </div> 
            
            
       </div>
        
    );


}

export default Home;