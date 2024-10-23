const nums = [10, 6, 8, 5, 4];
let reversedNum = [];

// 방법1
let count = nums.length;

for (let index in nums) {
  reversedNum[index] = nums[--count];
}

console.log(reversedNum);

/* 
// 방법2
for (let index in nums_2) {
  let newIndex = nums_2.length - 1 - index;
  let newValue = nums_2[newIndex];

  reversedNum.push(newValue);
}
console.log(reversedNum);

// 방법3
for (let num of nums) {
  reversedNum.unshift(num);
}
console.log(reversedNum);
*/
