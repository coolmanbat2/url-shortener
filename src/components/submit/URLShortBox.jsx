import React from "react";
import { useState } from "react";
import Paper from "@mui/material/Paper";
import InputBase from "@mui/material/InputBase";
import IconButton from "@mui/material/IconButton";
import ArrowForwardIcon from "@mui/icons-material/ArrowForward";
import axios from "axios";

export const server = "http://localhost:8080/";

function URLShortBox() {
  const [shortCodeLink, setShortCodeLink] = useState("");
  const webDomain = "http://localhost:3000/"
  // Send over information that was given by the user to the server.
  async function sendInfo() {
    var link = document.getElementById("link").value;
    try {
      const formData = axios.toFormData({ originalLink: link });
      const response = await axios.post(server + "add-url", formData);
      console.log(response.data.originalLink);
      const result = webDomain + response.data.shortURLCode;
      setShortCodeLink(result);
      // This part is where the user will be redirected to the link automatically. 
      // You can remove this part if the user is not interested in it.
      // window.location.href = result;
    } catch (error) {
      console.error(error);
    }
  }



  return (
    <div>
      <Paper
        component="form"
        action="javascript:void(0);"
        sx={{
          p: "2px 4px",
          display: "flex",
          alignItems: "center",
          width: 305,
          borderRadius: 3,
          marginRight: 10,
          marginLeft: 10 
        }}
      >
        <InputBase
          sx={{ ml: 1, flex: 1 }}
          placeholder="google.ca/"
          inputProps={{ "aria-label": "link" }}
          id="link"
        />
        <IconButton
          onClick={sendInfo}
          type="submit"
          sx={{ p: "10px" }}
          aria-label="submit"
        >
          <ArrowForwardIcon />
        </IconButton>
      </Paper>
      <p className="title">{shortCodeLink}</p>
    </div>
  );
}

export default URLShortBox;
