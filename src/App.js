import "./App.css";
import Submit from "./components/submit/Submit";
import forest from "./assets/forest.jpg";

function App() {
  return (
    <div className="App">
      <div className="urlShort">
        <div className="urlShortBox">
          <div className="centerText">
            <h4>Simplify your links, enter your link here.</h4>
            <form formAction="" className="urlLinkBox">
              <input className="linkInput" />
              <Submit />
            </form>
          </div>
        </div>
        <div className="urlExplain">
          <h3>
            Better be on the toilet then not be on the toilet and have to go
          </h3>
          <p>
            We'll begin by talking about how it means to waste soap. The liquid
            soap is a nice idea for the house. We can talk about random things
            while watching two and a half men. With this show we are able to see
            new things that do not manage to keep themselves the same as they
            always are if you know what I mean.
          </p>
          <p>
            This sentence is on a run-on sentence. The random words that are
            typed in this paragraph provides us with a representation of how the
            world will truly feel from there.
          </p>
        </div>
        <img className="picture" src={forest} alt="forest"></img>
      </div>
    </div>
  );
}

export default App;
