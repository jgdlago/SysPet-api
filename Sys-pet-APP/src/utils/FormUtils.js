
export const validateLoginForm = (email, password) => {
    return email.trim() !== '' || password.trim() !== '';
  };

export const validateRegisterForm = (email, petshopName, address, phone) => {
    if (email.trim() === '' 
        || petshopName.trim() === '' 
        || address.trim() === '' 
        || phone.trim() === '') 
        {
        return false;
    }
    return true;
};

