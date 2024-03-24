import axios from "axios";
import { server } from "../components/submit/URLShortBox";

async function linkRedirectionLoader({ params }) {
  console.log("from here: " + params.code);
  try {
    const result = await axios.get(
      server + "get-url?shortURLCode=" + params.code
    );
    return result.data;
  } catch (error) {
    console.error(error);
  }
}

export default linkRedirectionLoader;
