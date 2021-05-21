//function TwoButtons(props) {
  function TwoButtons({ update }) {
    // const theFunction = props.updateFeeling;
    return (
      <>
        <button
          type="button"
          value="Admin"
          onClick={() => update("Admin")}
          className="btn btn-outline-primary"
        >
          Admin
        </button>
        <button
          type="button"
          value="Customer"
          onClick={() => update("Customer")}
          className="btn btn-outline-secondary"
        >
          Customer
        </button>
      </>
    );
  }
  export default TwoButtons;