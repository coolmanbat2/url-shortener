import React from "react";
import { useState } from "react";
import Paper from "@mui/material/Paper";
import InputBase from "@mui/material/InputBase";
import IconButton from "@mui/material/IconButton";
import ArrowForwardIcon from "@mui/icons-material/ArrowForward";
import axios from "axios";

export const server = "http://localhost:8080/";

function URLShortBox() {
  const [shortCode, setShortCode] = useState("");
  // Send over information that was given by the user to the server.
  async function sendInfo() {
    var link = document.getElementById("link").value;
    try {
      const formData = axios.toFormData({ originalLink: link });
      const response = await axios.post(server + "add-url", formData);
      console.log(response.data.originalLink);
      setShortCode(response.data.shortURLCode);
    } catch (error) {
      console.error(error);
    }
  }

  return (
    <div>
      <Paper
        component="form"
        sx={{
          p: "2px 4px",
          display: "flex",
          alignItems: "center",
          width: 400,
          borderRadius: 3,
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
          type="button"
          sx={{ p: "10px" }}
          aria-label="submit"
        >
          <ArrowForwardIcon />
        </IconButton>
      </Paper>
      <p>{shortCode}</p>
    </div>
  );
}

export default URLShortBox;
