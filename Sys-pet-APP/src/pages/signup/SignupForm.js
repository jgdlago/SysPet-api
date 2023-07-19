
import petIcon from '../../assets/petIcon.png';
import { useState } from 'react';
import './signupStyle.css';

function SignupForm() {

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [petshopName, setPetshopName] = useState("")
    const [address, setAdress] = useState("")
    const [phone, setPhone] = useState("")

    const handleScrollToTop = () => {
      window.scrollTo({
        top: 0,
        behavior: 'smooth',
      });
    };

    return (

        <div className="container-register">
        <div className="wrap-register">
        <span className="register-form-title">Cadastre seu Petshop</span>

          <form className="register-form">

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
              <span className="focus-input" data-placeholder="Email"></span>
            </div>

            <div className="wrap-input">
              <input 
                className={petshopName !== "" ? 'has-val input' : 'input'} 
                type="text" 
                value={petshopName}
                onChange={e => setPetshopName(e.target.value)}
                />
              <span className="focus-input" data-placeholder="Nome do PetShop"></span>
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

          </form>

          <div className="container-register-form-btn">
            <button className="register-form-btn">Cadastrar</button>
          </div>

          <div className='text-center-register'>
            <span className='text-register1'>Já possui conta?</span>
            <a className="text-register2" onClick={handleScrollToTop}>Logar</a>
          </div>

        </div>
      </div>

    );
}

export default SignupForm;