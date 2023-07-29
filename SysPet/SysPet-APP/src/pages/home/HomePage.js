import React, { useState } from 'react';
import SidebarMenu from '../../components/menu/SidebarMenu';
import WelcomeScreen from '../../components/welcomeScreen/WelcomeScreen';
import '../../styles.css';
import './homePage.css';

function HomePage(props) {
  const [menuVisible, setMenuVisible] = useState(false);

  return (
    <div className="homePage-container">
      <SidebarMenu menuVisible={menuVisible} />
      <div className={`content-container ${menuVisible ? "menu-open" : ""}`}>
        {React.Children.count(props.children) > 0 ? props.children : <WelcomeScreen />}
      </div>
    </div>
  );
}

export default HomePage;
