import { useState, useEffect } from 'react';
import InvestigatorCard from './InvestigatorCard.js';
import InvestigatorForm from './InvestigatorForm.js';

function Investigators() {

    const [investigators, setInvestigators] = useState([]);
    const [showInvestigator, setShowInvestigator] = useState(false);
    const [scopedInvestigator, setScopedInvestigator] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/api/investigator")
            .then(response => response.json())
            .then(result => setInvestigators(result))
            .catch(console.log);
    }, []);

    function addClick() {
        const now = new Date();
        const year = now.getFullYear();
        const month = new Intl.DateTimeFormat("en-US", { month: "short" }).format(now);
        const day = new Intl.DateTimeFormat("en-US", { day: "2-digit" }).format(now);
        const time = new Intl.DateTimeFormat("en-US", { hour: "2-digit", minute: "2-digit" })
            .format(now).replace(" ", "");
        console.log(time);
        setScopedInvestigator({ id: 0, brief: "", details: "", dateTime: `${day}-${month}-${year} ${time}` });
        setShowInvestigator(true);
    }

    function notify({ action, investigator, error }) {

        if (error) {
            setError(error);
            setShowInvestigator(false);
            return;
        }

        switch (action) {
            case "add":
                setInvestigators([...investigators, investigator]);
                break;
            case "edit":
                setInvestigators(investigators.map(i => {
                    if (i.id === investigator.id) {
                        return investigator;
                    }
                    return i;
                }));
                break;
            case "edit-form":
                setScopedInvestigator(investigator);
                setShowInvestigator(true);
                return;
            case "delete":
                setInvestigators(investigators.filter(i => i.id !== investigator.id));
                break;
        }
        setShowInvestigator(false);
    }

    if (showInvestigator) {
        return <InvestigatorForm investigator={scopedInvestigator} notify={notify} />
    }

    return (
        <>
            <div className="row mt-2">
                <div className="col-8">
                    <h1>Investigator</h1>
                </div>
                <div className="col">
                    <button className="btn btn-primary" onClick={addClick}>Add an Investigator</button>
                </div>
            </div>
            {error && <div className="alert alert-danger">{error}</div>}
            {investigators.length === 0 ? <div className="alert alert-warning">No Investigator</div>
                : (<div className="row row-cols-3">
                    {investigators.map(i => <InvestigatorCard key={i.id} investigator={i} notify={notify} />)}
                </div>)}
        </>
    )
}

export default Investigators;