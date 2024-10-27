const person = {
  name: 'John',
  friends: ['Jane', 'Mike'],

  printFriends_wrong() {
    this.friends.forEach(function (friend) {
      console.log(this.name + ' knows ' + friend); // this는 window
      // printFriends_wrong 메서드 내에서는 name이 존재하지 않아서 undefined 출력
    });
  },

  printFriends_right() {
    this.friends.forEach((friend) => {
      console.log(this.name + ' knows ' + friend); // 정상 작동
      // 화살표 함수로 작성되어 printFriends_right 메서드 내에서 name은 상위 컨텍스트인 person을 의미
    });
  },
};

person.printFriends_wrong();
person.printFriends_right();
