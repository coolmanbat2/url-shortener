import React from "react";
import Paper from "@mui/material/Paper";
import InputBase from "@mui/material/InputBase";
import IconButton from "@mui/material/IconButton";
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';

function URLShortBox() {
  // Send over information that was given by the user to the server.
  function sendInfo(props) {
    var link = document.getElementById('link').value
    
  }

  return (
    <Paper
      component="form"
      sx={{ p: "2px 4px", display: "flex", alignItems: "center", width: 400, borderRadius: 3 }}
    >
      <InputBase
        sx={{ ml: 1, flex: 1 }}
        placeholder="https://www.google.ca/"
        inputProps={{ "aria-label": "link" }}
        id="link"
      />
      <IconButton onClick={sendInfo} type="button" sx={{ p: "10px" }} aria-label="submit">
        <ArrowForwardIcon/> 
      </IconButton>
    </Paper>
  );
}

export default URLShortBox;
