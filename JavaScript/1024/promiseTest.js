const newPromise = new Promise((resolve, reject) => {
  const flag = true;

  // flag가 true면 then 메서드가 실행되고, false이면 catch 메서드가 실행됨
  // finally 메서드는 비동기 작업의 성공, 실패 여부와 관계없이 실행됨
  if (flag === true) {
    resolve('작업 성공');
  } else {
    reject('작업 실패');
  }
});

newPromise
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.error(error);
  })
  .finally(() => {
    console.log('작업 완료');
  });
