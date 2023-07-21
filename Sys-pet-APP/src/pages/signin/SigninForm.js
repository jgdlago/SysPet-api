import petIcon from '../../assets/petIcon.png';
import './signinStyle.css';
import ErrorTooltip from '../../components/tooltips/ErrorTooltip';
import { useState } from 'react';
import { validateLoginForm } from '../../utils/FormUtils';
import InputForm from '../../components/input/InputForm';

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

            <div className="container-generic-form-btn">
              <button type="submit" className="generic-form-btn">Login</button>
            </div>

            <ErrorTooltip message={'Preencha os dados de login'} show={showErrorTooltip} />

            <div className='text-center-generic'>
              <span className='text-generic1'>Não possui conta?</span>
              <a className="text-generic2" onClick={handleScrollToBottom}>Criar conta</a>
            </div>

          </form>
        </div>
      </div>

    );
}

export default SigninForm;