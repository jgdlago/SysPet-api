import React, { useState } from 'react';
import './myPetshop.css';
import InputInfo from '../input/InputInfo';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPenToSquare } from '@fortawesome/free-solid-svg-icons';


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

      <div className="myPetshop-header">
        <h1>{petshopInfo.nome}</h1>
      </div>

      <div className="myPetshop-infos">

        <InputInfo className="myPetshop-input" title="Nome" value={petshopInfo.nome} isEditing={isEditing} />
        <InputInfo className="myPetshop-input" title="Endereço" value={petshopInfo.endereco} isEditing={isEditing} />
        <InputInfo className="myPetshop-input" title="Telefone" value={petshopInfo.telefone} isEditing={isEditing} />
        <InputInfo className="myPetshop-input" title="E-mail" value={petshopInfo.email} isEditing={isEditing} />

        <span className="editIcont" onClick={() => setIsEditing(!isEditing)}> <FontAwesomeIcon icon={faPenToSquare} /> Editar informações </span>

      </div>

    </div>
  );
}

export default MyPetshop;
