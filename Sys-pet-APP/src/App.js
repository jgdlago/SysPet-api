
import './styles.css';
import SigninForm from './pages/signin/SigninForm';
import SignupForm from './pages/signup/SignupForm';

function App() {
  return (
    <div className="container">
      <SigninForm />
      <SignupForm />
    </div>
  );
}

export default App;
