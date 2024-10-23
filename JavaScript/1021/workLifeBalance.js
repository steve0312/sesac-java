const isWeekend = false;
const nowTime = 20;

if (isWeekend === true || nowTime < 9 || nowTime > 18) {
  console.log('휴식 시간');
} else {
  console.log('일과 시간');
}
