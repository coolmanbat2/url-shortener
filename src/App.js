import "./App.css";
import URLShortBox from "./components/submit/URLShortBox";

function App() {
  return (
    <div className="App">
      <div className="urlShort">
        <div className="urlShortBox">
          <h4 className="title header">Simplify your links, enter your link here.</h4>
          <form formAction="" className="urlLinkBox">
            <URLShortBox />
          </form>
        </div>
        <div className="lineBreaker"/>
        <div className="urlExplain">
          <h4 className="header">
            Better be on the toilet then not be on the toilet and have to go
          </h4>
          <p className="bodyText">
            We'll begin by talking about how it means to waste soap. The liquid
            soap is a nice idea for the house. We can talk about random things
            while watching two and a half men. With this show we are able to see
            new things that do not manage to keep themselves the same as they
            always are if you know what I mean.
          </p>
          <p className="bodyText">
            This sentence is on a run-on sentence. The random words that are
            typed in this paragraph provides us with a representation of how the
            world will truly feel from there.
          </p>
        </div>
      </div>
    </div>
  );
}

export default App;
