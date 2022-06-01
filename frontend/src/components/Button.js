function Button(props) {
  return (
      <button className='btn' onClick={props.data}>{props.text}</button>
  )
}

export default Button;