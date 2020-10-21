import React, { useEffect, useState } from 'react';
import axios from 'axios'

function Home(){

    const [ultimasNotas, setUltimasNotas] = useState( {notas : []} );


    useEffect(()=> {
          
            axios.get("http://localhost:7000/content")
            .then(response => {console.log(response.data)
                setUltimasNotas(response.data)
            })
            .catch(error => console.log(error))
            }, []     
    )
            
        

    return(
       <div>
            <h1>hola</h1>
       </div>
        
    );


}

export default Home;