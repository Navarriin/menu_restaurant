import "./create-modal.css";
import { Food } from "../../interface/FoodData";
import { useEffect, useState } from "react";
import { useFoodDataMutate } from "../../hooks/useFoodDataMutate";

interface InputProps {
  label: string;
  value: string | number;
  updateValue(value: any): void;
}

interface ModalProps {
  closeModal(): void;
}

const Input = ({ label, value, updateValue }: InputProps) => {
  return (
    <>
      <label>{label}</label>
      <input
        value={value}
        onChange={(event) => updateValue(event.target.value)}
      />
    </>
  );
};

export function CreateModal({ closeModal }: ModalProps) {
  const [name, setName] = useState("");
  const [value, setValue] = useState(0);
  const [image, setImage] = useState("");
  const { mutate, isSuccess, isLoading } = useFoodDataMutate();

  const submit = () => {
    const foodData: Food = {
      name,
      value,
      image,
    };
    mutate(foodData);
  };

  useEffect(() => {
    if (!isSuccess) return;
    closeModal();
  }, [isSuccess]);

  return (
    <div className="modal-overlay">
      <div className="modal-body">
        <h2>Cadastre um novo item no cardápio</h2>
        <button onClick={closeModal} className="btn-primary">
          Voltar
        </button>
        <form className="input-container">
          <Input label="name" value={name} updateValue={setName} />
          <Input label="price" value={value} updateValue={setValue} />
          <Input label="image" value={image} updateValue={setImage} />
        </form>
        <button onClick={submit} className="btn-secondary">
          {isLoading ? "Postando..." : "postar"}
        </button>
      </div>
    </div>
  );
}
