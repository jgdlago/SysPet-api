import petIcon from '../../assets/petIcon.png';
import { useState } from 'react';
import './signupStyle.css';
import '../genericStyles/genericFormStyle.css'
import ErrorTooltip from '../../components/tooltips/ErrorTooltip';
import { validateRegisterForm } from '../../utils/FormUtils';
import { createPetshopForm } from '../../services/createPetshopService';
import Loading from '../../components/loading/Loading';
import InputForm from '../../components/input/InputForm'

function SignupForm() {

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [petshopName, setPetshopName] = useState("")
    const [address, setAdress] = useState("")
    const [phone, setPhone] = useState("")
    const [showErrorTooltip, setShowErrorTooltip] = useState(false);
    const [showLoading, setShowLoading] = useState(false);

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
        setShowLoading(true);
        createPetshopForm(petshopName, email, phone, address);
      }
    };

    return (

        <div className="container-genericForm">
        <div className="wrap-register">
          <form onSubmit={handleFormSubmit} className="generic-form">

            <span className="generic-form-title">Cadastre seu Petshop!</span>  
            <span className="generic-form-title">
              <img src={petIcon} alt="SysPET" />
            </span>

            <InputForm type="email" value={email} onChange={setEmail} placeholder="E-mail" />

            <InputForm type="text" value={petshopName} onChange={setPetshopName} placeholder="Nome do Petshop" />

            <InputForm type="text" value={address} onChange={setAdress} placeholder="Endereço" />

            <InputForm type="tel" value={phone} onChange={setPhone} placeholder="Telefone (WhatsApp)" />

            <div className="container-generic-form-btn">
              <button type="submit" className="generic-form-btn">Cadastrar</button>
            </div>

            <ErrorTooltip message={'Preencha os dados de login'} show={showErrorTooltip} />

            <div className='text-center-generic'>
              <span className='text-generic1'>Já possui conta?</span>
              <a className="text-generic2" onClick={handleScrollToTop}>Logar</a>
            </div>

          </form>
          { showLoading && <Loading /> }
        </div>
      </div>

    );
}

export default SignupForm;