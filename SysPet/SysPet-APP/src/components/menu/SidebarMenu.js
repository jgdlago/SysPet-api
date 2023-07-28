import React, { useState } from 'react';
import './sidebarMenu.css';
import petIcon from '../../assets/petIcon.png';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faShop, faPeopleGroup, faDog, faCalendarCheck, faListCheck, faEllipsis, faX } from '@fortawesome/free-solid-svg-icons';

function SidebarMenu() {
  const [menuVisible, setMenuVisible] = useState(false);

  const toggleMenu = () => {
    setMenuVisible(!menuVisible);
  };

  return (
    <div className="sidebarMenu-container">
      <button className="toggleButton" onClick={toggleMenu}>
        <FontAwesomeIcon icon={menuVisible ? faX : faEllipsis} />
      </button>

      <div className={`menuBar-container ${menuVisible ? '' : 'menuHidden'}`}>
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
    </div>
  );
}

export default SidebarMenu;
