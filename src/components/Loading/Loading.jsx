import { useLoaderData, useNavigate } from "react-router-dom";
import { useEffect } from "react"
import loader from "../../assets/fidget-spinner.svg"
import "./Loading.css"

function Loading() {
  const loadedData = useLoaderData();
  const navigate = useNavigate();
  // TODO: Figure out a way to allow the webpage to navigate to the desired link that the user requested to save!
  useEffect(() => {
    navigate("https://www." + loadedData, {replace: true})
  })
  return (
    <div className="loader">
        Loading...
        <img src={loader} alt="loading"/>
    </div>
  )
}

export default Loading;
