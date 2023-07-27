import React from 'react';
import Cookies from 'js-cookie';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import AuthPage from '../pages/auth/AuthPage';
import HomePage from '../pages/home/HomePage';

const isAuthenticated = () => {
  const token = Cookies.get('token');
  return !!token;
};

const AppRouter = () => {
  const isUserAuthenticated = isAuthenticated();

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
