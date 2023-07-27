import Cookies from 'js-cookie';

const TOKEN_KEY = 'token';

export const setAuthToken = (token) => {
  if (token) {
    Cookies.set(TOKEN_KEY, token);
  } else {
    Cookies.remove(TOKEN_KEY);
  }
};

export const getAuthToken = () => {
  return Cookies.get(TOKEN_KEY);
};

export const removeAuthToken = () => {
  Cookies.remove(TOKEN_KEY);
};