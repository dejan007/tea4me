import React, { useEffect, useState } from 'react';
import './teaComponent.scss';

const TeaComponent = ({ teasToShow, idsToSend }) => {
    const [noTeaText, setNoTeaText] = useState(false);

    useEffect(() => {
        if (idsToSend.length !== 0 && teasToShow.length === 0) {
            setTimeout(() => {
                setNoTeaText(true);
            }, 100)
        } else {
            setNoTeaText(false);
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps        
    }, [teasToShow]);


    return (
        <div>

            <div className="teas-container">
                {idsToSend.length === 0 &&
                    <div className="no-conditions-text">Please select 1-3 conditions</div>
                }

                {noTeaText === true && teasToShow === 0 &&
                    <div className="no-result-text">There are no teas for this combination of conditions. Please try another one.</div>

                }
                {teasToShow && teasToShow.map((tea, i) => (
                    <div id={i} className="one-tea-container">
                        <img src={"data:image/jpeg;base64," + tea.image} className="tea-image" alt=""></img>
                        <div className="header-tea-text"><h2>{tea.name}</h2></div>
                        <div className="tea-description">{tea.description}
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default TeaComponent;