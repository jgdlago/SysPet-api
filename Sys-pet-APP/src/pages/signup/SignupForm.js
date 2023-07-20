import petIcon from '../../assets/petIcon.png';
import { useState } from 'react';

import './signupStyle.css';
import ErrorTooltip from '../../components/tooltips/ErrorTooltip';
import { validateRegisterForm } from '../../utils/FormUtils';
import { createPetshopForm } from '../../services/createPetshopService';

function SignupForm() {

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [petshopName, setPetshopName] = useState("")
    const [address, setAdress] = useState("")
    const [phone, setPhone] = useState("")
    const [showErrorTooltip, setShowErrorTooltip] = useState(false);

    const handleScrollToTop = () => {
      window.scrollTo({
        top: 0,
        behavior: 'smooth',
      });
    };

    const handleFormSubmit = (e) => {
      e.preventDefault();
  
      if (!validateRegisterForm(email, petshopName, address, phone)) {
        setShowErrorTooltip(true);
        setTimeout(() => {
          setShowErrorTooltip(false);
        }, 5000);
      } else {
        createPetshopForm(petshopName, email, phone, address);
      }
    };

    return (

        <div className="container-register">
        <div className="wrap-register">
          <form onSubmit={handleFormSubmit} className="register-form">

            <span className="register-form-title">Cadastre seu Petshop!</span>  
            <span className="register-form-title">
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
                className={petshopName !== "" ? 'has-val input' : 'input'} 
                type="text" 
                value={petshopName}
                onChange={e => setPetshopName(e.target.value)}
                />
              <span className="focus-input" data-placeholder="Nome do Petshop"></span>
            </div>

            <div className="wrap-input">
              <input 
                className={address !== "" ? 'has-val input' : 'input'} 
                type="text" 
                value={address}
                onChange={e => setAdress(e.target.value)}
                />
              <span className="focus-input" data-placeholder="Endereço"></span>
            </div>

            <div className="wrap-input">
              <input 
                className={phone !== "" ? 'has-val input' : 'input'} 
                type="tel" 
                value={phone}
                onChange={e => setPhone(e.target.value)}
                />
              <span className="focus-input" data-placeholder="Telefone (WhatsApp)"></span>
            </div>

            <div className="container-register-form-btn">
              <button type="submit" className="register-form-btn">Cadastrar</button>
            </div>

            <ErrorTooltip message={'Preencha os dados de login'} show={showErrorTooltip} />

            <div className='text-center-register'>
              <span className='text-register1'>Já possui conta?</span>
              <a className="text-register2" onClick={handleScrollToTop}>Logar</a>
            </div>

          </form>
        </div>
      </div>

    );
}

export default SignupForm;