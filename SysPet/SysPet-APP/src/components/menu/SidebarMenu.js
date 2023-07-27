import './sidebarMenu.css'
import petIcon from '../../assets/petIcon.png'

function SidebarMenu() {
    return (
    <div className="sidebarMenu-container">
      <img className="petLogo" src={petIcon} alt="SysPET" />

      <div className="sidebarMenu-list">
        <ul>
        <li>Meu Petshop</li>
        <li>Clientes</li>
        <li>Animais</li>
        <li>Agenda</li>
        </ul>
      </div>
    </div>
    );
  }
  
  export default SidebarMenu;