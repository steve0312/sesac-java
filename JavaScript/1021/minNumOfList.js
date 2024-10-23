const nums = [10, 6, 8, 5, 4, 2, 3, 11];

let min_num = nums[0];

for (let index in nums) {
  if (nums[++index] < min_num) {
    min_num = nums[index];
  }
}
console.log(`최소값 : ${min_num}`);