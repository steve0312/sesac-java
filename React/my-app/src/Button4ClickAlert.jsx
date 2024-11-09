export default function Button(props) {
  // console.log(props);

  const { children, onClick, backgroundColor } = props;
  // console.log("children : ", children);

  return (
    <button onClick={onButtonClick} style={{ backgroundColor, color: 'white' }}>
      {children}
    </button>
  );
}
