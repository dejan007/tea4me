import React, { useEffect, useState } from 'react';
import './home.scss';
import image from './../../resources/weed.jpg';
import SelectorComponentContainer from '../SelectorComponent/SelectorComponentContainer';
import TeaComponent from '../TeaComponent/TeaComponent';


const Home = props => {
  const [defaultConditions, setDefaultConditions] = useState([]);
  const [teasToShow, setTeasToShow] = useState([]);
  const [idsToSend, setIdsToSend] = useState([]);

  const {REACT_APP_HOME} = process.env;
  

  useEffect(() => {
    fetch(REACT_APP_HOME + "conditions").then(res => res.json()).then(json => {
      setDefaultConditions(json);
    }).catch(reason => { console.log("backend not working") });
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <div className="body-container">
      <div className="header-container">
        <img src={image} className="header-image" />
        <h1 className="header-text">Only place where we choose the right Tea for you !</h1>
        <SelectorComponentContainer
          defaultConditions={defaultConditions}
          setTeasToShow={setTeasToShow}
          idsToSend={idsToSend}
          setIdsToSend={setIdsToSend} />

        <TeaComponent
          teasToShow={teasToShow}
          idsToSend={idsToSend} />
      </div>
      <div className="footer">
        <p className="footer-text">For any suggestions and question, please contact us at: needATea@gmail.com</p>
      </div>
    </div>
  );
};


export default Home;