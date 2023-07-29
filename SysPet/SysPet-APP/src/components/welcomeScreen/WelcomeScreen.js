import React from 'react';
import './welcomeScreen.css';
import '../../styles.css';

function WelcomeScreen() {
  return (
    <div className="welcome-container">
      <h1>Bem-vindo ao SysPET</h1>
      <p>
      O SysPET é um sistema de gerenciamento completo para serviços de petshops. Com ele, você terá total controle sobre os serviços oferecidos,
       os clientes atendidos e os animais cuidados em sua loja.
      </p>

      <p>
      Nossa plataforma foi desenvolvida com o objetivo de facilitar o dia a dia do seu negócio, proporcionando uma experiência intuitiva e eficiente. 
      Desde a agenda de atendimentos até o checklist de serviços, o SysPET torna tudo mais prático e organizado.
      </p>

      <p>
      Estamos aqui para ajudar a impulsionar o seu petshop ao sucesso, e agradecemos por nos escolher como parceiros!
      </p>

      <h2>Contato do Suporte</h2>
      <ul>
        <li>Email: suporte@syspet.com</li>
        <li>Telefone: (XX) XXXX-XXXX</li>
      </ul>
    </div>
  );
}

export default WelcomeScreen;
