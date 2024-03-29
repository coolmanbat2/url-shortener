import { useLoaderData} from "react-router-dom";
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
        <h2>Loading...</h2>
        <img src={loader} alt="loading"/>
    </div>
  )
}

export default Loading;
