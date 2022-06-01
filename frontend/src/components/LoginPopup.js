function LoginPopup (props) {
  return (
      <div className='overlay'>
          <div className='login-popup animate' >
              <form>
                <label>Username</label>
                <input className='form-input'/>
                <label>Password</label>
                <input className='form-input'/>
                <button className='btn'>Login</button>
                <div className='close-form'  onClick={props.data}>
                </div>
              </form>
          </div>
      </div>
  )
}

export default LoginPopup;