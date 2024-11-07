import React from 'react';

export default function Products() {
  const products = [
    { id: 1, name: '노트북', price: 55000 },
    { id: 2, name: '마우스', price: 15000 },
    { id: 3, name: '키보드', price: 45000 },
    { id: 4, name: '마우스패드', price: 8000 },
    { id: 5, name: '모니터', price: 150000 },
  ];

  const over3ManProducts = products.filter((product) => {
    const price = product.price;
    return price > 30000;
  });

  const productJSX = over3ManProducts.map((product) => {
    const { id, name, price } = product;
    return (
      <div style={{ margin: '1rem' }}>
        <div>상품명 : {name}</div>
        <div>가격 : {price}원</div>
      </div>
    );
  });

  return <div>{productJSX}</div>;
}
