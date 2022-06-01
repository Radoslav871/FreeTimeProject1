import Button from "./Button";
import logo from "../images/001Logo.png"

function Welcome(props) {

  return (
          <div className='welcome-grid'>
            <h1>Welcome to card game!</h1>
            <img src={logo}/>
            <h2>Rules:</h2>
            <div className='rules'>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Integer imperdiet lectus quis justo. Duis viverra diam non justo.
              Nulla pulvinar eleifend sem. Vestibulum fermentum tortor id mi. Morbi leo mi,
              nonummy eget tristique non, rhoncus non leo. Curabitur ligula sapien, pulvinar a
              vestibulum quis, facilisis vel sapien. Aliquam erat volutpat. Nullam rhoncus aliquam
              metus. Aliquam erat volutpat. Integer rutrum, orci vestibulum ullamcorper ultricies,
              lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Nam quis nulla. Integer
              imperdiet lectus quis justo. Donec vitae arcu. Etiam egestas wisi a erat. Nulla quis diam.</div>
            <div className='button-grid'>
              <Button text='Login' data={props.passDataLogin} />
              <Button text='Sign Up' data={props.passDataSignUp} />
            </div>
          </div>
      )
}

export default Welcome;