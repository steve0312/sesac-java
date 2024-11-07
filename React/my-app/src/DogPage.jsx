import React from 'react';

export default function DogPage() {
  const imgUrls = [
    'https://images.dog.ceo/breeds/gaddi-indian/Gaddi.jpg',
    'https://images.dog.ceo/breeds/terrier-westhighland/n02098286_3154.jpg',
    'https://images.dog.ceo/breeds/malamute/n02110063_16752.jpg',
    'https://images.dog.ceo/breeds/bulldog-english/jager-2.jpg',
  ];
  const imgJSX = imgUrls.map((imgUrl) => {
    return (
      <div>
        <img src={imgUrl} alt="" style={{ width: 300, height: 300 }} />
      </div>
    );
  });

  return <div>{imgJSX}</div>;
}
