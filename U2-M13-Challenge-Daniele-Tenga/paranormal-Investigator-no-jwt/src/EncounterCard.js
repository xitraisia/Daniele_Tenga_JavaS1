function EncounterCard({ encounter, notify }) {

const encounterInvestigator = encounter.investigators;

function investigatorsOnEncounter() {

    for (let i = 0; i < encounterInvestigator.length; i++) {
        const element = encounterInvestigator[i];
        return (<li> {element.firstName}, { element.lastName}</li> 
            )
    }
}

    
    function handleDelete() {
        fetch(`http://localhost:8080/api/encounter/${encounter.id}`, { method: "DELETE" })
            .then(() => notify({ action: "delete", encounter }))
            .catch(error => notify({ action: "delete", error }));
    }

    return (
        <div className="col">
            <div className="card">
                <div className="card-header">
                    {encounter.brief}
                </div>
                {encounter.imageUrl && <img src={encounter.imageUrl} className="card-img-top" alt={encounter.brief} />}
                <div className="card-body">
                    <h5>TimeStamp</h5>
                    <p className="card-text">{encounter.dateTime}</p>
                    <h5>Details</h5>
                    <p className="card-text">{encounter.details}</p>
                    <h5>Investigator</h5>
                    <p className="card-text">{investigatorsOnEncounter()}</p>
                </div>
                <div className="card-footer d-flex justify-content-center">
                    <button className="btn btn-danger mr-3" onClick={handleDelete}>Delete</button>
                    <button className="btn btn-secondary" onClick={() => notify({ action: "edit-form", encounter })}>Edit</button>
                </div>
            </div>
        </div>
    );
}

export default EncounterCard;