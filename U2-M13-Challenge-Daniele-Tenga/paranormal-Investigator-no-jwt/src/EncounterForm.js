import { useState, useEffect } from 'react';

function EncounterForm({ encounter: initialEncounter, notify }) {

    const [encounter, setEncounter] = useState(initialEncounter);
    const isAdd = initialEncounter.id === 0;
    const [investigator, setInvestigators] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/investigator")
            .then(response => response.json())
            .then(result => setInvestigators(result))
            .catch(console.log);
    }, []);

    function getSelectValues(select) {
        let result = [];
        let options = select && select.options;
        let opt;

        for (let i = 0, iLen=options.length; i<iLen; i++) {
            opt = options[i];

            if(opt.selected){
                result.push(opt.value || opt.text);
            }
        }
        return result;
    }

    function handleChange(evt) {
        const clone = { ...encounter };

        if(evt.target.name === "chabang"){
            console.log(getSelectValues(evt.target))

            // if we have an array with values["1","3"] we need to create an array with values
            // [{id:1}, {id:3}] , then set investigators on the clone with this new array 
            //build that array using a map

            const arrayValue = getSelectValues(evt.target);
            const valueArray = arrayValue.map(i => ({id:i})) ; //this maps through our arrayValue
            clone.investigators = valueArray;
        }
        else{
            clone[evt.target.name] = evt.target.value;
        }
        // clone[evt.target.name] = evt.target.value;
        setEncounter(clone);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        const url = isAdd ? "http://localhost:8080/api/encounter" : `http://localhost:8080/api/encounter/${encounter.id}`;
        const method = isAdd ? "POST" : "PUT";
        const expectedStatus = isAdd ? 201 : 204;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(encounter)
        };

        fetch(url, init)
            .then(response => {
                if (response.status === expectedStatus) {
                    if (isAdd) {
                        return response.json();
                    } else {
                        return encounter;
                    }
                }
                return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
            })
            .then(result => notify({
                action: isAdd ? "add" : "edit",
                encounter: result
            }))
            .catch(error => notify({ error }));

    }

    return (
        <>
            <h1>{encounter.id > 0 ? "Edit" : "Add"} Encounter</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="brief">Brief</label>
                    <input type="text" id="brief" name="brief"
                        className="form-control"
                        value={encounter.brief} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="details">Details</label>
                    <textarea id="details" name="details" className="form-control"
                        value={encounter.details} onChange={handleChange}></textarea>
                </div>
                <div className="mb-3">
                    <label htmlFor="dateTime">Date &amp; Time</label>
                    <input type="text" id="dateTime" name="dateTime"
                        className="form-control"
                        value={encounter.dateTime} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="imageUrl">Image</label>
                    <input type="url" id="imageUrl" name="imageUrl"
                        className="form-control"
                        value={encounter.imageUrl || ""} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <select name="chabang" className="mdb-select md-form" multiple onChange={handleChange} >
                        <option value="" disabled selected>Investigators: Choose your option</option>
                            {investigator.map(e => <option value={e.id} key={e.id} >{e.firstName} {e.lastName}</option>)};
                    </select>
                </div>
                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Save</button>
                    <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "cancel" })}>Cancel</button>
                </div>
            </form>
        </>
    );
}

export default EncounterForm;