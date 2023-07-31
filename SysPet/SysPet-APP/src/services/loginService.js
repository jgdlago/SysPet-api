import { setAuthToken } from "./authToken";
import axiosInstance from '../configs/axiosConfig';
import Cookies from 'js-cookie';

export const login = async (email, password) => {
  const userData = {
    email: email,
    password: password,
  };

  try {
    const response = await axiosInstance.post('/auth/signin', userData);
    const token = response.data;

    setAuthToken(token);
    //   window.location.reload();
  } catch (error) {
    console.error('Erro ao logar: ', error);
  }
};

export const getBasicPetshopInfo = async (email) => {
  try {
    const response = await axiosInstance.get(`/Petshop/email/${email}`);
    const userDetails = response.data;

    Cookies.set('petshop_info', JSON.stringify(userDetails));

    return userDetails;
  } catch (error) {
      console.error('Erro ao obter informações do petshop:', error);
      throw error;
  }
};
