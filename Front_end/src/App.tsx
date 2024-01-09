import "./App.css";
import { Card } from "./components/card/Card";
import { Food } from "./interface/FoodData";

function App() {
  const data: Food[] = [];
  return (
    <div className="container">
      <h1>Cardápio</h1>
      <div className="card-grid">
        {data.map((foodData: Food) => (
          <Card
            name={foodData.name}
            image={foodData.image}
            price={foodData.value}
          />
        ))}
      </div>
    </div>
  );
}

export default App;
