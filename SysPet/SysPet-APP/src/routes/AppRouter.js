import React, { useState, useEffect } from 'react';
import Cookies from 'js-cookie';
import axios from 'axios';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import AuthPage from '../pages/auth/AuthPage';
import HomePage from '../pages/home/HomePage';

const isAuthenticated = async () => {
  const token = Cookies.get('token');
  let tokenIsValid = false;

  if (token && token.trim()) {
    try {
      const response = await axios.post("http://localhost:8080/auth/validateToken", { token: token });
      tokenIsValid = response.data;
    } catch (error) {
      console.error("Error validating token:", error);
    }
  }

  return tokenIsValid;
};


const AppRouter = () => {
  const [isUserAuthenticated, setIsUserAuthenticated] = useState(false);

  useEffect(() => {
    const checkAuthentication = async () => {
      const authenticated = await isAuthenticated();
      setIsUserAuthenticated(authenticated);
    };

    checkAuthentication();
  }, []);

  return (
    <Router>
      <Routes>
        {!isUserAuthenticated && <Route path="/*" element={<AuthPage />} />}
        {isUserAuthenticated && <Route path="/*" element={<HomePage />} />}
      </Routes>
    </Router>
  );
};

export default AppRouter;
