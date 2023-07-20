import petIcon from '../../assets/petIcon.png';
import './signinStyle.css';
import ErrorTooltip from '../../components/tooltips/ErrorTooltip';

import { useState } from 'react';
import { validateLoginForm } from '../../utils/FormUtils';

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

      <div className="container-login">
        <div className="wrap-login">
          <form onSubmit={handleFormSubmit} className="login-form">

            <span className="login-form-title">Bem Vindo!</span>
            <span className="login-form-title">
              <img src={petIcon} alt="SysPET" />
            </span>
            
            <div className="wrap-input">
              <input 
                className={email !== "" ? 'has-val input' : 'input'} 
                type="email" 
                value={email}
                onChange={e => setEmail(e.target.value)}
                />
              <span className="focus-input" data-placeholder="E-mail"></span>
            </div>

            <div className="wrap-input">
              <input 
                className={password !== "" ? 'has-val input' : 'input'} 
                type="password" 
                value={password}
                onChange={e => setPassword(e.target.value)}
                />
              <span className="focus-input" data-placeholder="Senha"></span>
            </div>

            <div className="container-login-form-btn">
              <button type="submit" className="login-form-btn">Login</button>
            </div>

            <ErrorTooltip message={'Preencha os dados de login'} show={showErrorTooltip} />

            <div className='text-center-login'>
              <span className='text-login1'>Não possui conta?</span>
              <a className="text-login2" onClick={handleScrollToBottom}>Criar conta</a>
            </div>

          </form>
        </div>
      </div>

    );
}

export default SigninForm;