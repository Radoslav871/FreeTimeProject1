import Welcome from "./components/Welcome";
import LoginPopup from "./components/LoginPopup";
import SignUpPopup from "./components/SignUpPopup";
import {useState} from "react";


function App() {
  const [ loginIsOpen, setLoginIsOpen] = useState(false);
  const [ signUpIsOpen, setSignUpIsOpen] = useState(false);

  const openLoginForm = () => {
    setLoginIsOpen(true);
  }
  const closeLoginForm = () => {
    setLoginIsOpen(false);
  }

  const openSignUpForm = () => {
    setSignUpIsOpen(true);
  }
  const closeSignUpForm = () => {
    setSignUpIsOpen(false);
  }


    return (
        <div>
          <Welcome passDataLogin={openLoginForm} passDataSignUp={openSignUpForm} />
          {loginIsOpen ? <LoginPopup data={closeLoginForm} /> : null}
          {signUpIsOpen ? <SignUpPopup data={closeSignUpForm} /> : null}
        </div>
    )
}
export default App;

