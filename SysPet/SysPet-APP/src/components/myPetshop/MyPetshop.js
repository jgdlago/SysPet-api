import React, { useState } from 'react';
import './myPetshop.css';

function MyPetshop() {
  // Exemplo de informações do petshop (pode ser obtido de uma API ou estado)
  const petshopInfo = {
    nome: "Meu Petshop",
    endereco: "Rua das Flores, 123",
    telefone: "(XX) XXXX-XXXX",
    email: "contato@meupetshop.com",
  };

  // Estado para controlar a edição das informações
  const [isEditing, setIsEditing] = useState(false);

  return (
    <div className="myPetshop-container">
      <div className="petshopInfo">
        <h1>NOME DO PETSHOP</h1>
        <div className="petshopInfo-input">

        {/* Desenvolver componente que receba valor do campo
            e isEditing caso não seja editável mostrar apenas span 
            com a info, caso seja mostra input que recebe nova informação */}

        </div>
      </div>
    </div>
  );
}

export default MyPetshop;
