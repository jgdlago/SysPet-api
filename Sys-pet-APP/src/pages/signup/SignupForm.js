import petIcon from '../../assets/petIcon.png';
import { useState } from 'react';
import './signupStyle.css';
import '../genericStyles/genericFormStyle.css'
import ErrorTooltip from '../../components/tooltips/ErrorTooltip';
import { validateRegisterForm } from '../../utils/FormUtils';
import { createPetshopForm } from '../../services/createPetshopService';
import Loading from '../../components/loading/Loading';
import InputForm from '../../components/input/InputForm'
import GenericFormButton from '../../components/button/GenericFormButton';
import GenericAlertMessage from '../../components/message/GenericMessage';

function SignupForm() {

    const [email, setEmail] = useState("")
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

            <GenericFormButton text="Cadastrar" onClick={handleFormSubmit} />

            <ErrorTooltip message={'Preencha os dados de login'} show={showErrorTooltip} />

            <GenericAlertMessage message1="Já possui conta?" message2="Logar" onClick={handleScrollToTop} />

          </form>
          { showLoading && <Loading /> }
        </div>
      </div>

    );
}

export default SignupForm;