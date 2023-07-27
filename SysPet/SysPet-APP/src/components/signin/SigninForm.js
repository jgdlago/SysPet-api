import petIcon from '../../assets/petIcon.png';
import './signinStyle.css';
import ErrorTooltip from '../../components/tooltips/ErrorTooltip';
import { useState } from 'react';
import { validateLoginForm } from '../../utils/FormUtils';
import InputForm from '../../components/input/InputForm';
import GenericFormButton from '../../components/button/GenericFormButton';
import GenericAlertMessage from '../../components/message/GenericMessage';
import { login } from '../../services/loginService';

function SigninForm() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [showErrorTooltip, setShowErrorTooltip] = useState(false);

    const handleScrollToBottom = () => {
      window.scrollTo({
        top: document.body.scrollHeight,
        behavior: 'smooth',
      });
    };

    const handleFormSubmit = (e) => {
      e.preventDefault();
  
      if (!validateLoginForm(email, password)) {
        setShowErrorTooltip(true);
        setTimeout(() => {
          setShowErrorTooltip(false);
        }, 5000);

      } else {
        login(email, password);
        console.log('Formulário enviado!');
      }
    };

    return (

      <div className="container-genericForm">
        <div className="wrap-login">
          <form onSubmit={handleFormSubmit} className="generic-form">

            <span className="generic-form-title">Bem Vindo!</span>
            <span className="generic-form-title">
              <img src={petIcon} alt="SysPET" />
            </span>
            
            <InputForm type="email" value={email} onChange={setEmail} placeholder="E-mail" />

            <InputForm type="password" value={password} onChange={setPassword} placeholder="Senha" />

            <GenericFormButton text="Login" onClick={handleFormSubmit} />

            <ErrorTooltip message={'Preencha os dados de login'} show={showErrorTooltip} />

            <GenericAlertMessage message1="Deseja criar uma conta?" message2="Cadastrar" onClick={handleScrollToBottom} />

          </form>
        </div>
      </div>

    );
}

export default SigninForm;