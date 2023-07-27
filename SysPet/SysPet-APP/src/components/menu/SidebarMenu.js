import './sidebarMenu.css'
import petIcon from '../../assets/petIcon.png'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faShop, faPeopleGroup, faDog, faCalendarCheck, faX, faListCheck } from '@fortawesome/free-solid-svg-icons';

function SidebarMenu() {
    return (
    <div className="sidebarMenu-container">

      <FontAwesomeIcon className="quitIcon" icon={faX} />

      <img className="petLogo" src={petIcon} alt="SysPET" />

      <div className="sidebarMenu-list">
        <ul>
        <li><FontAwesomeIcon className="menuIcon" icon={faShop} /> Meu Petshop</li>
        <li><FontAwesomeIcon className="menuIcon" icon={faPeopleGroup} /> Clientes</li>
        <li><FontAwesomeIcon className="menuIcon" icon={faDog} /> Animais</li>
        <li><FontAwesomeIcon className="menuIcon" icon={faCalendarCheck} /> Agenda</li>
        <li><FontAwesomeIcon className="menuIcon" icon={faListCheck} /> Checklist de serviço</li>
        </ul>
      </div>
    </div>
    );
  }
  
  export default SidebarMenu;