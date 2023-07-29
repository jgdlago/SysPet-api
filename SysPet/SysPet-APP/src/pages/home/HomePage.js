import React, { useState } from 'react';
import SidebarMenu from '../../components/menu/SidebarMenu';
import WelcomeScreen from '../../components/welcomeScreen/WelcomeScreen';
import '../../styles.css';
import './homePage.css';

function HomePage() {
  const [menuVisible, setMenuVisible] = useState(false);

  return (
    <div className="homePage-container">
      <SidebarMenu menuVisible={menuVisible} />
      <div className={`content-container ${menuVisible ? "menu-open" : ""}`}>
        <WelcomeScreen />
      </div>
    </div>
  );
}

export default HomePage;
