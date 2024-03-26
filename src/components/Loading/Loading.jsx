import { useLoaderData, useNavigate } from "react-router-dom";
import { useEffect } from "react"
import loader from "../../assets/fidget-spinner.svg"
import "./Loading.css"

function Loading() {
  const loadedData = useLoaderData();
  useEffect(() => {
    window.location.replace(loadedData);
  })
  return (
    <div className="loader">
        Loading...
        <img src={loader} alt="loading"/>
    </div>
  )
}

export default Loading;
