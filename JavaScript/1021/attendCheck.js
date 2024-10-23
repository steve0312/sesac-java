const names = ['jun', 'beemo', 'ken', 'lynda'];

for (let index in names) {
  let num = parseInt(index);

  console.log(`${num + 1}번 ${names[index]}`);
}
