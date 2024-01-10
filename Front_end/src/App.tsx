import "./App.css";
import { Card } from "./components/card/Card";
import { Food } from "./interface/FoodData";
import { useState } from "react";
import { useFoodData } from "./hooks/useFoodData";
import { CreateModal } from "./components/create-modal/create-modal";

function App() {
  const { data } = useFoodData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen((prev) => !prev);
  };
  return (
    <div className="container">
      <h1>Cardápio</h1>
      <div className="card-grid">
        {data?.map((foodData: Food) => (
          <Card
            key={foodData.id}
            name={foodData.name}
            image={foodData.image}
            price={foodData.value}
          />
        ))}
      </div>
      {isModalOpen && <CreateModal closeModal={handleOpenModal} />}
      <button className="btn" onClick={handleOpenModal}>
        Novo
      </button>
    </div>
  );
}

export default App;
