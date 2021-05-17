function InvestigatorCard({ investigator, notify }) {

    function handleDelete() {
        fetch(`http://localhost:8080/api/investigator/${investigator.id}`, { method: "DELETE" })
            .then(() => notify({ action: "delete", investigator }))
            .catch(error => notify({ action: "delete", error }));
    }

    const listOfInvestigators = (investigator.firstName, investigator.lastName);

    function investigatorsOnEncounter() {

        for (let i = 0; i < listOfInvestigators.length; i++) {
            const element = listOfInvestigators[i];
            return (<li> {element.firstName}, { element.lastName}</li> 
                )
        }
    }

    return (
        <div className="col">
            <div className="card">
                <div className="card-body">
                    {/* <h5>Name</h5>
                    <p className="card-text">{investigator.firstName + " " + investigator.lastName}</p> */}
                    <h5>First Name</h5>
                    <p className="card-text">{investigator.firstName}</p>
                    <h5>Last Name</h5>
                    <p className="card-text">{investigator.lastName}</p>
                </div>
                <div className="card-footer d-flex justify-content-center">
                    <button className="btn btn-danger mr-3" onClick={handleDelete}>Delete</button>
                    <button className="btn btn-secondary" onClick={() => notify({ action: "edit-form", investigator })}>Edit</button>
                </div>
            </div>
        </div>
    );
}

export default InvestigatorCard;