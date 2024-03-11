import React from "react";
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';
import IconButton from '@mui/material/IconButton';

function Submit() {
    // Send over information that was given by the user to the server.
    function sendInfo() {
        
    }


   return (
       <IconButton onClick={sendInfo} color="primary" aria-label="submit"> 
            <ArrowForwardIcon/>
       </IconButton> 
   ) 
}

export default Submit