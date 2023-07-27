import axios from "axios";
import { setAuthToken } from "./authToken";

export const login = async (email, password) => {
    const userData = {
        email: email,
        password: password
    };
  
    try {
        const response = await axios.post('http://localhost:8080/auth/signin', userData);
        const token = response.data;

        setAuthToken(token);
        window.location.reload();
      
    } catch (error) {
        console.error('Erro ao logar: ', error);
    }
}