// import Article from './Article';
// import Todos from './Todos';
// import Component from './Component';
// import Welcome from './Welcome';
// import Card from './Card';
// import Button from './Button';
// import ButtonChildren from './ButtonChildren';
// import Login from './Login';
// import Page from './Page';
// import OtherPage from './OtherPage';
// import List1 from './List1';
// import List2 from './List2';
// import NameList from './nameList';
// import UserData from './UserData';
// import Products from './Products';
// import DogPage from './DogPage';
// import ButtonContainer from './ButtonContainer';
// import Menu from './Menu';
// import ButtonClickAlert from './ButtonClickAlert';
// import BoxColorChange from './BoxColorChange';
// import InputText from './InputText';
// import Button4ClickAlert from './Button4ClickAlert';
import Counter from './Counter';
import CounterButton from './CounterButton';
import InputTextShow from './InputTextShow';
import InputColorShow from './InputColorShow';

function App() {
  return (
    <>
      {/* <Article></Article>
      <Todos></Todos>
      <Component></Component> */}
      {/* <Welcome name={'안녕하세요'}></Welcome> */}
      {/* <Card title="제목123" content="내용" width="200px" height="200px"></Card> */}
      {/* <Button backgroundColor="blue" text="확인"></Button>
      <Button backgroundColor="red" text="취소"></Button>
      <Button backgroundColor="gray" text="보류"></Button>
      <Button backgroundColor="pink" text="1억년"></Button> */}
      {/* <ButtonChildren backgroundColor="blue">확인</ButtonChildren>
      <ButtonChildren backgroundColor="red">취소</ButtonChildren>
      <ButtonChildren backgroundColor="gray">보류</ButtonChildren>
      <ButtonChildren backgroundColor="pink">1억년</ButtonChildren> */}
      {/* <Login></Login> */}
      {/* <Page></Page> */}
      {/* <OtherPage></OtherPage> */}
      {/* <List1></List1> */}
      {/* <List2></List2> */}
      {/* <NameList></NameList> */}
      {/* <UserData></UserData> */}
      {/* <Products></Products> */}
      {/* <DogPage></DogPage> */}
      {/* <ButtonContainer></ButtonContainer> */}
      {/* <Menu></Menu> */}

      {/* <ButtonClickAlert></ButtonClickAlert>
      <BoxColorChange></BoxColorChange>
      <InputText></InputText>
      <Button4ClickAlert
        onButtonClick={() => alert('확인 완료!')}
        backgroundColor="blue"
      >
        확인
      </Button4ClickAlert>
      <Button4ClickAlert
        onButtonClick={() => alert('취소 완료!')}
        backgroundColor="tomato"
      >
        취소
      </Button4ClickAlert>
      <Button4ClickAlert
        onButtonClick={() => alert('보류 완료!')}
        backgroundColor="gray"
      >
        보류
      </Button4ClickAlert>
      <Button4ClickAlert
        onButtonClick={() => alert('1억원을 얻었습니다!')}
        backgroundColor="violet"
      >
        1억년
      </Button4ClickAlert> */}

      <Counter></Counter>
      <CounterButton></CounterButton>
      <InputTextShow></InputTextShow>
      <InputColorShow></InputColorShow>
    </>
  );
}

export default App;
