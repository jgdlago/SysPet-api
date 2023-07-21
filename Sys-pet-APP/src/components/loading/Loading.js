import React from 'react';
import './loadingStyle.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSpinner } from '@fortawesome/free-solid-svg-icons';

function Loading() {
    return (
        <div className="loading-overlay">
            <span className='loading-content'><FontAwesomeIcon icon={faSpinner} spinPulse style={{ color: "#6f95ff" }} /></span>
        </div>
    );
}

export default Loading;
