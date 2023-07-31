import axios from 'axios';

export const createPetshopForm = async (petshopName, email, phone, address) => {
  const userData = {
    nome: petshopName,
    email: email,
    phone: phone,
    Addres: address
  };

  try {
    const response = await axios.post('http://localhost:8080/auth/signup', userData);
    console.log('Usuário cadastrado:', response.data);
  } catch (error) {
    console.error('Erro ao cadastrar usuário:', error);
  }
};
