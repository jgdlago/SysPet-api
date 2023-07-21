import React from 'react';

const GenericMessage = ({ message1, message2, onClick }) => {
  return (
    <div className='text-center-generic'>
      <span className='text-generic1'>{message1}</span>
      <a className="text-generic2" onClick={onClick}>{message2}</a>
    </div>
  );
};

export default GenericMessage;
