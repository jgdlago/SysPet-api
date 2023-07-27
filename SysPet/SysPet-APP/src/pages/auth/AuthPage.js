import SigninForm from "../../components/signin/SigninForm";
import SignupForm from "../../components/signup/SignupForm";

function AuthPage() {
    return (
      <div className="container">
        <SigninForm />
        <SignupForm />
      </div>
    );
  }

export default AuthPage;