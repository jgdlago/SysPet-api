import SidebarMenu from '../../components/menu/SidebarMenu';
import WelcomeScreen from '../../components/welcomeScreen/WelcomeScreen';
import '../../styles.css'
import './homePage.css'

function HomePage() {
  return (
    <div className="homePage-container">
      <SidebarMenu />
      <WelcomeScreen />
    </div>
  );
}

export default HomePage;
