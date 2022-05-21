import Button from "./Button";
function Welcome() {
  return (
          <div className='welcome-grid'>
            <h1>Welcome to card game!</h1>
            <div className='login-grid'>
              <Button text='Login' />
              <Button text='Sign Up' />
            </div>
          </div>
      )
}

export default Welcome;