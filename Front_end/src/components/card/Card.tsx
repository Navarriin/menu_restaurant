import "./Card.css";

interface CardProps {
  name: string;
  image: string;
  price: number;
}

export function Card({ name, image, price }: CardProps) {
  return (
    <div>
      <img src={image} alt="" />
      <h2>{name}</h2>
      <p>
        <b>Valor:</b>
        {price}
      </p>
    </div>
  );
}
